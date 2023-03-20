package net.absoft;

import io.github.bonigarcia.wdm.WebDriverManager;

import net.absoft.reporting.AttachmentUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver( ITestResult result) {
        if (!result.isSuccess()){
            AttachmentUtils.takeScreenshot(driver);
            AttachmentUtils.takePageSource(driver);
        }
        driver.quit();
    }



}
