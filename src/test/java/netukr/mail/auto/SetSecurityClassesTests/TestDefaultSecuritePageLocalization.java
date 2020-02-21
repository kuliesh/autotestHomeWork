package netukr.mail.auto.SetSecurityClassesTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import netukr.mail.auto.BaseClassesForTests.BaseTests;
import netukr.mail.auto.dto.*;
import netukr.mail.auto.helpers.ApachePOIreadHelper;
import netukr.mail.auto.helpers.ReaderFilesFromResources;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TestDefaultSecuritePageLocalization extends BaseTests {
    public static Logger logger = Logger.getLogger(TestDefaultSecuritePageLocalization.class);

    String AccountsURL = "https://accounts.ukr.net/login";
    String TestSetupURL = "https://mail.ukr.net/";
    String TestPageURL = "desktop#security/default";
    String ScreenshotURL = "test-result/reports/";

    //Активація дата провайдера
    @DataProvider
    public Object[][] verifiedTitleDesSecPage(Method method) {

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        //зчитуємо тестові дані з файла розташованоно в resources
        File file = ReaderFilesFromResources.getFileFromResources("data_files/test_default_security_page_one.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "Ukr");
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    TitleLocatorCss titleLocatorCss;
    DescriptionLocatorCss descriptionLocatorCss;

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open(AccountsURL); //відкриваємо сторінку входу до поштової скриньки
        $(byId("id-l")).sendKeys("asdqwez");
        $(byId("id-p")).sendKeys(",fhvfktq4");
        $(".form__submit").click();
        Thread.sleep(2000);
        //ПОСТАВИТИ ОЧІКУВАННЯ
        //turnToUA(); //перемикаємося на українську розклдаку
    }

    @BeforeClass
    public void loadProp() {
        System.out.println("loadProp");
        Properties prop = readProperties("/csssecuritypage.properties");
        titleLocatorCss = iniTitleLocator(prop);
        descriptionLocatorCss = iniDescriptionLocator(prop);
    }

    private Properties readProperties(String url) {
        InputStream is;
        try {
            Properties prop = new Properties();
            is = this.getClass().getResourceAsStream(url);
            prop.load(is);
            return prop;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TitleLocatorCss iniTitleLocator(Properties prop) {
        TitleLocatorCss titleLocatorCss = new TitleLocatorCss();
        titleLocatorCss.setTitleOpenSession(prop.getProperty("locator.titleOpenSession"));
        titleLocatorCss.setTitleSecurityLog(prop.getProperty("locator.titleSecurityLog"));
        titleLocatorCss.setTitlePasswordChange(prop.getProperty("locator.titlePasswordChange"));
        titleLocatorCss.setTitleRecoveryContacts(prop.getProperty("locator.titleRecoveryContacts"));
        titleLocatorCss.setTitlePersonalInfo(prop.getProperty("locator.titlePersonalInfo"));
        titleLocatorCss.setTitleAppPasswords(prop.getProperty("locator.titleAppPasswords"));
        titleLocatorCss.setTitleAccountDeletion(prop.getProperty("locator.titleAccountDeletion"));
        return titleLocatorCss;
    }

    private DescriptionLocatorCss iniDescriptionLocator(Properties prop) {
        DescriptionLocatorCss descriptionLocatorCss = new DescriptionLocatorCss();
        descriptionLocatorCss.setDescriptionOpenSession(prop.getProperty("locator.descriptionOpenSession"));
        descriptionLocatorCss.setDescriptionSecurityLog(prop.getProperty("locator.descriptionSecurityLog"));
        descriptionLocatorCss.setDescriptionPasswordChange(prop.getProperty("locator.descriptionPasswordChange"));
        descriptionLocatorCss.setDescriptionRecoveryContacts(prop.getProperty("locator.descriptionRecoveryContacts"));
        descriptionLocatorCss.setDescriptionPersonalInfo(prop.getProperty("locator.descriptionPersonalInfo"));
        descriptionLocatorCss.setDescriptionAppPasswords(prop.getProperty("locator.descriptionAppPasswords"));
        descriptionLocatorCss.setDescriptionAccountDeletion(prop.getProperty("locator.descriptionAccountDeletion"));
        return descriptionLocatorCss;
    }

    void openTestPageUrl() {
        open(TestSetupURL + TestPageURL);
    }

    void waitTest() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test (dataProvider = "verifiedTitleDesSecPage")//Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7334")
    @TmsLink(value = "C7336")
    @TmsLink(value = "C7337")
    @TmsLink(value = "C7338")
    @TmsLink(value = "C7339")
    @TmsLink(value = "C7340")
    @TmsLink(value = "C7341")
    @TmsLink(value = "C9997")

    public void testDefaultSecPage(ArrayList data) throws InterruptedException {
        logger.info("Testing default localization for Security Page.");
        //формування масиву даних з файла, що був оброблений дата провайдером
        String testName = String.valueOf(data.get(0));
        String titleSecurityPage = String.valueOf(data.get(1));
        String descriptionSecurityPage = String.valueOf(data.get(2));
        logger.info("testName = " + testName);
        logger.info("titleSecurityPage = " + titleSecurityPage);
        logger.info("descriptionSecurityPage = " + descriptionSecurityPage);

        openTestPageUrl();
        Configuration.reportsFolder = ScreenshotURL;
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(titleSecurityPage, $(".app section:nth-child(2) .app-tab__title").getText(), "Заголовок розділу "+titleSecurityPage+" " +
                "на сторінці безпека не відповідає документації по локалізації для даної мови: "+titleSecurityPage+".");
        softAssertion.assertEquals(descriptionSecurityPage, $(".app section:nth-child(2) .app-tab__desc").getText(), "Опис розділу "+titleSecurityPage+" " +
                "на сторінці безпека не відповідає документації по локалізації для даної мови: "+descriptionSecurityPage+".");

        softAssertion.assertAll();
        isStopFrame();
    }
}
