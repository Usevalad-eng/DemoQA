package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    public void selectDate(String month, String year, String day){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
