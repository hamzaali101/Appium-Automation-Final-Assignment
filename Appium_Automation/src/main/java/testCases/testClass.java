package testCases;

import baseTest.appFactory;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Feedback;
import pages.SavedPage;
import pages.Searchpage;
import pages.loginPage;
import utilities.excelReader;
import java.net.MalformedURLException;
import java.util.Random;

public class testClass {

    excelReader xlsReader;
    private loginPage logPage;
    private Searchpage sPage;
    private Feedback fback;
    private SavedPage savepage;


    @BeforeTest
    public void setup() throws MalformedURLException{

        xlsReader = new excelReader();
        xlsReader.readExcelFile();
        appFactory.initializer();
        logPage = new loginPage();
        sPage = new Searchpage();
        savepage = new SavedPage();
        fback = new Feedback();

    }

    @Test
    @Epic("Bookme.com")
    @Feature("Create Account")
    @Description("User Should be able to Create a New Account")
    @Story("User Should be able to Create a New Account")
//    @Severity(SeverityLevel.BLOCKER)
    public void creageAccount() throws InterruptedException{

        String email = excelReader.getCellValueFromSheet(2,0);
        String pass = excelReader.getCellValueFromSheet(2,1);
        logPage.assertElement(logPage.pageHeader);
        logPage.clickCreateAccountBtn();
        logPage.enterEmail(email+ random() + "@gmail.com");
        logPage.clickContBtn();
        logPage.assertElement(logPage.pageHeader);
        logPage.enterPass(pass);
        logPage.assertElement(logPage.pageHeader);
        logPage.enterConfirmPass(pass);
        logPage.clickSignUpBtn();
        logPage.assertElement(logPage.welcomeText);
        sPage.clickStart();

    }

    @Test
    @Epic("Bookme.com")
    @Feature("Search Stays")
    @Description("User Should be able to Search  Stays")
    @Story("User Should be able to Search  Stays")
//    @Severity(SeverityLevel.TRIVIAL)
    public void searchStays() throws InterruptedException{

        String dest = excelReader.getCellValueFromSheet(6,0);
        String FromDay = excelReader.getCellValueFromSheet (6,1);
        String FromMonth = excelReader.getCellValueFromSheet(6,2);
        String FromYear = excelReader.getCellValueFromSheet(6,3);
        String dateFrom =  FromDay+" "+FromMonth+" "+FromYear;
        String ToDay = excelReader.getCellValueFromSheet(6,4);
        String ToMonth = excelReader.getCellValueFromSheet(6,5);
        String ToYear = excelReader.getCellValueFromSheet(6,6);
        String dateTo =  ToDay+" "+ToMonth+" "+ToYear;

        sPage.clickDest();
        sPage.enterDestination(dest);
        sPage.slectSearchedDest();
        sPage.ClickSelectedDateRange(dateFrom);
        sPage.ClickSelectedDateRange(dateTo);
        sPage.clickSubmitDateBtn();
        sPage.clickOccupancy();
        sPage.addRooms();
        sPage.addAdult();
        sPage.clickApplyBtn();
        sPage.clickSearchBtn();
        sPage.assertElement(sPage.propertiesFound.get(1));

    }

    @Test
    @Epic("Bookme.com")
    @Feature("Save To List")
    @Description("User Should be able to Save search results to List")
    @Story("User Should be able to Save search results to List")
//    @Severity(SeverityLevel.NORMAL)
    public void saveToList() throws InterruptedException{
        String ListName = excelReader.getCellValueFromSheet(10,0);

        savepage.clickHeartIcon();
        savepage.clickNavUpIcon();
        savepage.clickSavednavIcon();
        savepage.assertElement(savepage.ListName(ListName));
        savepage.clickListTile(savepage.ListName(ListName));
        savepage.assertElement(savepage.wishlistname);

    }

    @Test
    @Epic("Bookme.com")
    @Feature("Give App Feedback")
    @Description("User Should be able to Give App feedback")
    @Story("User Should be able to Give App feedback")
//    @Severity(SeverityLevel.NORMAL)
    public void GiveAppFeedback() throws InterruptedException{

        String rate = excelReader.getCellValueFromSheet(15,0);
        int rating = Integer.parseInt(rate);
        String comment = excelReader.getCellValueFromSheet(15,1);

        savepage.clickNavUpIcon();
        fback.clickProfilenav();
        fback.scroll("Give App Feedback");
        fback.clickAppFeedbackLink();
        fback.assertElement(fback.giveFeedbackLink);
        fback.selectRating(rating);
        fback.selectFeedbackTypeDrpdown();
        fback.selectOption();
        fback.enterCmnt(comment);
        fback.clikcSubmitBtn();
        fback.assertElement(fback.confirmSubmission);

    }

//    @Test
//    public void login() throws InterruptedException{
//        String email = excelReader.getCellValueFromSheet(2,4);
//        String pass = excelReader.getCellValueFromSheet(2,5);
//
//        logPage.assertElement(logPage.pageHeader);
//        logPage.clickSignUpBtn();
//        logPage.enterEmail(email);
//        logPage.clickContBtn();
//        logPage.assertElement(logPage.pageHeader);
//        logPage.enterPass(pass);
//        logPage.assertElement(logPage.pageHeader);
//        logPage.clickSignIpBtn();
//        logPage.assertElement(logPage.welcomeText);
//
//    }

    @AfterTest
    public void Teardown(){
        appFactory.quitDriver();
    }

    public  int random(){
        Random rand = new Random();
        int x = rand.nextInt(9999) + 1000;
        return x;
    }
}
