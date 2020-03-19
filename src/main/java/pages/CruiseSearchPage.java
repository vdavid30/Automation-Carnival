package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CruiseSearchPage extends BasePage {

    private By pricingButton = By.xpath("//span[contains(text(),'Pricing')]");
    private By listViewButton = By.xpath("//*[@id='ccl-refresh-homepage']/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div[1]/ccl-cruise-search-bar-layout-switcher/div/a[2]/i[1]");

    public CruiseSearchPage(WebDriver driver) {
        super(driver);
    }

    public CruiseSearchPage clickOnSpan(String spanText) {
        By span = By.xpath("//span[contains(text(),'" + spanText + "')]");
        click(span);
        return this;
    }

    public CruiseSearchPage dragAndDrop(WebElement from, WebElement to) {
        Actions act = new Actions(driver);
        act.dragAndDrop(from, to).build().perform();
        return this;
    }

    public By getPricingButton(){
        return pricingButton;
    }

    public CruiseSearchPage clickOnListViewButton(){
        waitVisibility(listViewButton);
        click(listViewButton);
        return this;
    }

    public WebElement getMinimunBar(){
        WebElement webElement = driver.findElement(By.xpath("//span[@class='rz-pointer rz-pointer-min']"));
        return webElement;
    }

    public WebElement getMaximunBar(){
        WebElement webElement = driver.findElement(By.xpath("//span[@class='rz-pointer rz-pointer-max']"));
        return webElement;
    }

    public DescriptionPage selectOneSail(){
        By span = By.xpath("//span[@class='cgc-cruise-glance__main-text ng-binding']");
        waitVisibility(span);
        click(span);
        return new DescriptionPage(driver);
    }
}
