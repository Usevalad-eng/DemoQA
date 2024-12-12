package tests.selenideTest;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FDataTest {

    RandomUtils rUtils = new RandomUtils();
    public static String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String userName = "Vasiliy";
    Faker faker = new Faker();

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
        $("#lastName").setValue(faker.superhero().name());
        $("#userEmail").setValue(rUtils.randomEmail());
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
        $("#stateCity-wrapper").$(byText(rUtils.randomItem(state))).click();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        System.out.println(LocalDateTime.now());
    }
}
