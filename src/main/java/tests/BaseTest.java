package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeClass
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public void teardown () {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}
