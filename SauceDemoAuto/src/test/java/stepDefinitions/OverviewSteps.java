package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import pages.OverviewPage;

public class OverviewSteps {
    OverviewPage overviewPage = new OverviewPage(DriverManager.getDriver().driver);

    @Given("I click on finish button")
    public void clickOnContinueButton(){
        overviewPage.clickOnFinishButton();
    }
}
