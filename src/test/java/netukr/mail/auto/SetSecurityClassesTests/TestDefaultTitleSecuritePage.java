package netukr.mail.auto.SetSecurityClassesTests;

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
        $(".form__submit").click();
        Thread.sleep(2000);
        //ПОСТАВИТИ ОЧІКУВАННЯ
        //turnToUA(); //перемикаємося на українську розклдаку
    }

    @BeforeClass
    public void loadProp() {
        System.out.println("loadProp");
        Properties prop = readProperties("/csssecuritypage.properties");
        System.out.println("titleInactiv.color" + prop.getProperty("titleInactiv.color"));
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

    private TitleCss iniTitle(Properties prop) {
        TitleCss titleCss = new TitleCss();
        titleCss.setTitleColor(prop.getProperty("title.color"));
        titleCss.setTitleFontSize(prop.getProperty("title.font-size"));
        titleCss.setTitleFontWeight(prop.getProperty("title.font-weight"));
        titleCss.setTitleLineHeight(prop.getProperty("title.line-height"));
        titleCss.setTitleFontFamily(prop.getProperty("title.font-family"));
        return titleCss;
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

    String aaaaaaa = "titleCss.getColor(), titleCss.getFontSize(), titleCss.getFontWeight(), titleCss.getFontFamily(), titleCss.getLineHeight()";

    @Test //Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7334")
    public void TestC7334VerifiedDefaultTitle() throws InterruptedException {
        logger.info("Testing test-case №C7334");
        String locatorTitleSecurityPage = "h1.app__title";
        openTestPageUrl();
        Configuration.reportsFolder = ScreenshotURL;
        Thread.sleep(2000);

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");
        softAssertion.assertEquals("Безпека", $(locatorTitleSecurityPage).getText(), "Заголовок 'Безпека'" +
                " не відображається на сторінці security/default для вибраної локалізації");

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "line-height"};
        String[] propertiesPapameterCssTitle = new String[]{titleCss.getTitleColor(), titleCss.getTitleFontSize(), titleCss.getTitleFontWeight(),
                titleCss.getTitleFontFamily(), titleCss.getTitleLineHeight()};

        for (int i = 0; i < 5; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleOpenSession()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Безпека' не відповідає документації "+varPropertiesPapametersCssTitle+".");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7336")
    public void TestC7336OpenSessions() {
        logger.info("Testing test-case №C7336");
        Configuration.reportsFolder = ScreenshotURL + "/reportsC7336"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedOpenSession");

        //Відображення елементів для розділу відкритих сесій
        softAssertion.assertTrue($(titleLocatorCss.getTitleOpenSession()).isDisplayed(), "Заголовок розділу 'Відкриті сесії не відображається'");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionOpenSession()).isDisplayed(), "Опис розділу 'Відкриті сесії не відображається'");
        softAssertion.assertTrue($(".app-tab__icon_sessions").isDisplayed(), "Іконка розділу 'Відкриті сесії' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenOpenSession()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Відкриті сесії не відображається'");
        softAssertion.assertEquals("Відкриті сесії", $(titleLocatorCss.getTitleOpenSession()).getText(),
                "Заголовок 'Відкрити сесії' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Коли хтось входить у скриньку – створюється сесія. Список сесій відображено " +
                        "у цьому розділі. У ньому також міститься інформація про пристрої, на яких зараз відкрито " +
                        "вашу пошту: тип, операційна система, браузер і IP-адреса. Перевірте, чи всі сесії актуальні. " +
                        "Якщо якийсь пристрій більше вам недоступний чи окрема сесія здаватиметься вам підозрілою, " +
                        "закрийте її і змініть пароль.", $(descriptionLocatorCss.getDescriptionOpenSession()).getText(),
                "Текст опису розділу 'Відкриті сесії не відповідає документації.");
        screenshot("iconDefaultOpenSessionTC7336"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};

        //Перевірка дизайну заголовку розділу "Відкриті сесії"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

        softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleOpenSession()).getCssValue(varNamePapametersCss),
                "\""+varNamePapametersCss+" шрифта заголовку 'Відкриті сесії' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Відкриті сесії"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionOpenSession()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Відкриті сесії' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7337")
    public void TestC7337SecurityLog() {
        logger.info("Testing test-case №C7337");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7337"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedSecurityLog");

        //Відображення елементів для розділу 'Журнал безпеки'
        softAssertion.assertTrue($(titleLocatorCss.getTitleSecurityLog()).isDisplayed(), "Заголовок розділу 'Журнал безпеки' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionSecurityLog()).isDisplayed(), "Опис розділу 'Журнал безпеки' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_events").isDisplayed(), "Іконка розділу 'Журнал безпеки' не відображається.");
        softAssertion.assertTrue($( openLocatorCss.getOpenSecurityLog()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Журнал безпеки' не відображається.");
        softAssertion.assertEquals("Журнал безпеки", $(titleLocatorCss.getTitleSecurityLog()).getText(),
                "Заголовок 'Журнал безпеки' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Тут ви можете проглянути перелік подій, пов'язаних з безпекою вашої поштової " +
                        "скриньки – як успішних, так і неуспішних (наприклад, невдала спроба входу у скриньку, зміна " +
                        "пароля або контактів для відновлення і т.п.). А також коли, з якого пристрою і країни вони були " +
                        "здійснені. Ці дані допомагають виявити дії зловмисників і вчасно змінити пароль із міркувань безпеки.", $(descriptionLocatorCss.getDescriptionSecurityLog()).getText(),
                "Текст опису розділу 'Журнал безпеки' не відповідає документації.");
        screenshot("iconDefaultSecurityLogTC7337"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Журнал безпеки"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleSecurityLog()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Журнал безпеки' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Журнал безпеки"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionSecurityLog()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Журнал безпеки' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7338")
    public void TestC7338PasswordChange() {
        logger.info("Testing test-case №C7338");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7338"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPasswordChange");

        //Відображення елементів для розділу 'Зміна пароля'
        softAssertion.assertTrue($(titleLocatorCss.getTitlePasswordChange()).isDisplayed(), "Заголовок розділу 'Зміна пароля' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionPasswordChange()).isDisplayed(), "Опис розділу 'Зміна пароля' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_changePassword").isDisplayed(), "Іконка розділу 'Зміна пароля' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenPasswordChange()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Зміна пароля' не відображається.");
        softAssertion.assertEquals("Зміна пароля", $(titleLocatorCss.getTitlePasswordChange()).getText(),
                "Заголовок 'Зміна пароля' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо " +
                        "дотримуватися рекомендацій зі створення безпечного пароля і час від часу змінювати його " +
                        "заради вашої безпеки.", $(descriptionLocatorCss.getDescriptionPasswordChange()).getText(),
                "Текст опису розділу 'Зміна пароля' не відповідає документації.");
        screenshot("iconDefaultPasswordChangeTC7338"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Зміна пароля"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitlePasswordChange()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Зміна пароля' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Зміна пароля"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionPasswordChange()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Зміна пароля' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7339")
    @Issue(value = "ACPP-2262")
    public void TestC7339RecoveryContacts(){
        logger.info("Testing test-case №C7339");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7339"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedRecoveryContacts");

        //Відображення елементів для розділу 'Контакти для відновлення'
        softAssertion.assertTrue($(titleLocatorCss.getTitleRecoveryContacts()).isDisplayed(), "Заголовок розділу 'Контакти для відновлення' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionRecoveryContacts()).isDisplayed(), "Опис розділу 'Контакти для відновлення' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_contacts").isDisplayed(), "Іконка розділу 'Контакти для відновлення' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenRecoveryContacts()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Контакти для відновлення' не відображається.");
        softAssertion.assertEquals("Контакти для відновлення", $(titleLocatorCss.getTitleRecoveryContacts()).getText(),
                "Заголовок 'Контакти для відновлення' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("У випадку якщо ви забудете пароль, ми допоможемо відновити доступ до вашої пошти протягом кількох хвилин: " +
                        "на вказані тут мобільний телефон або резервний e-mail буде відправлено код для зміни пароля. Тому, будь ласка, перевірте " +
                        "ці контакти і за потреби замініть їх на нові. На ці ж контакти ви зможете отримувати сповіщення безпеки.", $(descriptionLocatorCss.getDescriptionRecoveryContacts()).getText(),
                "Текст опису розділу 'Контакти для відновлення' не відповідає документації.");
        screenshot("iconDefaultRecoveryContactsTC7339"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Контакти для відновлення"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleRecoveryContacts()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Контакти для відновлення' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Контакти для відновлення"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionRecoveryContacts()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Контакти для відновлення' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7340")
    public void TestC7340PersonalInfo() {
        logger.info("Testing test-case №C7340");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7340"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPersonalInfo");

        //Відображення елементів для розділу 'Особисті дані'
        softAssertion.assertTrue($(titleLocatorCss.getTitlePersonalInfo()).isDisplayed(), "Заголовок розділу 'Особисті дані' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionPersonalInfo()).isDisplayed(), "Опис розділу 'Особисті дані' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_personalData").isDisplayed(), "Іконка розділу 'Особисті дані' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenPersonalInfo()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Особисті дані' не відображається.");
        softAssertion.assertEquals("Особисті дані", $(titleLocatorCss.getTitlePersonalInfo()).getText(),
                "Заголовок 'Особисті дані' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою " +
                        "паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, " +
                        "вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе " +
                        "допомогти вам – доступ до пошти буде втрачено назавжди.", $(descriptionLocatorCss.getDescriptionPersonalInfo()).getText(),
                "Текст опису розділу 'Особисті дані' не відповідає документації.");
        screenshot("iconDefaultPersonalInfoTC7340"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Особисті дані"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitlePersonalInfo()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Особисті дані' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Особисті дані"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionPersonalInfo()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Особисті дані' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
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

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAccountDeletion");

        //Відображення елементів для розділу 'Видалення акаунта'
        softAssertion.assertTrue($(titleLocatorCss.getTitleAccountDeletion()).isDisplayed(), "Заголовок розділу 'Видалення акаунта' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionAccountDeletion()).isDisplayed(), "Опис розділу 'Видалення акаунта' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_deleteAccount").isDisplayed(), "Іконка розділу 'Видалення акаунта' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenAccountDeletion()).isDisplayed(), "Елемент розкриття" +
                " розділу 'Видалення акаунта' не відображається.");
        softAssertion.assertEquals("Видалення акаунта", $(titleLocatorCss.getTitleAccountDeletion()).getText(),
                "Заголовок 'Видалення акаунта' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Якщо ви вважаєте, що ця поштова скринька вам більше не знадобиться, ви можете її видалити.", $(descriptionLocatorCss.getDescriptionAccountDeletion()).getText(),
                "Текст опису розділу 'Видалення акаунта' не відповідає документації.");
        screenshot("iconDefaultAccountDeletionTC7341"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Видалення акаунта"
        for (int i = 0; i < 8; i++) {

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleAccountDeletion()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Видалення акаунта' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Видалення акаунта"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionAccountDeletion()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Видалення акаунта' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
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

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAccountDeletion");

        //Відображення елементів для розділу 'Паролі для зовнішніх програм'
        softAssertion.assertTrue($(titleLocatorCss.getTitleAppPasswords()).isDisplayed(), "Заголовок розділу 'Паролі для зовнішніх програм' не відображається");
        softAssertion.assertTrue($(descriptionLocatorCss.getDescriptionAppPasswords()).isDisplayed(), "Опис розділу 'Паролі для зовнішніх програм' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_appPasswords").isDisplayed(), "Іконка розділу 'Паролі для зовнішніх програм' не відображається.");
        softAssertion.assertTrue($(openLocatorCss.getOpenAppPasswords()).isDisplayed(), "Елемент розкриття" +
            " розділу 'Паролі для зовнішніх програм' не відображається.");
        softAssertion.assertEquals("Паролі для зовнішніх програм", $(titleLocatorCss.getTitleAppPasswords()).getText(),
                "Заголовок 'Паролі для зовнішніх програм' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Налаштуйте IMAP-доступ, щоб працювати з поштою у зовнішніх програмах (наприклад, Microsoft Outlook, M.E.Doc) без використання браузера.",
                $(descriptionLocatorCss.getDescriptionAppPasswords()).getText(),
                "Текст опису розділу 'Паролі для зовнішніх програм' не відповідає документації.");
        screenshot("iconDefaultAccountDeletionTC9997"); //скріншот відкритих сесій - для перевірки кольору елементів

        String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
        String[] propertiesPapameterCssTitle = new String[]{titleInactiveCss.getColor(), titleInactiveCss.getFontSize(), titleInactiveCss.getFontWeight(),
                titleInactiveCss.getFontFamily(), titleInactiveCss.getCursor(), titleInactiveCss.getLineHeight(), titleInactiveCss.getMargin(), titleInactiveCss.getPaddingTop()};
        //Перевірка дизайну заголовку розділу "Паролі для зовнішніх програм"
        for (int i = 0; i < 8; i++) {
            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(titleLocatorCss.getTitleAppPasswords()).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Паролі для зовнішніх програм' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        String[] namePapametersCssDes = new String[]{"color", "font-size", "font-family", "margin"};
        String[] propertiesPapameterCssTitleDes = new String[]{desTitleInactiveCss.getColor(), desTitleInactiveCss.getFontSize(),
                desTitleInactiveCss.getFontFamily(), desTitleInactiveCss.getMargin()};
        //Перевірка дизайну опису розділу "Паролі для зовнішніх програм"
        for (int j = 0; j < 4; j++) {

            String varNamePapametersCssDes = namePapametersCssDes[j];
            String varPropertiesPapametersCssTitleDes = propertiesPapameterCssTitleDes[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitleDes, $(descriptionLocatorCss.getDescriptionAppPasswords()).getCssValue(varNamePapametersCssDes),
                    "\""+varNamePapametersCssDes+" шрифта опису розділа 'Паролі для зовнішніх програм' не відповідає документації'"+varPropertiesPapametersCssTitleDes+"'.");
        }

        softAssertion.assertAll();
    isStopFrame();
    }
}
