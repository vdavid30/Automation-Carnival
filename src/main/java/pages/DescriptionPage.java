package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DescriptionPage extends BasePage {

    private List<WebElement> daysDescriptionButtons;
    public DescriptionPage(WebDriver driver) {
        super(driver);
    }

    public DescriptionPage findSailDays(){
        daysDescriptionButtons = driver.findElements(By.xpath("//button[@class='about-cta']"));
        return this;
    }

    public DescriptionPage readAllDaysDescription(){
        for (WebElement webElement : daysDescriptionButtons){
            webElement.click();
        }
        return this;
    }
}
