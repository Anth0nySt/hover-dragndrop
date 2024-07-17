import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class dragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
        void dragAndDropTest() {
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));

        $("#column-b").dragAndDropTo("#column-a");
        $("#column-a").shouldHave(text("a"));
        $("#column-b").shouldHave(text("b"));
    }
}