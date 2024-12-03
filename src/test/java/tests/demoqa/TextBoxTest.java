package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void textBoxTest() {
        open("/text-box");
        $(".text-center").shouldBe(visible);
        $("#userName").setValue("Vasia");
        $("#userEmail").setValue("vasia@gmail.com");
        $("#currentAddress").setValue("vasia street, 20");
        $("#permanentAddress").setValue("vasia street, 21");
        $("#submit").scrollTo().click();

        $("#name").shouldHave(text("Vasia"));
        $("#email").shouldHave(text("vasia@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("vasia street, 20"));
        $("#output").$("#permanentAddress").shouldHave(text("vasia street, 21"));
    }
}
