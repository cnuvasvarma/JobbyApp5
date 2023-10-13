package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobsPage {
    WebDriver driver;
    WebDriverWait wait;

    public JobsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "img.profile-img")
    WebElement profileImg;

    @FindBy(className = "profile-name") WebElement profileName;

    @FindBy(className = "short-bio") WebElement bioText;

    @FindBy(css = "div[class ^='desktop'] input.search-input") WebElement searchField;

    @FindBy(css = "div[class ^='desktop'] button.search-button") WebElement searchBtn;

    @FindBy(className = "job-item")
    List<WebElement> listOfJobs;

    @FindBy(className = "jobs-not-found-img") WebElement noJobImg;

    @FindBy(className = "jobs-not-found-heading") WebElement noJobHeading;

    @FindBy(className = "jobs-not-found-description") WebElement noJobDescription;

    public WebElement findProfileImg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile-img")));
        return profileImg;
    }

    public String getTextContentOfProfileName(){
        return profileName.getText();
    }

    public String getShortBio(){
        return bioText.getText();
    }

    public void enterSearchInput(String text){
        searchField.sendKeys(text);
    }

    public void enterSpecifiendInput(String text){
        searchField.sendKeys(text);
        searchBtn.click();
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public int countOfJobs(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("link-item")));
        return listOfJobs.size();
    }

    public WebElement findNoJobImg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("jobs-not-found-img")));
        return noJobImg;
    }

    public String getNoJobHeading(){
        return noJobHeading.getText();
    }

    public String getNoJobDescription(){
        return noJobDescription.getText();
    }
}
