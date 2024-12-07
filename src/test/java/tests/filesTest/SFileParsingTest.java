package tests.filesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import model.ExampleJson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SFileParsingTest {

    ClassLoader cl = SFileParsingTest.class.getClassLoader();

    @Test
    void pdfParsingTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadPDF = $x("//a[@href = 'junit-user-guide-5.11.3.pdf']").download();
        PDF content = new PDF(downloadPDF);
        assertThat(content.author).contains("Sam Brannen");
    }

    @Test
    @Disabled("some reason")
    void xlsParsingTest() throws IOException {
        try (InputStream resource = cl.getResourceAsStream("financialSample.xlsx")){
            XLS content = new XLS(resource);
            assertThat(content.excel.getSheetAt(0).getRow(1)
                    .getCell(0).getStringCellValue().contains("Government"));
        }
    }

    @Test
    void zipParsingTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("testex.zip");
                ZipInputStream zip = new ZipInputStream(resource);
        ){
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null){
                    assertThat(entry.getName().contains("test.txt"));
            }
        }
    }

    @Test
    void jsonParsingTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resource = cl.getResourceAsStream("example.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ){
            ExampleJson jsonObj = gson.fromJson(reader, ExampleJson.class);
            assertThat(jsonObj.title).isEqualTo("example title");
            assertThat(jsonObj.exampleDiv.title).isEqualTo("s");
            assertThat(jsonObj.exampleDiv.flag).isEqualTo(true);

        }
    }

    @Test
    @Disabled("some reason")
    void jsonParsingTest2() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resource = cl.getResourceAsStream("example.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ){
            ExampleJson jsonObj = gson.fromJson(reader, ExampleJson.class);
            assertEquals("example title", jsonObj.title);
            assertThat(jsonObj.exampleDiv.title).isEqualTo("s");
            assertThat(jsonObj.exampleDiv.flag).isTrue();
            assertTrue(jsonObj.exampleDiv.flag);
        }
    }
}
