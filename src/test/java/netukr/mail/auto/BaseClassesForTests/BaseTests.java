package netukr.mail.auto.BaseClassesForTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import netukr.mail.auto.helpers.ReaderFilesFromResources;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

import static com.codeborne.selenide.Selenide.*;

public class BaseTests {

    final static Logger logger = Logger.getLogger(BaseTests.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "chrome");
        Configuration.startMaximized = true;
        URL url = ReaderFilesFromResources.getUrlFromResources("drivers/chromedriver.exe"); //драйвер браузера
        //розташований в resources
        logger.info("url = " + url.toString());
        System.setProperty("webdriver.chrome.driver", url.getPath());
    }

    public void isRunFrame(){
        By iframeSecSec = By.cssSelector(".security__iframe");
        switchTo().frame($(iframeSecSec));
    }

    public void isStopFrame(){

        switchTo().defaultContent();
    }

    public void turnToUA() throws InterruptedException {
        turnToLanguage(initLanguage("UA"));
    }

    public void turnToRU() throws InterruptedException {
        turnToLanguage(initLanguage("RU"));
    }

    public void turnToEN() throws InterruptedException {
        turnToLanguage(initLanguage("EN"));
    }

    private void turnToLanguage(String language) throws InterruptedException {
        open("https://mail.ukr.net/desktop#settings/interface");
        Thread.sleep(4000);
        $("[lang] > .select__value").click();
        String locatorWithLanguage = ".dropdown__list .link2:nth-of-type("+language+")";
        $(locatorWithLanguage).click();
        $(".accept").click();
        refresh();
    }

    private String initLanguage(String language) {
        switch(language)
        {
            case "1":
            case "UA":
                return "1";
            case "2":
            case "RU":
                return "2";
            case "3":
            case "EN":
                return "3";
            default:
                throw new ExceptionInInitializerError("Дана мова не передбачена. Передано:" + language);
        }
    }

    @AfterTest
    public static void tearDown(){
        logger.info("tearDown()");
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        logger.info(webDriver.getClass());
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}
