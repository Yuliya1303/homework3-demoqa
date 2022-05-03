package com.yuliya1303.tests;

import com.github.javafaker.Faker;
import com.yuliya1303.pages.RegistrationFormPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.yuliya1303.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationFormTest extends TestBase {
    Faker faker = new Faker(new Locale("in"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().safeEmailAddress();
    String gender = getRandomGender(); //faker.demographic().sex(); - not used as "Other" option also should be here
    String mobile = faker.numerify("##########"); //faker.phoneNumber().phoneNumber(); - not used as numbers with extra symbols
    String yearOfBirth = Integer.toString(faker.number().numberBetween(1900,2022));
    String monthOfBirth = getRandomMonthsOfBirth();
    String dayOfBirth = getRandomBirthdayDay(monthOfBirth);
    String subject = getRandomSubject();
    String hobby = getRandomHobby();
    String picture = "fish.png";
    String currentAddressStreet = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";

    String fullName = format("%s %s", firstName, lastName);
    String expectedBirthdayDate = format("%s %s,%s",dayOfBirth, monthOfBirth,yearOfBirth);
    String expectedStateAndCity = format("%s %s", state, city);

    @Test
    @DisplayName("Valid Registration data is applied")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Registration")
    @Story("Registration")
    @Tag("Smoke")
    void fillRegistrationFormByValidData() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobilePhone(mobile)
                .setBirthdayDate(yearOfBirth,monthOfBirth,dayOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture("img/" + picture)
                .setAddress(currentAddressStreet)
                .setState(state)
                .setCity(city);

        registrationFormPage.submitRegistrationData();

        registrationFormPage.checkResult("Student Name",fullName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",mobile)
                .checkResult("Date of Birth",expectedBirthdayDate)
                .checkResult("Subjects",subject)
                .checkResult("Hobbies",hobby)
                .checkResult("Picture",picture)
                .checkResult("Address",currentAddressStreet)
                .checkResult("State and City",expectedStateAndCity);
    }

}
