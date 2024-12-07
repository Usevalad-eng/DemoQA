package tests.demoqa;

import model.User;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.base.BaseTest;

public class FormsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    User user = new User("Vasiliy", "Strelnikov",
            "vas@mail.ru", "1234567890", "Male", "July", "2004", "30", "Maths",
            "Sports", "1.png", "address", "NCR", "Delhi");

    @Test
    void successfulRegistrationFormsTestForm(){
        registrationPage.openRegistrationForm();
        registrationPage.setFirstName(user.getName());
        registrationPage.setLastName(user.getLastname());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPhone(user.getPhone());
        registrationPage.selectGender(user.getGender());
        registrationPage.setBirthday(user.getMonth(), user.getYear(), user.getDay());
        registrationPage.selectSubject(user.getSubject());
        registrationPage.selectHobby(user.getHobby());
        registrationPage.fileUpload(user.getFile());
        registrationPage.setAddress(user.getAddress());
        registrationPage.selectState(user.getState());
        registrationPage.selectCity(user.getCity());
        registrationPage.clickSubmitButton();
        registrationPage.modalDialogShouldAppear();
        registrationPage.modalDialogShouldHaveText("Vasiliy", "Strelnikov", "vas@mail.ru",
                "1234567890", "Male", "address", "Maths", "Sports");
    }
}
