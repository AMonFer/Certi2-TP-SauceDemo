Feature: Home page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: Verify that all products are displayed
      When The home page should be displayed
      Then The product "<products>" should be displayed in the home page
      Examples:
        | products                |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |
        | Sauce Labs Onesie       |
    #Prueba 3 (Verificar el boton logout)
    Scenario: Verify that the user can log out
      When I click on the logout button
      Then I should be redirected to the login page
    #Prueba 5, 6 (filtros)
    Scenario: Verify the filter high to low
      When I select Price high to low in the filter
      Then The prices should be from high to low

    Scenario: Verify the filter low to high
      When I select Price low to high in the filter
      Then The prices should be from low to high

  Scenario Outline: Verify that all products can be added to the cart
    When The home page should be displayed
    And I add to the cart the product "<products>"
    Then The cart icon should display "1"
    And I remove the product "<products>" from the cart
    Examples:
      | products                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |

   #Prueba 12 Quitar productos del carrito
  Scenario Outline: Verify that all products can be removed from the cart
    When The home page should be displayed
    And I add to the cart the product "<products>"
    And I remove the product "<products>" from the cart
    Then The cart icon should have nothing
    Examples:
      | products                          |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Onesie                 |


  #Prueba 20 (Verificar hacer clic sobre nombre del producto)
  Scenario Outline: Verify that the product can be clicked in its name
    When The home page should be displayed
    And I click in the name of the product "<products>"

    Examples:
      | products                          |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Onesie                 |
