package tests.filesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SFileParsingTest {

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
        try (InputStream resource = getClass().getClassLoader().getResourceAsStream("tests-example.xls")){
            XLS content = new XLS(resource);
            boolean text = content.excel.getSheetAt(0).getRow(8)
                    .getCell(0).getStringCellValue().contains("Source");
            assertTrue(text);
        }
    }
}
