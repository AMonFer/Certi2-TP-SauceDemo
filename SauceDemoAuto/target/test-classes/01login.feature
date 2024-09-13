Feature: Login Sauce Demo App

  Background: User login into Sauce Demo
    Given I am in sauce demo web page

    Scenario: Login into Sauce Demo with valid credentials
      Given I set the user name text box with "standard_user"
      And I set the password text box with "secret_sauce"
      When I click on the login button
      Then The home page should be displayed

    Scenario: Login into Sauce Demo with invalid credentials
      Given I set the user name text box with "invalid_user"
      And I set the password text box with "invalid_password"
      When I click on the login button
      Then A error message that says "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario Outline: Login into Sauce Demo with valid credentials
    Given I set the user name text box with "<user>"
    And I set the password text box with "<password>"
    When I click on the login button
    Then The home page should be displayed
    Examples:
      | user          | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  @run
  Scenario Outline: Login into Sauce Demo with invalid credentials
    Given I set the user name text box with "<user>"
    And I set the password text box with "<password>"
    When I click on the login button
    Then A error message that says "Epic sadface: Username and password do not match any user in this service" should be displayed
    Examples:
      | user           | password      |
      | standard_user1 | secret_sauce3 |
      | problem_user2  | secret_sauce4 |
      | standard_user9 | secret_sauce  |
      | problem_user8  | secret_sauce9 |

