package com.yuliya1303.pages.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String year, String month, String day) {
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__month").$(byText(day)).click();

    }
}
