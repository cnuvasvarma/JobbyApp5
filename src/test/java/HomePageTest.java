import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vas\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        loginPage.clickGivenCredintial("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void logOut(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomePageHeading(){
        Assert.assertEquals(homePage.getTextHeading(),"Find The Job That Fits Your Life","Heading text does not match");
        Assert.assertEquals(homePage.getTextOfDescription(),"Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.","Description text does not match");


    }

    @Test(priority = 2)
    public void clickFindJobBtn(){
        homePage.clickFindBtn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
    }
}
