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

public class LoginPage {
    public WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "login-website-logo")
    WebElement appImage;

    @FindBy(tagName = "label")
    List<WebElement> listOfLabel;

    @FindBy(id = "userNameInput") WebElement userNameEl;

    @FindBy(id = "passwordInput") WebElement passwordEl;

    @FindBy(className = "login-button") WebElement loginBtn;

    @FindBy(className = "error-message") WebElement errorMsgEl;

    public WebElement findAppLogo(){
        return appImage;
    }

    public String getLabelAt(int index){
        return listOfLabel.get(index).getText();
    }

    public void enterUsername(String username){
        userNameEl.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordEl.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }

    public void clickGivenCredintial(String username, String password){
        userNameEl.sendKeys(username);
        passwordEl.sendKeys(password);
        loginBtn.click();
    }

    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsgEl.getText();
    }


}
