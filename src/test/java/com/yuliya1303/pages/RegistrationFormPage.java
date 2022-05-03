package com.yuliya1303.pages;

import com.codeborne.selenide.SelenideElement;
import com.yuliya1303.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    SelenideElement registrationPageTitle = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobileNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressStreet = $("#currentAddress"),
            state = $("#state"),
            stateMenu = $(".css-26l3qy-menu"),
            city = $("#city"),
            cityMenu = $(".css-26l3qy-menu"),
            submitBtn = $("#submit"),
            expectedResultTable = $(".table-responsive");

    //actions
    @Step("Open Registration Page")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        registrationPageTitle.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Enter First name")
    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    @Step("Enter Last name")
    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    @Step("Enter Email name")
    public RegistrationFormPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    @Step("Select Gender")
    public RegistrationFormPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    @Step("Enter Mobile phone")
    public RegistrationFormPage setMobilePhone(String value) {
        mobileNumber.setValue(value);

        return this;
    }

    @Step("Select Birthday date")
    public RegistrationFormPage setBirthdayDate(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    @Step("Enter Subject")
    public RegistrationFormPage setSubject(String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }

    @Step("Select Hobby")
    public RegistrationFormPage setHobby(String value) {
        hobby.$(byText(value)).click();

        return this;
    }

    @Step("Upload Picture")
    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Enter Address")
    public RegistrationFormPage setAddress(String value) {
        addressStreet.setValue(value);

        return this;
    }

    @Step("Select State")
    public RegistrationFormPage setState(String value) {
        state.click();
        stateMenu.$(byText(value)).click();

        return this;
    }

    @Step("Select City")
    public RegistrationFormPage setCity(String value) {
        city.click();
        cityMenu.$(byText(value)).click();

        return this;
    }

    @Step("Submit form")
    public RegistrationFormPage submitRegistrationData() {
        submitBtn.click();

        return this;
    }

    @Step("Check result table")
    public RegistrationFormPage checkResult(String fieldName,String value) {
        expectedResultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }

}
