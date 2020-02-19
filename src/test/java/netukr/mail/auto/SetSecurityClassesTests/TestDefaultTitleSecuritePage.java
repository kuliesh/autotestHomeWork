package netukr.mail.auto.SetSecurityClassesTests;

import netukr.mail.auto.BaseClassesForTests.BaseTests;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.*;

import netukr.mail.auto.helpers.ReaderFilesFromResources;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestDefaultTitleSecuritePage extends BaseTests {
    public static Logger logger = Logger.getLogger(TestDefaultTitleSecuritePage.class);


    String AccountsURL = "https://accounts.ukr.net/login";
    String TestSetupURL = "https://mail.ukr.net/";
    String TestPageURL = "desktop#security/default";
    String ScreenshotURL = "test-result/reports/";

    int time = 1000;

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open(AccountsURL); //відкриваємо сторінку входу до поштової скриньки
        $(byId("id-l")).sendKeys("asdqwez");
        $(byId("id-p")).sendKeys("");
        $(".form__submit").click();
        //ПОСТАВИТИ ОЧІКУВАННЯ
        //turnToUA(); //перемикаємося на українську розклдаку
    }

    void openTestPageUrl() {
        open(TestSetupURL + TestPageURL);
    }

    //ініціалізація csssecuritypage.properties
    //шлях до файлу
    public static URL csssecuritypage = ReaderFilesFromResources.getUrlFromResources ("csssecuritypage.properties");

        FileInputStream fileInputStream;
        //создаем объект Properties и загружаем в него данные из файла.
        Properties propcss = new Properties();
        //propcss.load();

        String titleInactivColor = propcss.getProperty("titleInactiv.color");
        String titleInactivFontSize = propcss.getProperty("titleInactiv.font-size");
        String titleInactivCursor = propcss.getProperty("titleInactiv.cursor");
        String titleInactivFontWeiht = propcss.getProperty("titleInactiv.font-weight");
        String titleInactivnFontFamily = propcss.getProperty("titleInactiv.font-family");
        String titleInactivLineHeight = propcss.getProperty("titleInactiv.line-height");
        String titleInactivMargin = propcss.getProperty("titleInactiv.margin");
        String titleInactivPaddingTop = propcss.getProperty("titleInactiv.padding-top");

        String titleColor = propcss.getProperty("title.color");
        String titleFontSize = propcss.getProperty("title.font-size");
        String titleFontWeiht = propcss.getProperty("title.font-weight");
        String titleFontFamily = propcss.getProperty("title.font-family");
        String titleLineHeight = propcss.getProperty("title.line-height");

        String desTitleInactivColor = propcss.getProperty("desTitleInactiv.color");
        String desTitleInactivFontSize = propcss.getProperty("desTitleInactiv.font-size");
        String desTitleInactivMargin = propcss.getProperty("desTitleInactiv.margin");
        String desTitleInactivFontFamily = propcss.getProperty("desTitleInactiv.font-family");


    //ініціалізація locatorsecuritypage.properties
    //шлях до файлу
    URL locatorsecuritypage = ReaderFilesFromResources.getUrlFromResources ("locatorsecuritypage.properties");
    //создаем объект Properties и загружаем в него данные из файла.

    Properties locatorcss = new Properties();
    String locatorTitleOpenSession = locatorcss.getProperty("locator.TitleOpenSession");
    String locatorTitleSecurityLog = locatorcss.getProperty("locator.TitleSecurityLog");
    String locatorTitlePasswordChange = locatorcss.getProperty("locator.TitlePasswordChange");
    String locatorTitleRecoveryContacts = locatorcss.getProperty("locator.TitleRecoveryContacts");
    String locatorTitlePersonalInfo = locatorcss.getProperty("locator.TitlePersonalInfo");
    String locatorTitleAppPasswords = locatorcss.getProperty("locator.TitleAppPasswords");
    String locatorTitleAccountDeletion = locatorcss.getProperty("locator.TitleAccountDeletion");

    String locatorDescriptionSession = locatorcss.getProperty("locator.DescriptionSession");
    String locatorDescriptionLog = locatorcss.getProperty("locator.DescriptionLog");
    String locatorDescriptionPassword = locatorcss.getProperty("locator.DescriptionPassword");
    String locatorDescriptionContacts = locatorcss.getProperty("locator.DescriptionContacts");
    String locatorDescriptionPersonal = locatorcss.getProperty("locator.DescriptionPersonal");
    String locatorDescriptionAppPasswords = locatorcss.getProperty("locator.DescriptionAppPasswords");
    String locatorDescriptionDeletion = locatorcss.getProperty("locator.DescriptionDeletion");

    String locatorOpenSession = locatorcss.getProperty("locator.OpenSession");
    String locatorOpenLog = locatorcss.getProperty("locator.OpenLog");
    String locatorOpenPassword = locatorcss.getProperty("locator.OpenPassword");
    String locatorOpenContacts = locatorcss.getProperty("locator.OpenContacts");
    String locatorOpenPersonal = locatorcss.getProperty("locator.OpenPersonal");
    String locatorOpenAppPasswords = locatorcss.getProperty("locator.OpenAppPasswords");
    String locatorOpenDeletion = locatorcss.getProperty("locator.OpenDeletion");

    @Test //Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7334")
    public void TestVerifiedDefaultTitle() throws InterruptedException {
        logger.info("Testing test-case №C7334");
        String locatorTitleSecurityPage = "h1.app__title";
        openTestPageUrl();
        Configuration.reportsFolder = ScreenshotURL;

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");
        softAssertion.assertEquals("Безпека", $(locatorTitleSecurityPage).getText(), "Заголовок 'Безпека'" +
                " не відображається на сторінці security/default для вибраної локалізації");

        for (int i = 0; i < 5; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "line-height"};
            String[] propertiesPapameterCssTitle = new String[]{titleColor, titleFontSize, titleFontWeiht, titleFontFamily, titleLineHeight};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleOpenSession).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку ''Безпека' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7336")
    public void TestOpenSessions() throws InterruptedException {
        logger.info("Testing test-case №C7336");
        Configuration.reportsFolder = ScreenshotURL + "/reportsC7336"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedOpenSession");

        //Відображення елементів для розділу відкритих сесій
        softAssertion.assertTrue($(locatorTitleOpenSession).isDisplayed(), "Заголовок розділу 'Відкриті сесії не відображається'");
        softAssertion.assertTrue($(locatorDescriptionSession).isDisplayed(), "Опис розділу 'Відкриті сесії не відображається'");
        softAssertion.assertTrue($(".app-tab__icon_sessions").isDisplayed(), "Іконка розділу 'Відкриті сесії' не відображається.");
        softAssertion.assertTrue($(locatorOpenSession).isDisplayed(), "Елемент розкриття" +
                " розділу 'Відкриті сесії не відображається'");
        softAssertion.assertEquals("Відкриті сесії", $(locatorTitleOpenSession).getText(),
                "Заголовок 'Відкрити сесії' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Коли хтось входить у скриньку – створюється сесія. Список сесій відображено " +
                        "у цьому розділі. У ньому також міститься інформація про пристрої, на яких зараз відкрито " +
                        "вашу пошту: тип, операційна система, браузер і IP-адреса. Перевірте, чи всі сесії актуальні. " +
                        "Якщо якийсь пристрій більше вам недоступний чи окрема сесія здаватиметься вам підозрілою, " +
                        "закрийте її і змініть пароль.", $(locatorDescriptionSession).getText(),
                "Текст опису розділу 'Відкриті сесії не відповідає документації.");
        screenshot("iconDefaultOpenSessionTC7336"); //скріншот відкритих сесій - для перевірки кольору елементів

        //Перевірка дизайну заголовку розділу "Відкриті сесії"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

        softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleOpenSession).getCssValue(varNamePapametersCss),
                "\""+varNamePapametersCss+" шрифта заголовку 'Відкриті сесії' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Відкриті сесії"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionSession).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Відкриті сесії' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7337")
    public void TestSecurityLog() {
        logger.info("Testing test-case №C7337");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7337"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedSecurityLog");

        //Відображення елементів для розділу 'Журнал безпеки'
        softAssertion.assertTrue($(locatorTitleSecurityLog).isDisplayed(), "Заголовок розділу 'Журнал безпеки' не відображається");
        softAssertion.assertTrue($(locatorDescriptionLog).isDisplayed(), "Опис розділу 'Журнал безпеки' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_events").isDisplayed(), "Іконка розділу 'Журнал безпеки' не відображається.");
        softAssertion.assertTrue($(locatorOpenLog).isDisplayed(), "Елемент розкриття" +
                " розділу 'Журнал безпеки' не відображається.");
        softAssertion.assertEquals("Журнал безпеки", $(locatorTitleSecurityLog).getText(),
                "Заголовок 'Журнал безпеки' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Тут ви можете проглянути перелік подій, пов'язаних з безпекою вашої поштової " +
                        "скриньки – як успішних, так і неуспішних (наприклад, невдала спроба входу у скриньку, зміна " +
                        "пароля або контактів для відновлення і т.п.). А також коли, з якого пристрою і країни вони були " +
                        "здійснені. Ці дані допомагають виявити дії зловмисників і вчасно змінити пароль із міркувань безпеки.", $(locatorDescriptionLog).getText(),
                "Текст опису розділу 'Журнал безпеки' не відповідає документації.");
        screenshot("iconDefaultSecurityLogTC7337"); //скріншот відкритих сесій - для перевірки кольору елементів


        //Перевірка дизайну заголовку розділу "Журнал безпеки"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleSecurityLog).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Журнал безпеки' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Журнал безпеки"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionLog).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Журнал безпеки' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7338")
    public void TestPasswordChange() throws InterruptedException {
        logger.info("Testing test-case №C7338");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7338"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPasswordChange");

        //Відображення елементів для розділу 'Зміна пароля'
        softAssertion.assertTrue($(locatorTitlePasswordChange).isDisplayed(), "Заголовок розділу 'Зміна пароля' не відображається");
        softAssertion.assertTrue($(locatorDescriptionPassword).isDisplayed(), "Опис розділу 'Зміна пароля' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_changePassword").isDisplayed(), "Іконка розділу 'Зміна пароля' не відображається.");
        softAssertion.assertTrue($(locatorOpenPassword).isDisplayed(), "Елемент розкриття" +
                " розділу 'Зміна пароля' не відображається.");
        softAssertion.assertEquals("Зміна пароля", $(locatorTitlePasswordChange).getText(),
                "Заголовок 'Зміна пароля' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо " +
                        "дотримуватися рекомендацій зі створення безпечного пароля і час від часу змінювати його " +
                        "заради вашої безпеки.", $(locatorDescriptionPassword).getText(),
                "Текст опису розділу 'Зміна пароля' не відповідає документації.");
        screenshot("iconDefaultPasswordChangeTC7338"); //скріншот відкритих сесій - для перевірки кольору елементів


        //Перевірка дизайну заголовку розділу "Зміна пароля"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitlePasswordChange).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Зміна пароля' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Зміна пароля"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionPassword).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Зміна пароля' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7339")
    @Issue(value = "ACPP-2262")
    public void TestRecoveryContacts(){
        logger.info("Testing test-case №C7339");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7339"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedRecoveryContacts");

        //Відображення елементів для розділу 'Контакти для відновлення'
        softAssertion.assertTrue($(locatorTitleRecoveryContacts).isDisplayed(), "Заголовок розділу 'Контакти для відновлення' не відображається");
        softAssertion.assertTrue($(locatorDescriptionContacts).isDisplayed(), "Опис розділу 'Контакти для відновлення' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_contacts").isDisplayed(), "Іконка розділу 'Контакти для відновлення' не відображається.");
        softAssertion.assertTrue($(locatorOpenContacts).isDisplayed(), "Елемент розкриття" +
                " розділу 'Контакти для відновлення' не відображається.");
        softAssertion.assertEquals("Контакти для відновлення", $(locatorTitleRecoveryContacts).getText(),
                "Заголовок 'Контакти для відновлення' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("У випадку якщо ви забудете пароль, ми допоможемо відновити доступ до вашої пошти протягом кількох хвилин: " +
                        "на вказані тут мобільний телефон або резервний e-mail буде відправлено код для зміни пароля. Тому, будь ласка, перевірте " +
                        "ці контакти і за потреби замініть їх на нові. На ці ж контакти ви зможете отримувати сповіщення безпеки.", $(locatorDescriptionContacts).getText(),
                "Текст опису розділу 'Контакти для відновлення' не відповідає документації.");
        screenshot("iconDefaultRecoveryContactsTC7339"); //скріншот відкритих сесій - для перевірки кольору елементів


        //Перевірка дизайну заголовку розділу "Контакти для відновлення"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleRecoveryContacts).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Контакти для відновлення' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Контакти для відновлення"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionContacts).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Контакти для відновлення' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7340")
    public void TestPersonalInfo() throws InterruptedException {
        logger.info("Testing test-case №C7340");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7340"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedPersonalInfo");

        //Відображення елементів для розділу 'Особисті дані'
        softAssertion.assertTrue($(locatorTitlePersonalInfo).isDisplayed(), "Заголовок розділу 'Особисті дані' не відображається");
        softAssertion.assertTrue($(locatorDescriptionPersonal).isDisplayed(), "Опис розділу 'Особисті дані' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_personalData").isDisplayed(), "Іконка розділу 'Особисті дані' не відображається.");
        softAssertion.assertTrue($(locatorOpenPersonal).isDisplayed(), "Елемент розкриття" +
                " розділу 'Особисті дані' не відображається.");
        softAssertion.assertEquals("Особисті дані", $(locatorTitlePersonalInfo).getText(),
                "Заголовок 'Особисті дані' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою " +
                        "паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, " +
                        "вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе " +
                        "допомогти вам – доступ до пошти буде втрачено назавжди.", $(locatorDescriptionPersonal).getText(),
                "Текст опису розділу 'Особисті дані' не відповідає документації.");
        screenshot("iconDefaultPersonalInfoTC7340"); //скріншот відкритих сесій - для перевірки кольору елементів

        //Перевірка дизайну заголовку розділу "Особисті дані"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitlePersonalInfo).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Особисті дані' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Особисті дані"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionPersonal).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Особисті дані' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7341")
    public void TestAccountDeletion() throws InterruptedException {
        logger.info("Testing test-case №C7341");
        Configuration.reportsFolder = ScreenshotURL + "reportsC7341"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAccountDeletion");

        //Відображення елементів для розділу 'Видалення акаунта'
        softAssertion.assertTrue($(locatorTitleAccountDeletion).isDisplayed(), "Заголовок розділу 'Видалення акаунта' не відображається");
        softAssertion.assertTrue($(locatorDescriptionDeletion).isDisplayed(), "Опис розділу 'Видалення акаунта' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_deleteAccount").isDisplayed(), "Іконка розділу 'Видалення акаунта' не відображається.");
        softAssertion.assertTrue($(locatorOpenDeletion).isDisplayed(), "Елемент розкриття" +
                " розділу 'Видалення акаунта' не відображається.");
        softAssertion.assertEquals("Видалення акаунта", $(locatorTitleAccountDeletion).getText(),
                "Заголовок 'Видалення акаунта' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Якщо ви вважаєте, що ця поштова скринька вам більше не знадобиться, ви можете її видалити.", $(locatorDescriptionDeletion).getText(),
                "Текст опису розділу 'Видалення акаунта' не відповідає документації.");
        screenshot("iconDefaultAccountDeletionTC7341"); //скріншот відкритих сесій - для перевірки кольору елементів

        //Перевірка дизайну заголовку розділу "Видалення акаунта"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleAccountDeletion).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Видалення акаунта' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Видалення акаунта"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionDeletion).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Видалення акаунта' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
        isStopFrame();
    }

    //Розділ Паролі для зовнішніхх програм
    @Test
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C9997")
    public void TestAppSpecificPasswords() throws InterruptedException {
        logger.info("Testing test-case №C9997");
        Configuration.reportsFolder = ScreenshotURL + "reportsC9997"; //де зберігати скріншот
        openTestPageUrl();

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedAccountDeletion");

        //Відображення елементів для розділу 'Паролі для зовнішніх програм'
        softAssertion.assertTrue($(locatorTitleAppPasswords).isDisplayed(), "Заголовок розділу 'Паролі для зовнішніх програм' не відображається");
        softAssertion.assertTrue($(locatorDescriptionAppPasswords).isDisplayed(), "Опис розділу 'Паролі для зовнішніх програм' не відображається");
        softAssertion.assertTrue($(".app-tab__icon_appPasswords").isDisplayed(), "Іконка розділу 'Паролі для зовнішніх програм' не відображається.");
        softAssertion.assertTrue($(locatorOpenAppPasswords).isDisplayed(), "Елемент розкриття" +
            " розділу 'Паролі для зовнішніх програм' не відображається.");
        softAssertion.assertEquals("Паролі для зовнішніх програм", $(locatorTitleAppPasswords).getText(),
                "Заголовок 'Паролі для зовнішніх програм' не відображається для першого розділу на сторінці 'Безпека'.");
        softAssertion.assertEquals("Налаштуйте IMAP-доступ, щоб працювати з поштою у зовнішніх програмах (наприклад, Microsoft Outlook, M.E.Doc) без використання браузера.",
                $(locatorDescriptionAppPasswords).getText(),
                "Текст опису розділу 'Паролі для зовнішніх програм' не відповідає документації.");
        screenshot("iconDefaultAccountDeletionTC9997"); //скріншот відкритих сесій - для перевірки кольору елементів


        //Перевірка дизайну заголовку розділу "Паролі для зовнішніх програм"
        for (int i = 0; i < 8; i++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-weight", "font-family", "cursor", "line-height", "margin", "padding-top"};
            String[] propertiesPapameterCssTitle = new String[]{titleInactivColor, titleInactivFontSize, titleInactivFontWeiht,
                    titleInactivnFontFamily, titleInactivCursor, titleInactivLineHeight, titleInactivMargin, titleInactivPaddingTop};

            String varNamePapametersCss = namePapametersCss[i];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[i];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorTitleAppPasswords).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта заголовку 'Паролі для зовнішніх програм' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        //Перевірка дизайну опису розділу "Паролі для зовнішніх програм"
        for (int j = 0; j < 4; j++) {
            String[] namePapametersCss = new String[]{"color", "font-size", "font-family", "margin"};
            String[] propertiesPapameterCssTitle = new String[]{desTitleInactivColor, desTitleInactivFontSize, desTitleInactivFontFamily, desTitleInactivMargin};

            String varNamePapametersCss = namePapametersCss[j];
            String varPropertiesPapametersCssTitle = propertiesPapameterCssTitle[j];

            softAssertion.assertEquals(varPropertiesPapametersCssTitle, $(locatorDescriptionAppPasswords).getCssValue(varNamePapametersCss),
                    "\""+varNamePapametersCss+" шрифта опису розділа 'Паролі для зовнішніх програм' не відповідає документації'"+varPropertiesPapametersCssTitle+"'.");
        }

        softAssertion.assertAll();
    isStopFrame();
    }
}
