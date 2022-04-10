package com.yuliya1303.pages;

import com.yuliya1303.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators

    //actions
    public RegistrationFormPage openPage () {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName (String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName (String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail (String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender (String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setMobilePhone (String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthdayDate (String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationFormPage setSubject (String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby (String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture (String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress (String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState (String value) {
        $("#state").click();
        $(".css-26l3qy-menu").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity (String value) {
        $("#city").click();
        $(".css-26l3qy-menu").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage submitRegistrationData() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkResult (String key,String value) {
        $(".modal-content").shouldHave(text(key + value));

        return this;
    }

}
