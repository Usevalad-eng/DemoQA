package tests.junitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import tests.base.BaseTest;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class SDemoAuthTest extends BaseTest {

    static Stream<Arguments> selenideSdemoAuth() {
        return Stream.of(
                Arguments.of("", "", "Epic sadface: Username is required"),
                Arguments.of("standard_user", "", "Epic sadface: Password is required"),
                Arguments.of("", "secret_sauce", "Epic sadface: Username is required"),
                Arguments.of("standard", "secret",
                        "Epic sadface: Username and password do not match any user in this service")
        );
    }

    @MethodSource("selenideSdemoAuth")
    @ParameterizedTest(name = "Saucedemo auth negative test using JUnit5")
    void selenideSdemoAuth(String login, String pass, String error){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(login);
        $("#password").setValue(pass).pressEnter();
        String textOfMessage = $x("//h3[@data-test = 'error']").getText();
        Assertions.assertEquals(error, textOfMessage, "Error!");
    }

    @CsvSource({
            ",, Epic sadface: Username is required",
            "standard_user,, Epic sadface: Password is required",
            ",secret_sauce, Epic sadface: Username is required",
            "standard, secret, Epic sadface: Username and password do not match any user in this service"
    })
    @ParameterizedTest(name = "Saucedemo auth negative test using JUnit5")
    void selenideSdemoAuth2(String login, String pass, String error){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(login);
        $("#password").setValue(pass).pressEnter();
        String textOfMessage = $x("//h3[@data-test = 'error']").getText();
        Assertions.assertEquals(error, textOfMessage, "Error!");
    }

    @CsvFileSource(resources = "/dataSDemo.csv")
    @ParameterizedTest(name = "Saucedemo auth negative test using JUnit5")
    void selenideSdemoAuth3(String login, String pass, String error){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(login);
        $("#password").setValue(pass).pressEnter();
        String textOfMessage = $x("//h3[@data-test = 'error']").getText();
        Assertions.assertEquals(error, textOfMessage, "Error!");
    }

    @Test
    @Disabled("some reason")
    void SdemoAuth(){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("");
        $("#password").setValue("").pressEnter();
        String textOfMessage = $x("//h3[@data-test = 'error']").getText();
        Assertions.assertEquals("Epic sadface: Username is required", textOfMessage, "error!");
    }
}
