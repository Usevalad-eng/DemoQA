package tests.demoqa;

import model.UserSettings;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.base.BaseTest;

public class FormsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    UserSettings userSettings = new UserSettings("Vasiliy", "Strelnikov",
            "vas@mail.ru", "1234567890", "Male", "July", "2004", "30", "Maths",
            "Sports", "1.png", "address", "NCR", "Delhi");

    @Test
    void successfulRegistrationFormsTestForm(){
        registrationPage.openRegistrationForm();
        registrationPage.setFirstName(userSettings.getName());
        registrationPage.setLastName(userSettings.getLastname());
        registrationPage.setEmail(userSettings.getEmail());
        registrationPage.setPhone(userSettings.getPhone());
        registrationPage.selectGender(userSettings.getGender());
        registrationPage.setBirthday(userSettings.getMonth(), userSettings.getYear(), userSettings.getDay());
        registrationPage.selectSubject(userSettings.getSubject());
        registrationPage.selectHobby(userSettings.getHobby());
        registrationPage.fileUpload(userSettings.getFile());
        registrationPage.setAddress(userSettings.getAddress());
        registrationPage.selectState(userSettings.getState());
        registrationPage.selectCity(userSettings.getCity());
        registrationPage.clickSubmitButton();
        registrationPage.modalDialogShouldAppear();
        registrationPage.modalDialogShouldHaveText("Vasiliy", "Strelnikov", "vas@mail.ru",
                "1234567890", "Male", "address", "Maths", "Sports");
    }
}
