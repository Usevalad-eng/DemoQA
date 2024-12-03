package tests.selenideTest;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.base.BaseTest;

public class FTest extends BaseTest {

    RegistrationPage regPage = new RegistrationPage();

    @Test
    void successfulRegistrationFormsTest(){
        regPage.openRegistrationForm();
        regPage.setFirstName("Vasiliy");
        regPage.setLastName("Strelnikov");
        regPage.setEmail("vas@mail.ru");
        regPage.setPhone("1234567890");
        regPage.selectGender("Male");
        regPage.setBirthday("July", "2004", "30");
        regPage.selectSubject("Maths");
        regPage.selectHobby("Sports");
        regPage.fileUpload("1.png");
        regPage.setAddress("address");
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.clickSubmitButton();
        regPage.modalDialogShouldAppear();
        regPage.modalDialogShouldHaveText("Vasiliy", "Strelnikov", "vas@mail.ru",
                "1234567890", "Male", "address", "Maths", "Sports");
    }
}
