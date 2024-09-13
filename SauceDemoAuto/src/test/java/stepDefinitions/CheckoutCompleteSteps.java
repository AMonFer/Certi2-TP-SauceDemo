package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutCompletePage;

public class CheckoutCompleteSteps {
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver().driver);

    @And("A message that says {string} should be displayed")
    public void verifyCheckoutCompleteMessage(String message){
        Assertions.assertTrue(checkoutCompletePage.isThankYouMessageDisplayed(message));
    }


}
