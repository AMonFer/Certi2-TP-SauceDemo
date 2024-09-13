package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.YourInformationPage;

import java.util.List;

public class YourInformationSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation) throws InterruptedException {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        // data = ["Mauricio", "Viscarra", "00000"]
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I fill the checkout information with nothing")
    public void fillWithNothing(DataTable checkoutInformation){

        yourInformationPage.setFirstNameTextBox("");
        yourInformationPage.setLastNameTextBox("");
        yourInformationPage.setZipCodeTextBox("");
    }

    @And("A message of error should be displayed")
    public void messageErrorIsDisplayed(){
        Assertions.assertTrue(yourInformationPage.messageErrorIsDisplayed());
    }

    @And("I click on continue button")
    public void clickOnContinueButton() throws InterruptedException {
        yourInformationPage.clickOnContinueButton();
    }
}
