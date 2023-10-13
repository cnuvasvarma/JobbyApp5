package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "home-heading")
    WebElement mainHeading;

    @FindBy(className = "home-description") WebElement mainText;

    @FindBy(className = "find-jobs-button") WebElement findButton;

    public String getTextHeading(){
        return mainHeading.getText();
    }

    public String getTextOfDescription(){
        return mainText.getText();
    }

    public void clickFindBtn(){
        findButton.click();
    }
}
