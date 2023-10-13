import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vas\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void logOut(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginPageUI(){
        Assert.assertTrue(loginPage.findAppLogo().isDisplayed(),"App logo is not displayed");
        Assert.assertEquals(loginPage.getLabelAt(0),"USERNAME","Username label text does not match");
        Assert.assertEquals(loginPage.getLabelAt(1),"PASSWORD","Password label text does not match");

    }

    @Test(priority = 2)
    public void emptyInputs(){
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMsg(),"*Username or password is invalid","Error text with empty input fields does not match");

    }

    @Test(priority = 3)
    public void successfulLogin(){
        loginPage.clickGivenCredintial("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
}
