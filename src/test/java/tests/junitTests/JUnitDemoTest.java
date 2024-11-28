package tests.junitTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JUnitDemoTest extends BaseTest {

    @BeforeEach
    void openGoogle(){
        open("https://www.google.com/");
    }

    @Test
    @Disabled("mmm001")  //ctrl shift f
    @DisplayName("url0 must be on the first page")
    void demooTest() {
        Assertions.assertTrue(true);
        System.out.println("true");
        //Selenide.open("https://www.google.com/");
        Selenide.$("[name = q]").setValue("").pressEnter();
        $("#search").shouldHave(text("https://selenide.org"));
    }

    @Test
    @Tags({@Tag("Blocker"), @Tag("ui")})
    @DisplayName("url must be on the first page")
    void demoTest() {
        //open("https://www.google.com/");
        $("[name = q]").setValue("selenide").pressEnter();
        $("#search").shouldHave(text("https://selenide.org"));
    }

    @CsvSource({
        "selenide, https://selenide.org",
        "Allure testops, https://qameta.io"
    })
    @ParameterizedTest(name = "url {1} must be on page {0}")
    void demoParammTest(String prodName, String url) {
        //open("https://www.google.com/");
        $("[name = q]").setValue(prodName).pressEnter();
        $("#search").shouldHave(text(url));
    }

    @CsvFileSource(resources = "/data.csv")
    @ParameterizedTest(name = "url {1} must be on page {0}")
    void demoParamTest(String prodName, String url) {
        //open("https://www.google.com/");
        $("[name = q]").setValue(prodName).pressEnter();
        $("#search").shouldHave(text(url));
    }

    @ValueSource(
            strings = {"allure testops", "selenide"}
    )
    @ParameterizedTest(name = "url {1} must be on page {0}")
    void demoParaTest(String prodName) {
        //open("https://www.google.com/");
        $("[name = q]").setValue(prodName).pressEnter();
        $$("div[class = g]").shouldHave(CollectionCondition.sizeGreaterThan(3));
    }
}
