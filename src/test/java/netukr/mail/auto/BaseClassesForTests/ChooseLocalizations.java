package netukr.mail.auto.BaseClassesForTests;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;
import netukr.mail.auto.BaseClassesForTests.BaseTests;
import org.apache.log4j.Logger;

public class ChooseLocalizations extends BaseTests {
    public static Logger logger = Logger.getLogger(ChooseLocalizations.class);

    String SHEET_LANG;

    public void turnToUA() throws InterruptedException {
        turnToLanguage(initLanguage("UA"));
        SHEET_LANG = "Ukr";
    }

    public void turnToRU() throws InterruptedException {
        turnToLanguage(initLanguage("RU"));
        SHEET_LANG = "Ru";
    }

    public void turnToEN() throws InterruptedException {
        turnToLanguage(initLanguage("EN"));
        SHEET_LANG = "Eng";
    }

    private void turnToLanguage(String language) throws InterruptedException {
        open("https://mail.ukr.net/desktop#settings/interface");
        //
        $("[lang] > .select__value").shouldBe(Condition.enabled).click();
        String locatorWithLanguage = ".dropdown__list .link2:nth-of-type("+language+")";
        $(locatorWithLanguage).waitUntil(Condition.visible, 4000).click();
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
}
