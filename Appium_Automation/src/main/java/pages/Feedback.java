package pages;
import baseTest.appDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Feedback {
    public Feedback()
    {
        PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/navigation_bar_item_icon_view")
    public List<WebElement> profileNav;
    @FindBy(xpath = "//android.widget.TextView[@text='Give App Feedback']")
    public WebElement giveFeedbackLink;
    @FindBy(id = "com.booking:id/app_feedback_excellent")
    public List<WebElement> rate;
    @FindBy(xpath = "//android.widget.TextView[@text='Select feedback type']")
    public WebElement slectFeedbackTypeDrpdDown;
    @FindBy(id = "android:id/text1")
    public List<WebElement> slectDrpdDownOptn;
    @FindBy(id = "com.booking:id/app_feedback_free_text")
    public WebElement addCmnt;
    @FindBy(id = "com.booking:id/app_feeback_submit")
    public WebElement submit;
    @FindBy(xpath = "//android.widget.TextView[@text='Thanks for your time!']")
    public WebElement confirmSubmission;

    public void waitForElement(WebDriver d, WebElement elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem));
    }
    public void assertElement(WebElement ele){
        waitForElement(appDriver.getDriver(), ele);
        Assert.assertTrue(ele.isDisplayed());
    }
    public void clickProfilenav(){
        waitForElements(appDriver.getDriver(), profileNav);
        profileNav.get(3).click();
    }
    public void clickAppFeedbackLink(){
        waitForElement(appDriver.getDriver(), giveFeedbackLink);
        giveFeedbackLink.click();
    }
    public void selectRating(int rating){
        waitForElements(appDriver.getDriver(), rate);
        rate.get(rating).click();
    }
    public void selectFeedbackTypeDrpdown(){
        waitForElement(appDriver.getDriver(), slectFeedbackTypeDrpdDown);
        slectFeedbackTypeDrpdDown.click();
    }
    public void selectOption(){
        waitForElements(appDriver.getDriver(), slectDrpdDownOptn);
        slectDrpdDownOptn.get(1).click();
    }
    public void enterCmnt(String comment){
        waitForElement(appDriver.getDriver(), addCmnt);
        addCmnt.sendKeys(comment);
    }
    public void clikcSubmitBtn(){
        waitForElement(appDriver.getDriver(), submit);
        submit.click();
    }

    public void scroll(String str){
        appDriver.getDriver().findElement(
                new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView" +
                        "(new UiSelector().text" +
                        "(\""+str+"\"))"));


    }
}
