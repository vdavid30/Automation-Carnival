package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.InformationUtil;

public class HomePage extends BasePage {

    private By popUpCloseButton = By.xpath("//a[contains(text(),'No, thanks')]");
    private By carnivalHeader = By.xpath("//img[@data-testid='logo']");
    private By searchCruisesButton = By.xpath("//a[@data-tealium='cdc-search-cruises-cta']");

    private String baseUrl = InformationUtil.WEB_URL.getInformation();

    public HomePage(WebDriver driver) throws Exception {
        super(driver);
    }

    public HomePage goToHomePage(){
        driver.get(baseUrl);
        return this;
    }

    public HomePage closePopUp(){
        click(popUpCloseButton);
        return this;
    }

    public CruiseSearchPage clickOnSearchCruises(){
        click(searchCruisesButton);
        return new CruiseSearchPage(driver);
    }

    public HomePage waitForSpanElement(String spanText){
        By span = By.xpath("//span[contains(text(),'"+spanText+"')]");
        return this;
    }
    public HomePage clickOnSpan(String spanText){
        By span = By.xpath("//span[contains(text(),'"+spanText+"')]");
        waitVisibility(span);
        click(span);
        return this;
    }

    public HomePage clickOnSelectButton(String buttonName){
        By button =  By.xpath("//button[contains(text(),'"+buttonName+"')]");
        waitVisibility(button);
        click(button);
        return this;
    }

}
