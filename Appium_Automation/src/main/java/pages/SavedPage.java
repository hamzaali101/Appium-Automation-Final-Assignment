package pages;
import baseTest.appDriver;
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

public class SavedPage {
    public SavedPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()), this);
    }


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public WebElement navUp;
    @FindBy(xpath = "//android.widget.TextView[@text='Saved']")
    public WebElement savedNav;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Create new']")
    public WebElement createNewList;
    @FindBy(xpath = "//android.widget.TextView[@index='1']")
    public List<WebElement> listName;
    @FindBy(id = "com.booking:id/btn_wishlist_create_list")
    public WebElement creatListeBtn;
    @FindBy(id = "//android.widget.FrameLayout[@content-desc='Search']/android.widget.ImageView")
    public WebElement searchNav;
    @FindBy(xpath = "//android.widget.Button[@text='Search']")
    public WebElement searchBtn;
    @FindBy(xpath = "//android.widget.ImageView[@index='1']")
    public List<WebElement> heartIcon;
    @FindBy(id = "com.booking:id/wishlist_name")
    public WebElement wishlistname;

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
    public void clickNavUpIcon(){
        waitForElement(appDriver.getDriver(), navUp);
        navUp.click();
    }
    public void clickSavednavIcon(){
        waitForElement(appDriver.getDriver(), savedNav);
        savedNav.click();
    }
    public void clickCreateListIcon(){
        waitForElement(appDriver.getDriver(), createNewList);
        createNewList.click();
    }
    public void enterlistName(String Lname){
        waitForElements(appDriver.getDriver(), listName);
        listName.get(1).sendKeys(Lname);
    }
    public void clickCreateBtn(){
        waitForElement(appDriver.getDriver(), creatListeBtn);
        creatListeBtn.click();
    }
    public WebElement ListName(String listname) {

        String s1 = "//android.widget.TextView[@text='";
        String s2 = "']";
        String s3 =s1 + listname + s2;
        WebElement ele = appDriver.getDriver().findElement(By.xpath(s3));
        return ele;
    }
    public void clickSearchNav(){
        waitForElement(appDriver.getDriver(), searchNav);
        searchNav.click();
    }
    public void clickSearchBtn(){
        waitForElement(appDriver.getDriver(), searchBtn);
        searchBtn.click();
    }
    public void clickHeartIcon(){
        waitForElements(appDriver.getDriver(), heartIcon);
        heartIcon.get(1).click();
    }
    public void clickListTile(WebElement ele){
        waitForElement(appDriver.getDriver(), ele);
        ele.click();
    }
}