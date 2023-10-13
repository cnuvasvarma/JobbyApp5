package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {
    public WebDriver driver;
    WebDriverWait wait;

    public HeaderSection(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class $= large-container] img.website-logo")
    WebElement appLogo;

    @FindBy(css = "div[class $= large-container]>a")
    WebElement appLink;

    @FindBy(linkText = "Home") WebElement navHome;

    @FindBy(linkText = "Jobs") WebElement navJob;

    @FindBy(className = "logout-desktop-btn") WebElement clickBtn;

    public WebElement findAppImage(){
        return appLogo;
    }

    public void clickAppLogoLink(){
        appLink.click();

    }

    public void clickNavbarHome(){
        navHome.click();
    }

    public void clickNavJob(){
        navJob.click();
    }

    public void clickLogoutBtn(){
        clickBtn.click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

}
