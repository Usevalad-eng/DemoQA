package pages;

import pages.components.Calendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Calendar calendar = new Calendar();
    public void openRegistrationForm(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        $(".text-center").shouldBe(visible);
    }

    /*public RegistrationPage openRegistrationForm(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        $(".text-center").shouldBe(visible);
        return this;
    }*/

    public void setFirstName(String value){
        $("#firstName").setValue(value);
    }

    public void setLastName(String value){
        $("#lastName").setValue(value);
    }

    public void setEmail(String value){
        $("#userEmail").setValue(value);
    }

    public void setPhone(String value){
        $("#userNumber").setValue(value);
    }

    public void selectGender(String value){
        $("#genterWrapper").$(byText(value)).click();
    }

    public void setBirthday(String month, String year, String day){
        $("#dateOfBirthInput").scrollTo().click();
        calendar.selectDate(month, year, day);
    }

    public void selectState(String state){
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
    }

    public void selectCity(String city){
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }
}
