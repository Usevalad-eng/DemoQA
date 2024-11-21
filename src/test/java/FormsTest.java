import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FormsTest {

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    /*@Test
    void formsSimpleTest() {
        open("/automation-practice-form");
        $(".text-center").shouldBe(visible);
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Strelnikov");
        $x("//label[@class ='custom-control-label' and text() = 'Male']").click();
        $$x("//input[@type = 'checkbox']").get(0).click(ClickOptions.withTimeout(Duration.ofSeconds(1)));
        $("#userNumber").setValue("1234567890");
        $("#submit").scrollTo().click();
    }*/

    @Test
    void formsTest() {
        open("/automation-practice-form");
        $(".text-center").shouldBe(visible);
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Strelnikov");
        $x("//label[@class ='custom-control-label' and text() = 'Male']").click();
        $("#userNumber").setValue("1234567890");
        $$x("//input[@type = 'checkbox']").get(0).click(ClickOptions.withTimeout(Duration.ofSeconds(1)));
        $("#submit").scrollTo().click();

        Selenide.switchTo().defaultContent();
        $x("//*[@id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));
    }
}
