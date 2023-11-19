package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //* Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //* Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i")).click();

        //* Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("This is Text :" + actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //* Enter “SuperSecretPassword!” password;
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i")).click();

        //Verify the error message “Your username is invalid!”
        String expectedTextMessage = "Your username is invalid!";
        String actualTextMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedTextMessage, actualTextMessage);
        System.out.println(actualTextMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //* Enter “SuperSecretPassword” password;
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i")).click();

        //Verify the error message “Your username is invalid!”
        String expectedTextMessage = " Your password is invalid!";
        String actualTextMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedTextMessage, actualTextMessage);
        System.out.println(actualTextMessage);


    }

    @After
    public void terminateBrowser() {
        closeBrowser();
    }
}
