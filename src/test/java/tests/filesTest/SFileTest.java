package tests.filesTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SFileTest {

    @Test
    void selenide0FileDownloadTest() throws Exception{
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        try {
            $("[data-testid=raw-button]").download();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    void selenide1FileDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        $("[data-testid=raw-button]").download();
    }

    @Test
    @Disabled("some reason")
    void selenide0FileReadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("[data-testid=raw-button]").download();
        InputStream is = new FileInputStream(downloadFile);
        byte[] bytes = is.readAllBytes();
        String textContent = new String(bytes, StandardCharsets.UTF_8);
        assertThat(textContent).contains("This repository is the home of _JUnit 5_.");
        is.close();
    }

    @Test
    void selenide1FileReadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("[data-testid=raw-button]").download();
        InputStream is = new FileInputStream(downloadFile);
        try {
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of _JUnit 5_.");
        } finally {
            is.close();
        }
    }

    @Test
    @Disabled("some reason")
    void selenide2FileReadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("[data-testid=raw-button]").download();
        try (InputStream is = new FileInputStream(downloadFile)){
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of _JUnit 5_.");
        }
    }

    @Test
    void sUploadFileTest(){
        open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFromClasspath("1.png");
        $("#file-submit").click();
        $(".example").shouldHave(Condition.text("File Uploaded!"));
    }
}
