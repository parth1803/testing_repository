package base;

import TestUtil.Constants;
import TestUtil.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties ps;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static WebDriverWait wait;
    public static int waitTime = 10;

//    public static ExtentHtmlReporter htmlReporter;
//    public static ExtentReports extent;
//    public static ExtentTest test;

    public static WebDriver testBase() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
        options.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, waitTime);

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        e_driver.manage().window().maximize();
        e_driver.get(Constants.BASEURL);

//        ChromeOptions options = new ChromeOptions();
////		options.addArguments("-incognito");
//        options.addArguments("start-maximized");
//
//        try {
//            FileInputStream fis = new FileInputStream(Constants.PROJECTPATH + "\\config.properties");
//            ps = new Properties();
//            ps.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String browserName = ps.getProperty("browser");
//
//        if (browserName.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", Constants.PROJECTPATH + "\\drivers\\IEDriverServerWin32.exe");
//            driver = new FirefoxDriver(options);
//        } else if (browserName.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", Constants.PROJECTPATH + "\\drivers\\chromedriver.exe");
//            driver = new ChromeDriver(options);
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.get(Constants.BASEURL);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
