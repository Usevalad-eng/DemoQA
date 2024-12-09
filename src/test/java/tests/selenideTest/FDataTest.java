package tests.selenideTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class FDataTest {

   String userName = "Vasiliy";

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formsTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        $(".text-center").shouldBe(visible);
        $("#firstName").setValue(userName);
        $("#lastName").setValue("Strelnikov");
        $("#userEmail").setValue("vas@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        //$x("//label[@class ='custom-control-label' and text() = 'Male']").click();
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("address");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        /*$(".table-responsive").shouldHave(text("Vasiliy"), text("Strelnikov"), text("vas@mail.ru"));
        $x("//td[text() = 'Vasiliy Strelnikov']").shouldHave(text("Vasiliy Strelnikov"));
        $x("//td[text() = '1234567890']").shouldHave(text("1234567890"));
        $x("//td[text() = 'Male']").shouldHave(text("Male"));
        $x("//td[text() = 'vas@mail.ru']").shouldHave(text("vas@mail.ru"));
        $x("//td[text() = 'address']").shouldHave(text("address"));
        $x("//td[text() = 'Maths']").shouldHave(text("Maths"));
        $x("//td[text() = 'Sports']").shouldHave(text("Sports"));*/
    }
}
