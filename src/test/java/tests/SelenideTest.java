package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void userShouldBeLoggedInUsingValidData() {

        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";

        open("https://www.saucedemo.com/");
        $("[data-test=username]").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $x("//input[@value='Login']").click();
        $(".header_secondary_container").shouldBe(visible, Duration.ofSeconds(5));
        $(".header_secondary_container").shouldHave(text("Products"));
    }

    /*@Test
    public void solntsevShouldBeTopContributor() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

        open("/selenide/selenide");
        $("BorderGrid").$(byText("Contributors"))
                .ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }*/
}
