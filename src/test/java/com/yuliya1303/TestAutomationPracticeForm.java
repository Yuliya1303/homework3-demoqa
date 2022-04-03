package com.yuliya1303;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAutomationPracticeForm {

    @BeforeAll
    static void screenSetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FillRegistrationFormByValidData () {
        String firstName = "Yuliya";
        String lastName = "Byshko";
        String email = "yuliya@gmail.com";
        String gender = "Female";
        String mobile = "0123456789";
        String yearOfBirth = "1993";
        String monthOfBirth = "March";
        String dayOfBirth = "13";
        String subject = "English";
        String hobby = "Sports";
        String picture = "fish.png";
        String currentAddressStreet = "ul. Testovaya";
        String state = "NCR";
        String city = "Delhi";

        File FILE = new File("src/test/resources/" + picture);

        open("/automation-practice-form");

        // hide footer and GoogleAds (as Submit btn is not visible on my screen)
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__month").$(byText(dayOfBirth)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").sendKeys(FILE.getAbsolutePath());
        $("#currentAddress").setValue(currentAddressStreet);
        $("#state").click();
        $(".css-26l3qy-menu").$(byText(state)).click();
        $("#city").click();
        $(".css-26l3qy-menu").$(byText(city)).click();
        $("#submit").click();

        $(".modal-content").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(mobile),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text (subject),
                text (hobby),
                text (subject),
                text (picture),
                text (currentAddressStreet),
                text (state + " " + city)
        );

    }

}