package pages;
import baseTest.appDriver;
import io.appium.java_client.android.AndroidDriver;
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

public class Searchpage {

    public Searchpage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()), this);
    }


    @FindBy(xpath = "//android.widget.Button[@text='Start searching']")
    public WebElement start;

    @FindBy(id = "com.booking:id/facet_search_box_accommodation_destination")
    public WebElement destination;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter destination']")
    public WebElement destinationField;
    @FindBy(id = "com.booking:id/view_disambiguation_destination_subtitle")
    public WebElement searchedSubTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@index='0']")
    public List<WebElement> searchedDestination;
    @FindBy(xpath = "//android.widget.Button[@text='Select dates']")
    public WebElement submitDate;
    @FindBy(id = "com.booking:id/facet_search_box_accommodation_occupancy")
    public WebElement occupancy;

    @FindBy(id = "com.booking:id/bui_input_stepper_add_button")
    public List<WebElement>  addIcon;
    @FindBy(xpath = "//android.widget.Button[@text='APPLY']")
    public WebElement applyBtn;
    @FindBy(xpath = "//android.widget.Button[@text='Search']")
    public WebElement searchBtn;
    @FindBy(xpath = "//android.widget.TextView[@index='0']")
    public List<WebElement> propertiesFound;


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
    public void clickStart(){
        waitForElement(appDriver.getDriver(), start);
        start.click();
    }
    public void clickDest(){
        waitForElement(appDriver.getDriver(), destination);
        destination.click();
    }
    public void enterDestination( String dest){
        waitForElement(appDriver.getDriver(), destinationField);
        destinationField.sendKeys(dest);
    }
    public void slectSearchedDest(){
        waitForElement(appDriver.getDriver(), searchedSubTitle);
        waitForElements(appDriver.getDriver(), searchedDestination);
        searchedDestination.get(1).click();
    }
    public void ClickSelectedDateRange(String dat){

        String s1 ="//android.view.View[@content-desc='" ;
        String s2="']";
        String s3=s1 + dat + s2;
        System.out.println(dat);
        System.out.println(s3);
        WebElement dateRange = appDriver.getDriver().findElement(By.xpath(s3));
        waitForElement(appDriver.getDriver(), dateRange);
        dateRange.click();

    }
    public void clickSubmitDateBtn(){
        waitForElement(appDriver.getDriver(), submitDate);
        submitDate.click();
    }
    public void clickOccupancy(){
        waitForElement(appDriver.getDriver(), occupancy);
        occupancy.click();
    }
    public void addRooms(){
        waitForElements(appDriver.getDriver(), addIcon);
        addIcon.get(0).click();
    }
    public void addAdult(){
        waitForElements(appDriver.getDriver(), addIcon);
        addIcon.get(1).click();
    }
    public void addChild(){
        waitForElements(appDriver.getDriver(), addIcon);
        addIcon.get(2).click();
    }
    public void clickApplyBtn(){
        waitForElement(appDriver.getDriver(), applyBtn);
        applyBtn.click();
    }
    public void clickSearchBtn(){
        waitForElement(appDriver.getDriver(), searchBtn);
        searchBtn.click();
    }


}