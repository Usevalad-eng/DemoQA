package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.base.BaseTest;

public class FormsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationFormsTest(){
        registrationPage.openRegistrationForm();
        registrationPage.setFirstName("Vasiliy");
        registrationPage.setLastName("Strelnikov");
        registrationPage.setEmail("vas@mail.ru");
        registrationPage.setPhone("1234567890");
        registrationPage.selectGender("Male");
        registrationPage.setBirthday("July", "2004", "30");
        registrationPage.selectSubject("Maths");
        registrationPage.selectHobby("Sports");
        registrationPage.fileUpload("1.png");
        registrationPage.setAddress("address");
        registrationPage.selectState("NCR");
        registrationPage.selectCity("Delhi");
        registrationPage.clickSubmitButton();
        registrationPage.modalDialogShouldAppear();
        registrationPage.modalDialogShouldHaveText("Vasiliy", "Strelnikov", "vas@mail.ru",
                "1234567890", "Male", "address", "Maths", "Sports");
    }
}
