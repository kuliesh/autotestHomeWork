package netukr.mail.auto.SetSecurityClassesTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import netukr.mail.auto.BaseClassesForTests.BaseTests;
import netukr.mail.auto.helpers.ApachePOIreadHelper;
import netukr.mail.auto.helpers.ReaderFilesFromResources;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TestDefaultSecuritePageLocalization extends BaseTests {
    private static String SHEET_LANG;
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
        File file = ReaderFilesFromResources.getFileFromResources("data_files/test_default_security_page.xlsx");
        excelReader.setExcelFile(String.valueOf(file), SHEET_LANG);
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open(AccountsURL); //відкриваємо сторінку входу до поштової скриньки
        $(byId("id-l")).sendKeys("asdqwez");
        $(byId("id-p")).sendKeys("");
        $(".form__submit").shouldBe(Condition.enabled).click();
        waitTest();
        turnToRU();
        //ПОСТАВИТИ ОЧІКУВАННЯ
    }

    void openTestPageUrl() {
        open(TestSetupURL + TestPageURL);
    }

    void waitTest() {
        $(".sidebar__foot").waitUntil(Condition.visible, 4000);
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
        String titleLocator = String.valueOf(data.get(3));
        String descriptionLocator = String.valueOf(data.get(4));
        String titlePage = String.valueOf(data.get(5));
        String locatorTitlePage = String.valueOf(data.get(6));

        logger.info("testName = " + testName);
        logger.info("titleSecurityPage = " + titleSecurityPage);
        logger.info("descriptionSecurityPage = " + descriptionSecurityPage);
        logger.info("titleLocator = " + titleLocator);
        logger.info("descriptionLocator = " + descriptionLocator);
        logger.info("titlePage = " + titlePage);
        logger.info("locatorTitlePage = " + locatorTitlePage);

        openTestPageUrl();

        Configuration.reportsFolder = ScreenshotURL;
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(titlePage, $(locatorTitlePage).getText(), "Заголовок сторінки '"+titlePage+"' " +
                " не відповідає документації по локалізації для даної мови: '"+titlePage+"'.");
        softAssertion.assertEquals(titleSecurityPage, $(titleLocator).getText(), "Заголовок розділу '"+titleSecurityPage+"' " +
                "на сторінці '"+titlePage+"' не відповідає документації по локалізації для даної мови: '"+titleSecurityPage+"'.");
        softAssertion.assertEquals(descriptionSecurityPage, $(descriptionLocator).getText(), "Опис розділу '"+titleSecurityPage+"' " +
                "на сторінці '"+titlePage+"' не відповідає документації по локалізації для даної мови: '"+descriptionSecurityPage+"'.");

        softAssertion.assertAll();
        isStopFrame();
    }


}
