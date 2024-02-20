package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    WebDriver driver;
    public WebDriver initializeDriver() {
        if (driver == null) {
            if (ProjectConfig.browser.equals("Chrome")) {
                driver = new ChromeDriver();
            } else if (ProjectConfig.browser.equals("Firefox")) {
                driver = new FirefoxDriver();
            }else if (ProjectConfig.browser.equals("Edge")) {
                driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
