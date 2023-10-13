import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobsPage;
import pages.LoginPage;

import java.time.Duration;

public class JobsPageTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    JobsPage jobsPage;

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
        homePage.clickFindBtn();
        jobsPage = new JobsPage(driver);

    }

    @AfterMethod
    public void shutDown(){
        driver.quit();
    }

    public Object[][] dataSet = {
            {"Devops Engineer",9},
            {"Backend Engineer",11},
            {"Frontend Engineer",13},
            {"Fullstack Developer",6},
            {"Data Scientist",11},
            {"ML Engineer",10}
    };

    @DataProvider
    public Object[][] nameOfField(){
        return dataSet;
    }

    @Test(priority = 1)
    public void testProfileContainerUI(){
        Assert.assertTrue(jobsPage.findProfileImg().isDisplayed(),"Profile image is not displayed");
        Assert.assertEquals(jobsPage.getTextContentOfProfileName(),"Rahul Attluri","Profile name does not match");
        Assert.assertEquals(jobsPage.getShortBio(),"Lead Software Developer and AI-ML expert","Bio does not match");
    }

    @Test(priority = 2,dataProvider = "nameOfField")
    public void testSuccessful(String field,int val){
        jobsPage.enterSpecifiendInput(field);
        Assert.assertEquals(jobsPage.countOfJobs(),val,"Jobs count does not match");

    }

    @Test(priority = 3)
    public void unsuccessfulTest(){
        jobsPage.enterSpecifiendInput("Netflix");
        Assert.assertTrue(jobsPage.findNoJobImg().isDisplayed(),"Jobs not found image is not displayed");

        Assert.assertEquals(jobsPage.getNoJobHeading(),"No Jobs Found","Jobs not found heading does not match");
        Assert.assertEquals(jobsPage.getNoJobDescription(),"We could not find any jobs. Try other filters.","Jobs not found description does not match");

    }
}
