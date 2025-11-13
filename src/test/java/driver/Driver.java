package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.agoda.com/tr-tr/?cid=-296&ds=Nyd2qq6zdTnlGSyV");
        webDriver.findElement(By.id("sign-in-button")).click();
    }

    public Driver()
    {

    }
    public void closeDriver(){
        webDriver.close();
        webDriver.quit();
    }

}
