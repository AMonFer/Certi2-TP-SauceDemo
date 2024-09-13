package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitle;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement botonLogout;

    @FindBy(className = "login_logo")
    WebElement loginLogo;

    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;




    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        if(sauceDemoTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isProductInHomePage(String productName){
        for(WebElement element : productsTitle){
            if(element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        // add-to-cart-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public void clickOnNameOfProduct(String productName) {

        List<WebElement> titulosProductos = driver.findElements(By.className("inventory_item_name"));
        int totalProductos = titulosProductos.size();
        for(int i = 0; i < totalProductos; i++){
            String tituloProducto = titulosProductos.get(i).getText();
            if(tituloProducto == productName){
                WebElement titulo = titulosProductos.get(i);
                titulo.click();
            }
        }
    }


    public boolean verifyCartIconNumber(String cartNumber){
        String actualCartNumber = cartIcon.getText();
        if(actualCartNumber.equalsIgnoreCase(cartNumber)){
            return true;
        }
        return false;
    }

    public void removeProductFromCart(String productName){
        // remove-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "remove-"+productName.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }

    public void clickOnCartButton(){
        cartIcon.click();
    }


    public void clickOnLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(menuButton));

        menuButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(botonLogout));

        botonLogout.click();
    }

    public boolean loginLogoIsDisplayed(){
        if(loginLogo.isDisplayed()){
            return true;
        }
        return false;
    }

    public void selectHighToLow(){
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (high to low)");
    }

    public void selectLowToHigh(){
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (low to high)");
    }
    public boolean isHighToLow(){
        List<WebElement> precios = driver.findElements(By.className("inventory_item_price"));
        List<String> preciosString = new ArrayList<>();

        for(WebElement precio : precios){

            preciosString.add(precio.getText().replaceAll("\\$", ""));
        }

        List<Double> preciosC = preciosString.stream()
                .map(Double::parseDouble)
                .toList();

        return Ordering.natural().reverse().isOrdered(preciosC);
    }

    public boolean isLowToHigh(){
        return !isHighToLow();
    }

    public boolean cartIsEmpty(){
        List<WebElement> elements = driver.findElements(By.className("shopping_cart_badge"));
        return elements.isEmpty();
    }
}
