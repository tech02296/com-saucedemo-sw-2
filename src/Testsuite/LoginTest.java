package Testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "www.saucedemo.com";

    @Before

    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // find the user field
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement actual = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String expeced = "PRODUCTS";

        Assert.assertEquals(expeced, actual.getText());
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement userNmae = driver.findElement(By.id("user-name"));
        userNmae.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginButton.click();

        List<WebElement> actual = driver.findElements(By.className("inventory_item"));

        Assert.assertEquals(6, actual.size());
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}




