package tests.selenideTest;

import org.junit.jupiter.api.Disabled;
import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FScriptTest {

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
        $("#firstName").setValue("Vasiliy");
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
        $(".table-responsive").shouldHave(text("Vasiliy"), text("Strelnikov"), text("vas@mail.ru"));
        $x("//td[text() = 'Vasiliy Strelnikov']").shouldHave(text("Vasiliy Strelnikov"));
        $x("//td[text() = '1234567890']").shouldHave(text("1234567890"));
        $x("//td[text() = 'Male']").shouldHave(text("Male"));
        $x("//td[text() = 'vas@mail.ru']").shouldHave(text("vas@mail.ru"));
        $x("//td[text() = 'address']").shouldHave(text("address"));
        $x("//td[text() = 'Maths']").shouldHave(text("Maths"));
        $x("//td[text() = 'Sports']").shouldHave(text("Sports"));
    }

    @Test
    @Disabled("disabled test")
    void successfulRegistrationFormsTest(){
        new RegistrationPage().openRegistrationForm();
        new RegistrationPage().setFirstName("Vasiliy");
        new RegistrationPage().setLastName("Strelnikov");
        new RegistrationPage().setEmail("vas@mail.ru");
        new RegistrationPage().setPhone("1234567890");
        new RegistrationPage().selectGender("Male");
        new RegistrationPage().setBirthday("July", "2004", "30");
        new RegistrationPage().selectSubject("Maths");
        new RegistrationPage().selectHobby("Sports");
        new RegistrationPage().fileUpload("1.png");
        new RegistrationPage().setAddress("address");
        new RegistrationPage().selectState("NCR");
        new RegistrationPage().selectCity("Delhi");
        new RegistrationPage().clickSubmitButton();
        new RegistrationPage().modalDialogShouldAppear();
        new RegistrationPage().modalDialogShouldHaveText("Vasiliy", "Strelnikov", "vas@mail.ru",
                "1234567890", "Male", "address", "Maths", "Sports");
    }
}
