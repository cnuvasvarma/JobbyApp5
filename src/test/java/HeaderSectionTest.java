import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderSection;
import pages.LoginPage;

import java.time.Duration;

public class HeaderSectionTest {
    WebDriver driver;
    LoginPage loginPage;
    HeaderSection headerSection;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vas\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        loginPage.clickGivenCredintial("rahul","rahul@2021");
        headerSection = new HeaderSection(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));


    }

    @AfterMethod
    public void logOut(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testAppLogoImage(){
        Assert.assertTrue(headerSection.findAppImage().isDisplayed(),"App logo is not displayed");

    }

    @Test(priority = 2)
    public void clickJobLink(){
        headerSection.clickNavJob();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
    }

    @Test(priority = 3)
    public void clickingAppLogoLink(){
        headerSection.clickNavJob();
        headerSection.clickAppLogoLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }

    @Test(priority = 4)
    public void clickNavHome(){
        headerSection.clickNavJob();
        headerSection.clickNavbarHome();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");

    }

    @Test(priority = 5)
    public void clickLogout(){
        headerSection.clickLogoutBtn();
        headerSection.acceptAlert();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/login","URLs do not match");
    }
}
