package pages;

import pages.components.Calendar;
import pages.components.ModalDialog;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Calendar calendar = new Calendar();
    ModalDialog modalDialog = new ModalDialog();

    public void openRegistrationForm(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        $(".text-center").shouldBe(visible);
    }

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

    public void selectSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();
    }

    public void selectHobby(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
    }

    public void fileUpload(String value){
        $("#uploadPicture").uploadFromClasspath(value);
    }

    public void setAddress(String value){
        $("#currentAddress").setValue(value);
    }

    public void clickSubmitButton(){
        $("#submit").scrollTo().click();
    }

    public void modalDialogShouldAppear(){
        modalDialog.modalDialogShouldAppearing();
    }

    public void modalDialogShouldHaveText(String name, String surname,String email,String phone,
                                          String gender,String address,String subject,String hobby){
        modalDialog.modalDialogShouldHaveTexting(name, surname, email, phone, gender, address, subject, hobby);
    }
}
