package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends Object {
    private final WebDriver driver;

    // Locators
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By registerButton = By.id("register");
    private final String fieldErrorMessage = "//p[contains(text(), '%s')]";


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage(String message) {
        By dynamicXpath = By.xpath(String.format(fieldErrorMessage, message));
        return driver.findElement(dynamicXpath).getText();
    }

    public void completeNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void completeEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void completePasswordField(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickRegisterBtn() {
        driver.findElement(registerButton).click();
    }

    public void registerUser(String name, String email, String pass) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(registerButton).click();
    }

    public void deleteRowById(String id) {
        WebElement botonExcluir = driver.findElement(By.id("removeUser" + id));
        botonExcluir.click();
    }

    public boolean tableExists() {
        boolean isElementPresent = isElementPresent(driver, By.xpath("//h2[contains(text(),'Usuários cadastrados')]"));
        if (isElementPresent) {
            System.out.println("El elemento está presente en el DOM.");
        } else {
            System.out.println("El elemento NO está presente en el DOM.");
        }
        return isElementPresent;
    }

    private static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

}
