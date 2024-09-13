package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I should be redirected to the login page")
    public void verifyLoginisDisplayed(){
        Assertions.assertTrue(homePage.loginLogoIsDisplayed());
    }


    @And("I click on the logout button")
    public void clickOnLogout(){
        homePage.clickOnLogout();
    }



    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }



    @And("I click in the name of the product {string}")
    public void clickInProduct(String productName){
        homePage.clickOnNameOfProduct(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }

    @And("I select Price high to low in the filter")
    public void selectHighToLow(){
        homePage.selectHighToLow();
    }
    @And("I select Price low to high in the filter")
    public void selectLowToHigh(){
        homePage.selectLowToHigh();
    }

    @And("The prices should be from high to low")
    public void isHighToLow(){
        Assertions.assertTrue(homePage.isHighToLow());
    }

    @And("The prices should be from low to high")
    public void isLowToHigh(){
        Assertions.assertTrue(homePage.isLowToHigh());
    }

    @And("The cart icon should have nothing")
    public void cartIsEmpty(){
        Assertions.assertTrue(homePage.cartIsEmpty());
    }
}
