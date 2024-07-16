import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class hoverCheck {

    @BeforeAll

    static void beforeAll() {
        Configuration.browserSize = "3840 x 2160";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void hoverTest(){
        open("https://github.com/");
        $("div").$("header").$(byText("Solutions")).hover();
        $("div").$(byText("Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
