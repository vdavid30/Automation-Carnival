package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruiseSearchPage;
import pages.HomePage;

public class DemoTests extends BaseTest {

    @Test(priority = 1)
    public void searchACruiserToTheBahamasWithDuration6To9Days() throws Exception {
        HomePage homePage = new HomePage(webDriver);
        homePage.goToHomePage()
                .closePopUp()
                .clickOnSpan("Sail To")
                .clickOnSelectButton("The Bahamas")
                .clickOnSpan("Sail From")
                .clickOnSelectButton("Baltimore, MD")
                .clickOnSpan("Dates")
                .clickOnSelectButton("Jan")
                .clickOnSpan("Duration")
                .clickOnSelectButton("6 - 9 Days")
                .clickOnSearchCruises();
    }

    @Test(priority = 1)
    public void searchACruiserToTheBahamasWithDuration6To9DaysAndFilterByPrice() throws Exception {
        HomePage homePage = new HomePage(webDriver);
        CruiseSearchPage cruiseSearchPage;
        cruiseSearchPage = homePage.goToHomePage()
                .closePopUp()
                .clickOnSpan("Sail To")
                .clickOnSelectButton("The Bahamas")
                .clickOnSpan("Sail From")
                .clickOnSelectButton("Baltimore, MD")
                .waitForSpanElement("Dates")
                .clickOnSpan("Dates")
                .clickOnSelectButton("Jan")
                .clickOnSpan("Duration")
                .clickOnSelectButton("6 - 9 Days")
                .clickOnSearchCruises();
        cruiseSearchPage.clickOnSpan("Pricing")
                .dragAndDrop(cruiseSearchPage.getMinimunBar(),cruiseSearchPage.getMaximunBar());
        By pricingButton = cruiseSearchPage.getPricingButton();
        Assert.assertNotEquals(pricingButton, null);
    }

    @Test(priority = 2)
    public void searchACruiserToTheBahamasWithDuration6To9DaysAndSortByPrice() throws Exception {
        HomePage homePage = new HomePage(webDriver);
        homePage.goToHomePage()
                .closePopUp()
                .clickOnSpan("Sail To")
                .clickOnSelectButton("The Bahamas")
                .clickOnSpan("Sail From")
                .clickOnSelectButton("Baltimore, MD")
                .waitForSpanElement("Dates")
                .clickOnSpan("Dates")
                .clickOnSelectButton("Jan")
                .clickOnSpan("Duration")
                .clickOnSelectButton("6 - 9 Days")
                .clickOnSearchCruises()
                .clickOnListViewButton();
    }

    @Test(priority = 1)
    public void searchACruiserToTheBahamasWithDuration6To9DaysAndMultipleDeparturePorts() throws Exception {
        HomePage homePage = new HomePage(webDriver);
        CruiseSearchPage cruiseSearchPage = homePage.goToHomePage()
                .closePopUp()
                .clickOnSpan("Sail To")
                .clickOnSelectButton("The Bahamas")
                .clickOnSpan("Sail From")
                .clickOnSelectButton("Baltimore, MD")
                .clickOnSelectButton("Miami, FL")
                .clickOnSelectButton("Fort Lauderdale, FL")
                .clickOnSpan("Dates")
                .clickOnSelectButton("Jan")
                .clickOnSpan("Duration")
                .clickOnSelectButton("6 - 9 Days")
                .clickOnSearchCruises();
        Assert.assertNull(cruiseSearchPage);
    }

    @Test(priority = 1)
    public void searchACruiserToTheBahamasWithDuration6To9DaysAndMultipleDates() throws Exception {
        HomePage homePage = new HomePage(webDriver);
        CruiseSearchPage cruiseSearchPage = homePage.goToHomePage()
                .closePopUp()
                .clickOnSpan("Sail To")
                .clickOnSelectButton("The Bahamas")
                .clickOnSpan("Sail From")
                .clickOnSelectButton("Baltimore, MD")
                .clickOnSpan("Dates")
                .clickOnSelectButton("Jan")
                .clickOnSelectButton("Feb")
                .clickOnSelectButton("May")
                .clickOnSpan("Duration")
                .clickOnSelectButton("6 - 9 Days")
                .clickOnSearchCruises();
        Assert.assertNull(cruiseSearchPage);
    }
}
