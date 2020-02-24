package netukr.mail.auto.SetSecurityClassesTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import netukr.mail.auto.BaseClassesForTests.BaseTests;
import netukr.mail.auto.dto.*;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class TestDefaultTitleSecuritePage extends BaseTests {
    public static Logger logger = Logger.getLogger(TestDefaultTitleSecuritePage.class);

    String AccountsURL = "https://accounts.ukr.net/login";
    String TestSetupURL = "https://mail.ukr.net/";
    String TestPageURL = "desktop#security/default";
    String ScreenshotURL = "test-result/reports/";

    TitleInactiveCss titleInactiveCss;
    TitleCss titleCss;
    DesTitleInactiveCss desTitleInactiveCss;
    TitleLocatorCss titleLocatorCss;
    DescriptionLocatorCss descriptionLocatorCss;
    OpenLocatorCss openLocatorCss;

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open(AccountsURL); //відкриваємо сторінку входу до поштової скриньки
        $(byId("id-l")).sendKeys("asdqwez");
        $(byId("id-p")).sendKeys("");
        $(".form__submit").waitUntil(Condition.visible, 4000).click();
        waitTest();
        //ПОСТАВИТИ ОЧІКУВАННЯ
        turnToRU(); //перемикаємося на українську розклдаку
    }

    @BeforeClass
    public void loadProp() {
        System.out.println("loadProp");
        Properties prop = readProperties("/csssecuritypage.properties");
        titleInactiveCss = iniTitleInactive(prop);
        titleCss = iniTitle(prop);
        desTitleInactiveCss = iniDesTitleInactive(prop);
        titleLocatorCss = iniTitleLocator(prop);
        descriptionLocatorCss = iniDescriptionLocator(prop);
        openLocatorCss = iniOpenLocator(prop);
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

    private TitleCss iniTitle(Properties prop) {
        TitleCss titleCss = new TitleCss();
        titleCss.setColor(prop.getProperty("title.color"));
        titleCss.setFontSize(prop.getProperty("title.font-size"));
        titleCss.setFontWeight(prop.getProperty("title.font-weight"));
        titleCss.setLineHeight(prop.getProperty("title.line-height"));
        titleCss.setFontFamily(prop.getProperty("title.font-family"));
        return titleCss;
    }


    private TitleInactiveCss iniTitleInactive(Properties prop) {
        TitleInactiveCss titleInactiveCss = new TitleInactiveCss();
        titleInactiveCss.setColor(prop.getProperty("titleInactiv.color"));
        titleInactiveCss.setFontSize(prop.getProperty("titleInactiv.font-size"));
        titleInactiveCss.setFontWeight(prop.getProperty("titleInactiv.font-weight"));
        titleInactiveCss.setLineHeight(prop.getProperty("titleInactiv.line-height"));
        titleInactiveCss.setMargin(prop.getProperty("titleInactiv.margin"));
        titleInactiveCss.setPaddingTop(prop.getProperty("titleInactiv.padding-top"));
        titleInactiveCss.setFontFamily(prop.getProperty("titleInactiv.font-family"));
        titleInactiveCss.setCursor(prop.getProperty("titleInactiv.cursor"));
        return titleInactiveCss;
    }

    private DesTitleInactiveCss iniDesTitleInactive(Properties prop) {
        DesTitleInactiveCss desTitleInactiveCss = new DesTitleInactiveCss();
        desTitleInactiveCss.setColor(prop.getProperty("desTitleInactiv.color"));
        desTitleInactiveCss.setFontSize(prop.getProperty("desTitleInactiv.font-size"));
        desTitleInactiveCss.setMargin(prop.getProperty("desTitleInactiv.margin"));
        desTitleInactiveCss.setFontFamily(prop.getProperty("desTitleInactiv.font-family"));
        return desTitleInactiveCss;
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

    private OpenLocatorCss iniOpenLocator(Properties prop) {
        OpenLocatorCss openLocatorCss = new OpenLocatorCss();
        openLocatorCss.setOpenOpenSession(prop.getProperty("locator.openOpenSession"));
        openLocatorCss.setOpenSecurityLog(prop.getProperty("locator.openSecurityLog"));
        openLocatorCss.setOpenPasswordChange(prop.getProperty("locator.openPasswordChange"));
        openLocatorCss.setOpenRecoveryContacts(prop.getProperty("locator.openRecoveryContacts"));
        openLocatorCss.setOpenPersonalInfo(prop.getProperty("locator.openPersonalInfo"));
        openLocatorCss.setOpenAppPasswords(prop.getProperty("locator.openAppPasswords"));
        openLocatorCss.setOpenAccountDeletion(prop.getProperty("locator.openAccountDeletion"));
        return openLocatorCss;
    }

    void openTestPageUrl() {

        open(TestSetupURL + TestPageURL);
    }

    void waitTest() {
        $(".sidebar__foot").waitUntil(Condition.visible, 4000);
    }

    @Test //Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7334")
    public void TestC7334VerifiedDefaultTitle() throws InterruptedException {
        logger.info("Testing test-case №C7334");
        String locatorTitleSecurityPage = ".app__title";
        openTestPageUrl();
        Configuration.reportsFolder = ScreenshotURL;
        Thread.sleep(4000);
        $(".header").scrollIntoView(true);

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");
        softAssertion.assertTrue($(locatorTitleSecurityPage).isDisplayed(), "Заголовок 'Безпека'" +
                " не відображається на сторінці security/default для вибраної локалізації");

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "line-height"};
        String[] propertiesPapameterCssTitle = new String[]{titleCss.getColor(), titleCss.getFontSize(), titleCss.getFontWeight(),
                titleCss.getFontFamily(), titleCss.getLineHeight()};

        for (int i = 0; i < 5; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleSecurityPage).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Безпека' в даній локалізації не відповідає документації " + varPropertiesPapametersCssTitle + ".");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7336")
    public void TestC7336OpenSessions() throws InterruptedException {
        logger.info("Testing test-case №C7336");
        Configuration.reportsFolder = ScreenshotURL + "/reportsC7336"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedOpenSession");

        //Відображення елементів для розділу відкритих сесій
        softAssertion.assertTrue($(titleLocatorCss.getTitleOpenSession()).isDisplayed(), "Заголовок розділу 'Відкриті сесії' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionOpenSession()).isDisplayed(), "Опис розділу 'Відкриті сесії' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_sessions").isDisplayed(), "Іконка розділу 'Відкриті сесії' не відображається для даної локалізації..");
        softAssertion.assertTrue($(openLocatorCss.getOpenOpenSession()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Відкриті сесії' не відображається для даної локалізації.");
        screenshot("iconDefaultOpenSessionTC7336"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};

        //Перевірка дизайну заголовку розділу "Відкриті сесії"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleOpenSession()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Відкриті сесії' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Відкриті сесії"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionOpenSession()).getCssValue(varNamePapametersCssDes),
                    "\"" + varNamePapametersCssDes + " шрифта опису розділа 'Відкриті сесії' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7337")
    public void TestC7337SecurityLog() throws InterruptedException {
        logger.info("Testing test-case №C7337");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7337"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedSecurityLog");

        //Відображення елементів для розділу 'Журнал безпеки'
        softAssertion.assertTrue($(titleLocatorCss.getTitleSecurityLog()).isDisplayed(), "Заголовок розділу 'Журнал безпеки' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionSecurityLog()).isDisplayed(), "Опис розділу 'Журнал безпеки' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_events").isDisplayed(), "Іконка розділу 'Журнал безпеки' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenSecurityLog()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Журнал безпеки' не відображається для даної локалізації.");
        screenshot("iconDefaultSecurityLogTC7337"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Журнал безпеки"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleSecurityLog()).getCssValue(varNamePapametersCss),
                    "\"" + varNamePapametersCss + " шрифта заголовку 'Журнал безпеки' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Журнал безпеки"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionSecurityLog()).getCssValue(varNamePapametersCssDes),
                    "'" + varNamePapametersCssDes + "' шрифта опису розділа 'Журнал безпеки' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7338")
    public void TestC7338PasswordChange() throws InterruptedException {
        logger.info("Testing test-case №C7338");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7338"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPasswordChange");

        //Відображення елементів для розділу 'Зміна пароля'
        softAssertion.assertTrue($(titleLocatorCss.getTitlePasswordChange()).isDisplayed(), "Заголовок розділу 'Зміна пароля' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionPasswordChange()).isDisplayed(), "Опис розділу 'Зміна пароля' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_changePassword").isDisplayed(), "Іконка розділу 'Зміна пароля' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenPasswordChange()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Зміна пароля' не відображається для даної локалізації.");
        screenshot("iconDefaultPasswordChangeTC7338"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Зміна пароля"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitlePasswordChange()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Зміна пароля' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Зміна пароля"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionPasswordChange()).getCssValue(varNamePapametersCssDes),
                    "'" + varNamePapametersCssDes + "' шрифта опису розділа 'Зміна пароля' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7339")
    @Issue(value = "ACPP-2262")
    public void TestC7339RecoveryContacts() throws InterruptedException {
        logger.info("Testing test-case №C7339");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7339"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedRecoveryContacts");

        //Відображення елементів для розділу 'Контакти для відновлення'
        softAssertion.assertTrue($(titleLocatorCss.getTitleRecoveryContacts()).isDisplayed(), "Заголовок розділу 'Контакти для відновлення' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionRecoveryContacts()).isDisplayed(), "Опис розділу 'Контакти для відновлення' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_contacts").isDisplayed(), "Іконка розділу 'Контакти для відновлення' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenRecoveryContacts()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Контакти для відновлення' не відображається для даної локалізації.");
        screenshot("iconDefaultRecoveryContactsTC7339"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Контакти для відновлення"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleRecoveryContacts()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Контакти для відновлення' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Контакти для відновлення"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionRecoveryContacts()).getCssValue(varNamePapametersCssDes),
                    "'" + varNamePapametersCssDes + "' шрифта опису розділа 'Контакти для відновлення' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7340")
    public void TestC7340PersonalInfo() throws InterruptedException {
        logger.info("Testing test-case №C7340");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7340"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPersonalInfo");

        //Відображення елементів для розділу 'Особисті дані'
        softAssertion.assertTrue($(titleLocatorCss.getTitlePersonalInfo()).isDisplayed(), "Заголовок розділу 'Особисті дані' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionPersonalInfo()).isDisplayed(), "Опис розділу 'Особисті дані' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_personalData").isDisplayed(), "Іконка розділу 'Особисті дані' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenPersonalInfo()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Особисті дані' не відображається для даної локалізації.");
        screenshot("iconDefaultPersonalInfoTC7340"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Особисті дані"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitlePersonalInfo()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Особисті дані' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Особисті дані"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionPersonalInfo()).getCssValue(varNamePapametersCssDes),
                    "'" + varNamePapametersCssDes + " шрифта опису розділа 'Особисті дані' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7341")
    public void TestC7341AccountDeletion() throws InterruptedException {
        logger.info("Testing test-case №C7341");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7341"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAccountDeletion");

        //Відображення елементів для розділу 'Видалення акаунта'
        softAssertion.assertTrue($(titleLocatorCss.getTitleAccountDeletion()).isDisplayed(), "Заголовок розділу 'Видалення акаунта' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionAccountDeletion()).isDisplayed(), "Опис розділу 'Видалення акаунта' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_deleteAccount").isDisplayed(), "Іконка розділу 'Видалення акаунта' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenAccountDeletion()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Видалення акаунта' не відображається для даної локалізації.");
        screenshot("iconDefaultAccountDeletionTC7341"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Видалення акаунта"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleAccountDeletion()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Видалення акаунта' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Видалення акаунта"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionAccountDeletion()).getCssValue(varNamePapametersCssDes),
                    "\"" + varNamePapametersCssDes + " шрифта опису розділа 'Видалення акаунта' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    //Розділ Паролі для зовнішніхх програм
    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C9997")
    public void TestC9997AppSpecificPasswords() throws InterruptedException {
        logger.info("Testing test-case №C9997");
        Configuration.reportsFolder = ScreenshotURL + "reportsC9997"; //де зберігати скріншот
        openTestPageUrl();
        waitTest();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAppSpecificPasswords");

        //Відображення елементів для розділу 'Паролі для зовнішніх програм'
        softAssertion.assertTrue($(titleLocatorCss.getTitleAppPasswords()).isDisplayed(), "Заголовок розділу 'Паролі для зовнішніх програм' не відображається для даної локалізації.");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionAppPasswords()).isDisplayed(), "Опис розділу 'Паролі для зовнішніх програм' не відображається для даної локалізації.");
        softAssertion.assertTrue($(".app-tab__icon_appPasswords").isDisplayed(), "Іконка розділу 'Паролі для зовнішніх програм' не відображається для даної локалізації.");
        softAssertion.assertTrue($(openLocatorCss.getOpenAppPasswords()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Паролі для зовнішніх програм' не відображається для даної локалізації.");
        screenshot("iconDefaultAppSpecificPasswordsTC9997"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Паролі для зовнішніх програм"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleAppPasswords()).getCssValue(varNamePapametersCss),
                    "'" + varNamePapametersCss + "' шрифта заголовку 'Паролі для зовнішніх програм' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitle + "'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Паролі для зовнішніх програм"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionAppPasswords()).getCssValue(varNamePapametersCssDes),
                    "'" + varNamePapametersCssDes + "' шрифта опису розділа 'Паролі для зовнішніх програм' для даної локалізації не відповідає документації'" + varPropertiesPapametersCssTitleDes + "'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }
}
