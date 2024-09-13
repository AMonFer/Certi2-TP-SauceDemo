package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    WebDriver driver;

    @FindBy(css = "h2.complete-header")
    WebElement thankYouForYourOrderLabel;

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isThankYouMessageDisplayed(String message){
        String actualMessage = thankYouForYourOrderLabel.getText();
        if(actualMessage.equalsIgnoreCase(message)){
            return true;
        }
        return false;
    }
}
