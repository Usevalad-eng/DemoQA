package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialog {
    public void modalDialogShouldAppearing(){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void modalDialogShouldHaveTexting(String name, String surname,String email,String phone,
                                          String gender,String address,String subject,String hobby){
        $(".table-responsive").shouldHave(text("Vasiliy"), text("Strelnikov"), text("vas@mail.ru"),
                text("1234567890"), text("Male"), text("address"), text("Maths"), text("Sports"));
    }
}
