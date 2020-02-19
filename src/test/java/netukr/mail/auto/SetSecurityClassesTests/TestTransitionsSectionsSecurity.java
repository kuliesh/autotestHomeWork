package netukr.mail.auto.SetSecurityClassesTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import netukr.mail.auto.BaseClassesForTests.BaseTests;
import netukr.mail.auto.helpers.ReaderFilesFromResources;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestTransitionsSectionsSecurity<softAssertion> extends BaseTests {
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
        Thread.sleep(time);
        //turnToUA(); //перемикаємося на українську розклдаку
    }

    //метод активації для кнопки Налаштуванн&Безпека
    void openSettingMenu() {
        $(".login-button").click();
    }

    void scrollToSettingMenu(){

        $(".login-button").scrollIntoView(true);
    }

    //ініціалізація csssecuritypage.properties
    //шлях до файлу
    URL csssecuritypage = ReaderFilesFromResources.getUrlFromResources ("csssecuritypage.properties");
    //создаем объект Properties и загружаем в него данные из файла.
    Properties propcss = new Properties();

        String buttonBackgroundColor = propcss.getProperty("button.background-color");
        String buttonColor = propcss.getProperty("button.color");
        String buttonFontSize = propcss.getProperty("button.font-size");
        String buttonCursor = propcss.getProperty("button.cursor");
        String buttonFontWeiht = propcss.getProperty("button.font-weight");
        String buttonFontFamily = propcss.getProperty("button.font-family");


    @Test //Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7466")
    public void TestC7466GoToOpenSession() throws InterruptedException {
        logger.info("Testing test-case №C7466");
        scrollToSettingMenu();
        openSettingMenu();
        $(byLinkText("Відкриті сесії")).click();

        String locatorTitleOpenSession = ".app section:nth-child(2) .app-tab__title";
        String hrefOpenSession = "desktop#security/sessions";

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7466"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");

        softAssertion.assertEquals(TestSetupURL + hrefOpenSession, url(), "Адреса сторінки розділу 'Відкриті сесії' " +
                "не відповідає документації href=" + hrefOpenSession + "\".");

        softAssertion.assertEquals("Відкриті сесії", $(locatorTitleOpenSession).getText(), "Заголовок 'Відкриті сесії'" +
                " не відображається на сторінці " + hrefOpenSession + " для вибраної локалізації.");
        //Перевірка дизайну заголовку розділу "Відкриті сесії"
        softAssertion.assertEquals("rgba(130, 175, 50, 1)", $(locatorTitleOpenSession).getCssValue("color"),
                "Колір шрифта заголовку 'Відкрити сесії' не відповідає '" + "rgba(130, 175, 50, 1)" + "'.");
        softAssertion.assertTrue($(".sessions-header").isDisplayed(), "Стовпеці таблиці 'Відкриті сесії' не відображаються.");
        /* Переписати, щоб тест відпрацьовувався
        softAssertion.assertEquals("rgb(255, 255, 255)", $(By.cssSelector(".sessions-header")).getCssValue("background"),
                "background таблиці 'Відкрити сесії' не відповідає '"+"rgb(255, 255, 255)"+"'.");
        softAssertion.assertEquals("solid rgba(204, 204, 204)", $(By.cssSelector(".sessions-header")).getCssValue("border"),
                "border таблиці 'Відкрити сесії' не відповідає '"+"solid rgba(204, 204, 204)"+"'.");
        */

        softAssertion.assertEquals("1px 0px", $(".sessions-header").getCssValue("border-width"),
                "border-width таблиці 'Відкрити сесії' не відповідає '" + "1px 0px" + "'.");
        softAssertion.assertEquals("rgba(140, 148, 158, 1)", $(".sessions-header").getCssValue("color"),
                "color тексту таблиці 'Відкрити сесії' не відповідає '" + "rgba(140, 148, 158, 1)" + "'.");
        softAssertion.assertEquals("flex", $(".sessions-header").getCssValue("display"),
                "display таблиці 'Відкрити сесії' не відповідає '" + "flex" + "'.");
        softAssertion.assertEquals("11px", $(".sessions-header").getCssValue("font-size"),
                "font-size таблиці 'Відкрити сесії' не відповідає '" + "11px" + "'.");
        softAssertion.assertEquals("30px", $(".sessions-header").getCssValue("line-height"),
                "line-height таблиці 'Відкрити сесії' не відповідає '" + "30px" + "'.");

        softAssertion.assertEquals("Остання активність", $(".sessions-header__time").getText(), "Стовпець 'Остання активність' має іншу назву.");
        softAssertion.assertEquals("Дані про пристрій", $(".sessions-header__device").getText(), "Стовпець 'Дані про пристрій' має іншу назву.");
        softAssertion.assertEquals("IP-адреса", $(".sessions-header__place").getText(), "Стовпець 'IP-адреса' має іншу назву.");
        softAssertion.assertEquals("Сьогодні", $(".sessions-item__date").getText(), "Відсутня активна тест сесія на момент тестування.");

        screenshot("iconDefaultOpenSessionTC7466"); //скріншот відкритих сесій - для перевірки кольору елементів

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Української локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7467")
    public void TestC7466GoToSecurityLog() throws InterruptedException {

        logger.info("Testing test-case №C7466");
        openSettingMenu();
        $(byLinkText("Журнал безпеки")).click();


        String locatorTitleSecurityLog = ".app section:nth-child(3) .app-tab__title";
        String hrefSecurityLog = "desktop#security/events";

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7467"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");

        softAssertion.assertEquals(TestSetupURL + hrefSecurityLog, url(), "Адреса сторінки розділу 'Журнал безпеки' " +
                "не відповідає документації href=" + hrefSecurityLog + "\".");

        softAssertion.assertEquals("Журнал безпеки", $(locatorTitleSecurityLog).getText(), "Заголовок 'Журнал безпеки'" +
                " не відображається на сторінці " + hrefSecurityLog + " для вибраної локалізації.");
        //Перевірка дизайну заголовку розділу "Відкриті сесії"
        softAssertion.assertEquals("rgba(130, 175, 50, 1)", $(locatorTitleSecurityLog).getCssValue("color"),
                "Колір шрифта заголовку 'Журнала безпеки' не відповідає '" + "rgba(130, 175, 50, 1)" + "'.");
        softAssertion.assertTrue($(".events-header").isDisplayed(), "Стовпець таблиці 'Журнала безпеки' не відображаються.");
        /* Переписати, щоб тест відпрацьовувався
        softAssertion.assertEquals("rgb(255, 255, 255)", $(By.cssSelector(".sessions-header")).getCssValue("background"),
                "background таблиці 'Журнала безпеки' не відповідає '"+"rgb(255, 255, 255)"+"'.");
        softAssertion.assertEquals("solid rgba(204, 204, 204)", $(By.cssSelector(".sessions-header")).getCssValue("border"),
                "border таблиці 'Журнала безпеки' не відповідає '"+"solid rgba(204, 204, 204)"+"'.");
        */

        softAssertion.assertEquals("1px 0px", $(".events-header").getCssValue("border-width"),
                "border-width таблиці 'Журнал безпеки' не відповідає '" + "1px 0px" + "'.");
        softAssertion.assertEquals("rgba(140, 148, 158, 1)", $(".events-header > .events-header__time").getCssValue("color"),
                "color тексту таблиці 'Журнал безпеки' не відповідає '" + "rgba(140, 148, 158, 1)" + "'.");
        softAssertion.assertEquals("flex", $(".events-header").getCssValue("display"),
                "display таблиці 'Журнал безпеки' не відповідає '" + "flex" + "'.");
        softAssertion.assertEquals("11px", $(".events-header .events-header__time").getCssValue("font-size"),
                "font-size таблиці 'Журнал безпеки' не відповідає '" + "11px" + "'.");
        softAssertion.assertEquals("30px", $(".events-header").getCssValue("line-height"),
                "line-height таблиці 'Журнал безпеки' не відповідає '" + "30px" + "'.");

        softAssertion.assertEquals("Остання активність", $(".events-header__time").getText(), "Стовпець 'Остання активність' має іншу назву.");
        softAssertion.assertEquals("Події і дані про сесію", $(".events-header__data").getText(), "Стовпець 'Події і дані про сесію' має іншу назву.");
        softAssertion.assertEquals("IP-адреса", $(".events-header__place").getText(), "Стовпець 'IP-адреса' має іншу назву.");
        softAssertion.assertEquals("Сьогодні", $(".events-item__date").getText(), "Відсутня активна тест подія на момент тестування.");

        screenshot("iconDefaultSecurityLogTC7466"); //скріншот відкритих сесій - для перевірки кольору елементів

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Укр локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7468")
    public void TestC7468GoToPasswordChange() throws InterruptedException {

        logger.info("Testing test-case №C7468");
        openSettingMenu();
        $(byLinkText("Зміна пароля")).click();

        String locatorTitlePasswordChange = ".app section:nth-child(4) .app-tab__title";
        String hrefPasswordChange = "desktop#security/changePassword";
        Configuration.reportsFolder = ScreenshotURL + "/reportsC7468"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");

        softAssertion.assertEquals(TestSetupURL + hrefPasswordChange, url(), "Адреса сторінки розділу 'Зміна пароля' " +
                "не відповідає документації href=" + hrefPasswordChange + "\".");

        softAssertion.assertEquals("Зміна пароля", $(locatorTitlePasswordChange).getText(), "Заголовок 'Зміна пароля'" +
                " не відображається на сторінці " + hrefPasswordChange + " для вибраної локалізації.");
        //Перевірка дизайну заголовку розділу "Зміна пароля"
        softAssertion.assertEquals("rgba(130, 175, 50, 1)", $(locatorTitlePasswordChange).getCssValue("color"),
                "Колір шрифта заголовку 'Зміна пароля' не відповідає rgba(130, 175, 50, 1).");

        /////////////////////////////////////////////////////////////////////////////////////////
//        //Пояснювальний текст розділу - ПЕРЕПИСАТИ
//        softAssertion.assertEquals("Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо дотримуватися рекомендацій зі створення безпечного пароля і час від часу змінювати його заради вашої безпеки.",
//               $(".app-tab__desc").getText(), "Пояснювальний текст розділу 'Зміна пароля не відповідає документації'");
//
//        //Перевірка відображення елементів - ПЕРЕПИСАТИ
//           //наведення курсора
//        $(".change-password-tips__target").hover();
//               //перевірка, що колір змінився
//        softAssertion.assertEquals("rgba(130, 175, 50, 1)", $(".change-password-tips__target").getCssValue("color"),
//                "Колір шрифта заголовку 'рекомендацій зі створення' не відповідає '"+"rgba(130, 175, 50, 1)"+"'.");
        //Дописати перевірку випадаючого тексту

        /////////////////////////////////////////////////////////////

        softAssertion.assertTrue($(".change-password__field:nth-of-type(2)").isDisplayed());
        softAssertion.assertEquals("Введіть поточний пароль", $("div:nth-child(2) > label").getText(),
                "Не відображається підпис для поля 'Введіть поточний пароль'");

        softAssertion.assertTrue($(".change-password__field:nth-of-type(3)").isDisplayed());
        softAssertion.assertEquals("Придумайте новий пароль", $("div:nth-child(3) > label").getText(),
                "Не відображається підпис для поля 'Придумайте новий пароль'");

        softAssertion.assertTrue($(".change-password__field:nth-of-type(4)").isDisplayed());
        softAssertion.assertEquals("Введіть новий пароль повторно", $("div:nth-child(4) > label").getText(),
                "Не відображається підпис для поля 'Введіть новий пароль повторно'");

        String buttonChangePassword = ".change-password__submit > .button__content";
        softAssertion.assertTrue($(".change-password__submit").isDisplayed());
        softAssertion.assertEquals("Змінити пароль", $(buttonChangePassword).getText(),
                "Не відображається коректний підпис кнопки 'Змінити пароль' для української локалізації");
        softAssertion.assertEquals(buttonBackgroundColor, $(buttonChangePassword).getCssValue("background-color"),
                "background-color кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonBackgroundColor+".");
        softAssertion.assertEquals(buttonColor, $(buttonChangePassword).getCssValue("color"),
                "color тексту кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonColor+".");

        softAssertion.assertEquals(buttonFontSize, $(buttonChangePassword).getCssValue("font-size"),
                "font-size тексту кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonFontSize+".");
        softAssertion.assertEquals(buttonCursor, $(buttonChangePassword).getCssValue("cursor"),
                "cursor тексту кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonCursor+".");
        softAssertion.assertEquals(buttonFontWeiht, $(buttonChangePassword).getCssValue("font-weight"),
                "font-weight тексту кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonFontWeiht+".");
        softAssertion.assertEquals(buttonFontFamily, $(buttonChangePassword).getCssValue("font-family"),
                "font-family тексту кнопки 'Змінити пароль' в особистих даних не відповідає документації: "+buttonFontFamily+".");

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Укр локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7469")
    public void TestC7469GoToContactRecovery() throws InterruptedException {

        logger.info("Testing test-case №C7469");
        openSettingMenu();
        $(byLinkText("Контакти для відновлення")).click();

        String locatorTitleContatsRecovery = ".app section:nth-child(5) .app-tab__title";
        String hrefContatsRecovery = "desktop#security/contacts";

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7469"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");
        softAssertion.assertEquals(TestSetupURL + hrefContatsRecovery, url(), "Адреса сторінки розділу 'Контакти для відновлення' " +
                "не відповідає документації href=" + hrefContatsRecovery + "\".");

        softAssertion.assertEquals("Контакти для відновлення", $(locatorTitleContatsRecovery).getText(), "Заголовок 'Контакти для відновлення'" +
                " не відображається на сторінці " + hrefContatsRecovery + " для вибраної локалізації.");
        softAssertion.assertEquals("rgba(102, 153, 0, 1)", $(locatorTitleContatsRecovery).getCssValue("color"),
                "Колір шрифта заголовку 'Контакти для відновлення' не відповідає rgba(102, 153, 0, 1).");

        for (int i = 0; i < 2; i++) {
            String[] contDevice = new String[]{"Мобільний телефон", "Резервний e-mail"};
            int[] indexLocator = new int[]{1, 2};

            int indexContact = indexLocator[i];
            String varContact = contDevice[i];

            softAssertion.assertTrue($("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").isDisplayed(), "Не відображається розділ в контактах для " +
                    "відновлення '" + varContact + "' ");
            softAssertion.assertEquals(varContact, $("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").getText(),
                    "Назва розділу контактів для відновлення '" + varContact + "' не відповідна до української локалізації.");
            softAssertion.assertEquals("rgba(52, 56, 64, 1)", $("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").getCssValue("color"),
                    "color для заголовку '" + varContact + "' не є 'rgba(52, 56, 64, 1)'");
            softAssertion.assertEquals("14px", $("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").getCssValue("font-size"),
                    "font-size для заголовку '" + varContact + "' не є '14px'.");
            softAssertion.assertEquals("700", $("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").getCssValue("font-weight"),
                    "font-weight для заголовку '" + varContact + "' не є '700'.");
            softAssertion.assertEquals("30px", $("article:nth-of-type(" + indexContact + ") > .contacts-type-list__title").getCssValue("line-height"),
                    "line-height для заголовку '" + varContact + "' не є '30px'.");
        }

        for (int j = 0; j < 2; j++) {
            String[] addContDevice = new String[]{"додати альтернативний мобільний телефон", "додати резервний e-mail"};
            int[] indexLocator = new int[]{1, 2};

            int indexAddContact = indexLocator[j];
            String varAddContact = addContDevice[j];

            softAssertion.assertTrue($(".contacts-type-list:nth-of-type(" + indexAddContact + ") > [type]").isDisplayed(),
                    "Не відображається в контактах для відновлення кнопка '" + varAddContact + "'.");
            softAssertion.assertEquals(varAddContact, $(".contacts-type-list:nth-of-type(" + indexAddContact + ") > [type]").getText(),
                    "Назва кнопки '" + varAddContact + "' в контактах для відновлення не відповідна до української локалізації.");
            softAssertion.assertEquals("rgba(102, 153, 0, 1)", $(".contacts-type-list:nth-of-type(" + indexAddContact + ") > [type]").getCssValue("color"),
                    "color для кнопки '" + varAddContact + "' не є 'rgba(102, 153, 0, 1)'");
            softAssertion.assertEquals("12px", $(".contacts-type-list:nth-of-type(" + indexAddContact + ") > [type]").getCssValue("font-size"),
                    "font-size для кнопки '" + varAddContact + "' не є '12px'.");
            softAssertion.assertEquals("700", $(".contacts-type-list:nth-of-type(" + indexAddContact + ") > [type]").getCssValue("font-weight"),
                    "font-weight для кнопки '" + varAddContact + "' не є '700'.");
        }

        for (int l = 0; l < 2; l++) {
            String[] buttonAction = new String[]{"Замінити", "Видалити"};
            String[] buttonColor = new String[]{"rgba(102, 153, 0, 1)", "rgba(204, 204, 204, 1)"};
            int[] indexButtonAction = new int[]{1, 2};

            int indexAddButtonAction = indexButtonAction[l];
            String varButtonAction = buttonAction[l];
            String varButtonColor = buttonColor[l];

            softAssertion.assertTrue($(".contacts-item__control-wrapper:nth-of-type(" + indexAddButtonAction + ") .text-button__content").isDisplayed(),
                    "Не відображається в контактах для відновлення кнопка '" + varButtonAction + "'.");
            softAssertion.assertEquals(varButtonAction, $(".contacts-item__control-wrapper:nth-of-type(" + indexAddButtonAction + ") .text-button__content").getText(),
                    "Назва кнопки '" + varButtonAction + "' в контактах для відновлення не відповідна до української локалізації.");
            softAssertion.assertEquals(varButtonColor, $(".contacts-item__control-wrapper:nth-of-type(" + indexAddButtonAction + ") .text-button__content").getCssValue("color"),
                    "color для кнопки '" + varButtonAction + "' не є '" + varButtonColor + "'");
            softAssertion.assertEquals("12px", $(".contacts-item__control-wrapper:nth-of-type(" + indexAddButtonAction + ") .text-button__content").getCssValue("font-size"),
                    "font-size для кнопки '" + varButtonAction + "' не є '12px'.");
            softAssertion.assertEquals("700", $(".contacts-item__control-wrapper:nth-of-type(" + indexAddButtonAction + ") .text-button__content").getCssValue("font-weight"),
                    "font-weight для кнопки '" + varButtonAction + "' не є '700'.");
        }

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Укр локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7470")
    public void TestC7470GoToPersonalData() throws InterruptedException {

        logger.info("Testing test-case №C7470");
        openSettingMenu();
        $(byLinkText("Особисті дані")).click();

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7470"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        String locatorTitlePersonalData = ".app section:nth-child(6) .app-tab__title";
        String hrefPersonalData = "desktop#security/personalData";

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(TestSetupURL + hrefPersonalData, url(), "Адреса сторінки розділу 'Особисті дані' не відповідає документації " +
                "href=" + hrefPersonalData + "\".");
        softAssertion.assertEquals("Особисті дані", $(locatorTitlePersonalData).getText(), "Заголовок 'Особисті дані'" +
                " не відображається на сторінці " + hrefPersonalData + " для вибраної локалізації.");
        softAssertion.assertEquals("rgba(102, 153, 0, 1)", $(locatorTitlePersonalData).getCssValue("color"),
                "Колір шрифта заголовку 'Особисті дані' не відповідає rgba(102, 153, 0, 1).");


        for (int i = 0; i < 4; i++) {
            String[] namePersonalDataTitle = new String[]{"Ім'я", "Прізвище", "Дата народження", "Стать"};
            String[] locatorPersonalDataTitle = new String[]{".first-name-item > .personal-data-title", ".last-name-item > .personal-data-title",
                    ".birth-day-item > .personal-data-title", ".sex-item > .personal-data-title"};

            String varNamePersonalDataTitle = namePersonalDataTitle[i];
            String varLocatorPersonalDataTitle = locatorPersonalDataTitle[i];

            softAssertion.assertTrue($(varLocatorPersonalDataTitle).isDisplayed(),
                    "Не відображається в особистих даних заголовок'" + varNamePersonalDataTitle + "'.");
            softAssertion.assertEquals(varNamePersonalDataTitle, $(varLocatorPersonalDataTitle).getText(), "Текст заголовку '" + varNamePersonalDataTitle + "' не відповідає Українській локалізації.");
            softAssertion.assertEquals("rgba(0, 0, 0, 1)", $(varLocatorPersonalDataTitle).getCssValue("color"),
                    "color заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: rgba(0, 0, 0, 1).");
            softAssertion.assertEquals("block", $(varLocatorPersonalDataTitle).getCssValue("display"),
                    "display заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: block.");
            softAssertion.assertEquals("14px", $(varLocatorPersonalDataTitle).getCssValue("font-size"),
                    "font-size заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: 14px.");
            softAssertion.assertEquals("700", $(varLocatorPersonalDataTitle).getCssValue("font-weight"),
                    "font-weight заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: 700).");
            softAssertion.assertEquals("26px", $(varLocatorPersonalDataTitle).getCssValue("height"),
                    "height заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: 26px.");
            softAssertion.assertEquals("300px", $(varLocatorPersonalDataTitle).getCssValue("width"),
                    "width заголовку '" + varNamePersonalDataTitle + "' не відповідає документації: 300px.");
        }

        String buttonPersonalDataEdit = ".personal-data-viewer__edit";

        softAssertion.assertTrue($(buttonPersonalDataEdit).isDisplayed(), "Кнопка 'Редагувати' не відображається в розділі 'Особисті дані'.");
        softAssertion.assertEquals("Редагувати", $(buttonPersonalDataEdit).getText(), "Ім'я кнопки 'Редагувати' в особистих даних не відповідає документації.");
        softAssertion.assertEquals(buttonBackgroundColor, $(buttonPersonalDataEdit).getCssValue("background-color"),
                "background-color кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonBackgroundColor+".");
        softAssertion.assertEquals(buttonColor, $(buttonPersonalDataEdit).getCssValue("color"),
                "color тексту кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonColor+".");

        softAssertion.assertEquals(buttonFontSize, $(buttonPersonalDataEdit).getCssValue("font-size"),
                "font-size тексту кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonFontSize+".");
        softAssertion.assertEquals(buttonCursor, $(buttonPersonalDataEdit).getCssValue("cursor"),
                "cursor тексту кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonCursor+".");
        softAssertion.assertEquals(buttonFontWeiht, $(buttonPersonalDataEdit).getCssValue("font-weight"),
                "font-weight тексту кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonFontWeiht+".");
        softAssertion.assertEquals(buttonFontFamily, $(buttonPersonalDataEdit).getCssValue("font-family"),
                "font-family тексту кнопки 'Редагувати' в особистих даних не відповідає документації: "+buttonFontFamily+".");

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Укр локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7471")
    public void TestC7471GoToAppPasswords() throws InterruptedException {

        logger.info("Testing test-case №C7471");
        openSettingMenu();
        $(byLinkText("Паролі для зовнішніх програм")).click();

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7471"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        String locatorTitleAppPasswords = ".app section:nth-child(7) .app-tab__title";
        String hrefAppPasswords = "desktop#security/appPasswords";

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(TestSetupURL + hrefAppPasswords, url(), "Адреса сторінки розділу 'Особисті дані' не відповідає документації " +
                "href=" + hrefAppPasswords + "\".");
        softAssertion.assertEquals("Паролі для зовнішніх програм", $(locatorTitleAppPasswords).getText(), "Заголовок 'Особисті дані'" +
                " не відображається на сторінці " + hrefAppPasswords + " для вибраної локалізації.");
        softAssertion.assertEquals("rgba(102, 153, 0, 1)", $(locatorTitleAppPasswords).getCssValue("color"),
                "Колір шрифта заголовку 'Особисті дані' не відповідає rgba(102, 153, 0, 1).");


        for (int i=0; i<3; i++){

            String[] textDefaultAppPasswords = new String[]{"Доступ для зовнішніх програм",
                    "Паролі для зовнішніх програм не створені",
                    "Щоб відкрити доступ до вашої скриньки для зовнішньої програми, включіть доступ, згенеруйте окремий пароль і введіть його в налаштуваннях цієї програми."};
            String[] locatorTextDefaultAppPasswords = new String[]{".ap-switcher", ".ap-descr__title", ".ap-descr__info"};
            String[] fontSizeTestDefaultAppPasswords = new String[]{"14px", "14px", "12px"};

            String varTextDefaultAppPasswords = textDefaultAppPasswords[i];
            String varLocatorTextDefaultAppPasswords = locatorTextDefaultAppPasswords[i];
            String varFontSizeTestDefaultAppPasswords = fontSizeTestDefaultAppPasswords[i];

            softAssertion.assertTrue($(varLocatorTextDefaultAppPasswords).isDisplayed(), "Текст '"+varTextDefaultAppPasswords+
                    "'не відображається на сторінці " + hrefAppPasswords + " для вибраної локалізації.");
            softAssertion.assertEquals(varTextDefaultAppPasswords, $(varLocatorTextDefaultAppPasswords).getText(), "'"+varTextDefaultAppPasswords+"'" +
                    " не відповідає вибраній локалізації.");
            softAssertion.assertEquals("rgba(52, 56, 64, 1)", $(varLocatorTextDefaultAppPasswords).getCssValue("color"),
                    "color шрифта тексту '"+varTextDefaultAppPasswords+"' не відповідає документації: rgba(52, 56, 64, 1).");
            softAssertion.assertEquals("Arial, sans-serif", $(varLocatorTextDefaultAppPasswords).getCssValue("font-family"),
                    "font-family шрифта тексту '"+varTextDefaultAppPasswords+"' не відповідає документації: Arial, sans-serif.");
            softAssertion.assertEquals("700", $(varLocatorTextDefaultAppPasswords).getCssValue("font-weight"),
                    "font-weight шрифта тексту '"+varTextDefaultAppPasswords+"' не відповідає документації: 700.");
            softAssertion.assertEquals(varFontSizeTestDefaultAppPasswords, $(varLocatorTextDefaultAppPasswords).getCssValue("font-size"),
                    "font-size шрифта тексту '"+varTextDefaultAppPasswords+"' не відповідає документації: "+varFontSizeTestDefaultAppPasswords+".");
                }

        String switcherPass = ".switch_style-desktop";
        softAssertion.assertTrue($(switcherPass).isDisplayed(), "Світчер  активації пароля " +
                "для зовнішніх програм відображається в розділі 'Паролі для зовнішніх програм'.");

        softAssertion.assertEquals("26px", $(switcherPass).getCssValue("height"),
                "height світчера активації пароля не відповідає документації: 26px.");
        softAssertion.assertEquals("13px", $(switcherPass).getCssValue("border-radius"),
                "border-radius світчера активації пароля не відповідає документації: 13px.");
        softAssertion.assertEquals("rgba(220, 224, 228, 1)", $(switcherPass).getCssValue("background"),
                "background світчера активації пароля не відповідає документації: rgba(220, 224, 228, 1).");

        softAssertion.assertAll();

            isStopFrame();
        }


    @Test //Перевірка для Укр локалізації
    @Owner(value = "Sergii Kuliesh")
    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink(value = "C7472")
    public void TestC7472GoToDeleteAccount() throws InterruptedException {

        logger.info("Testing test-case №C7472");
        scrollToSettingMenu();
        openSettingMenu();
        $(byLinkText("Видалення акаунта")).click();

        String locatorTitleDeleteAccount = ".app section:nth-child(8) .app-tab__title";
        String hrefDeleteAccount = "desktop#security/deleteAccount";

        Configuration.reportsFolder = ScreenshotURL + "/reportsC7472"; //де зберігати скріншот
        //ПОСТАВИТИ ОЧИКУВАННЯ

        isRunFrame();
        Thread.sleep(time);

        SoftAssert softAssertion = new SoftAssert();

        logger.info("VerifiedDefaultTitle");

        softAssertion.assertEquals(TestSetupURL + hrefDeleteAccount, url(), "Адреса сторінки розділу 'Видалення акаунта' " +
                "не відповідає документації href=" + hrefDeleteAccount + "\".");

        softAssertion.assertEquals("Видалення акаунта", $(locatorTitleDeleteAccount).getText(), "Заголовок 'Видалення акаунта'" +
                " не відображається на сторінці " + hrefDeleteAccount + " для вибраної локалізації.");
        softAssertion.assertEquals("rgba(102, 153, 0, 1)", $(locatorTitleDeleteAccount).getCssValue("color"),
                "Колір шрифта заголовку 'Видалення акаунта' не відповідає rgba(102, 153, 0, 1).");

        //Перевірка текстів

        //Перевірка чекбоксів

        //Перевірка текстів для чекбоксів
        for (int i=0; i<6; i++){
        String[] locatorCauseDeleteAccounts = new String[]{"Я створював(ла) цю скриньку для реєстрації на інших сайтах і не планую використовувати її у майбутньому.",
                "Я створював(ла) цю скриньку для отримання розсилок, і вони мені більше не потрібні.",
                "Я створював(ла) цю скриньку для робочого і(чи) особистого листування, але вона мені більше не потрібна.",
                "Я створив(ла) іншу поштову скриньку.",
                "Я почав(ла) отримувати забагато спаму в цю скриньку.",
                "Я хочу видалити цю скриньку з міркувань безпеки."};

        String varLocatorCauseDeleteAccounts = locatorCauseDeleteAccounts[i];

        softAssertion.assertEquals(varLocatorCauseDeleteAccounts, $("[for='id-reason-"+i+"']:nth-child(3)").getText() ,
                "Текст для вибору варіанту видалення пароля: '"+varLocatorCauseDeleteAccounts+"', не відповідає документації для даної локалізації.");

            softAssertion.assertEquals("0px 0px 0px 10px", $("[for='id-reason-"+i+"']:nth-child(3)").getCssValue("margin") ,
                    "margin для тексту для вибору варіанту видалення пароля: '"+varLocatorCauseDeleteAccounts+"', не відповідає документації.");
            softAssertion.assertEquals("12px", $("[for='id-reason-"+i+"']:nth-child(3)").getCssValue("font-size") ,
                    "font-size для тексту для вибору варіанту видалення пароля: '"+varLocatorCauseDeleteAccounts+"', не відповідає документації.");
            softAssertion.assertEquals("rgba(52, 56, 64, 1)", $("[for='id-reason-"+i+"']:nth-child(3)").getCssValue("color") ,
                    "color для тексту для вибору варіанту видалення пароля: '"+varLocatorCauseDeleteAccounts+"', не відповідає документації.");
            softAssertion.assertEquals("Arial, sans-serif", $("[for='id-reason-"+i+"']:nth-child(3)").getCssValue("font-family") ,
                    "font-family для тексту для вибору варіанту видалення пароля: '"+varLocatorCauseDeleteAccounts+"', не відповідає документації.");
        }

        String locatorCauseDeleteAccountsOther = "div:nth-of-type(7)";
        String nameCauseDeleteAccountsOther = "Інше";
        softAssertion.assertEquals(nameCauseDeleteAccountsOther, $(locatorCauseDeleteAccountsOther).getText() ,
                "Текст для вибору варіанту видалення пароля: '"+nameCauseDeleteAccountsOther+"', не відповідає документації для даної локалізації.");
        softAssertion.assertEquals("0px 20px 0px 60px", $(locatorCauseDeleteAccountsOther).getCssValue("margin") ,
                "margin для тексту для вибору варіанту видалення пароля: '"+nameCauseDeleteAccountsOther+"', не відповідає документації.");
        softAssertion.assertEquals("12px", $(locatorCauseDeleteAccountsOther).getCssValue("font-size") ,
                "font-size для тексту для вибору варіанту видалення пароля: '"+nameCauseDeleteAccountsOther+"', не відповідає документації.");
        softAssertion.assertEquals("rgba(52, 56, 64, 1)", $(locatorCauseDeleteAccountsOther).getCssValue("color") ,
                "color для тексту для вибору варіанту видалення пароля: '"+nameCauseDeleteAccountsOther+"', не відповідає документації.");
        softAssertion.assertEquals("Arial, sans-serif", $(locatorCauseDeleteAccountsOther).getCssValue("font-family") ,
                "font-family для тексту для вибору варіанту видалення пароля: '"+nameCauseDeleteAccountsOther+"', не відповідає документації.");

        //Поля введення пароля
        String IdPassworDelete = "input#id-password-input";
        softAssertion.assertTrue($(IdPassworDelete).isDisplayed(), "Кнопка 'Видалити акаунт' не відображається в розділі 'Видалення акаунта'.");
        softAssertion.assertEquals("Пароль", $(IdPassworDelete).getAttribute("placeholder"),
                "Підсказка 'Пароль' не відображається в полі введенян пароля для видалення акаунту.");

        //Первірка кнопки
        String buttonDeleteAccount = "button";

        softAssertion.assertTrue($(buttonDeleteAccount).isDisplayed(), "Кнопка 'Видалити акаунт' не відображається в розділі 'Видалення акаунту'.");
        softAssertion.assertEquals("Видалити акаунт", $(buttonDeleteAccount).getText(), "Ім'я кнопки 'Видалити акаунт' в особистих даних не відповідає документації.");
        softAssertion.assertEquals(buttonBackgroundColor, $(buttonDeleteAccount).getCssValue("background-color"),
                "background-color кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonBackgroundColor+".");
        softAssertion.assertEquals(buttonColor, $(buttonDeleteAccount).getCssValue("color"),
                "color тексту кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonColor+".");

        softAssertion.assertEquals(buttonFontSize, $(buttonDeleteAccount).getCssValue("font-size"),
                "font-size тексту кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonFontSize+".");
        softAssertion.assertEquals(buttonCursor, $(buttonDeleteAccount).getCssValue("cursor"),
                "cursor тексту кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonCursor+".");
        softAssertion.assertEquals(buttonFontWeiht, $(buttonDeleteAccount).getCssValue("font-weight"),
                "font-weight тексту кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonFontWeiht+".");
        softAssertion.assertEquals(buttonFontFamily, $(buttonDeleteAccount).getCssValue("font-family"),
                "font-family тексту кнопки 'Видалити акаунт' в особистих даних не відповідає документації: "+buttonFontFamily+".");

        softAssertion.assertAll();

        isStopFrame();
    }

    @AfterTest
    public void scrollToSetting(){
        scrollToSettingMenu();
    }

    @AfterClass //Винести потім в загальний клас
    public void clearSession() throws InterruptedException {
        logger.info("Clear all old session after test.");
        open("https://mail.ukr.net/desktop#security/sessions"); //відкриваємо сторінку входу до поштової скриньки
        isRunFrame();
        $("[type='submit']").click();
        $(byId("id-privilege-password")).sendKeys(",fhvfktq4");
        $(".button_style-main.popup-confirm__button").click();
        //ПОСТАВИТИ ОЧІКУВАННЯ
        Thread.sleep(time);
        isStopFrame();
    }
}
