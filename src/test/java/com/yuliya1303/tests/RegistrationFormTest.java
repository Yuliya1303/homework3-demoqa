package com.yuliya1303.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.yuliya1303.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static com.yuliya1303.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationFormTest {
    Faker faker = new Faker(new Locale("in"));
    Random random = new Random();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().safeEmailAddress();
    String gender = getRandomGender(); //faker.demographic().sex(); - not used as "Other" option also should be here
    String mobile = Integer.toString((int) (random.nextInt()*10000000000L)); //faker.phoneNumber().phoneNumber(); - not used as numbers with extra symbols
    String yearOfBirth = Integer.toString(faker.number().numberBetween(1900,2022));
    String monthOfBirth = getRandomMonthsOfBirth();
    String dayOfBirth = getRandomBirthdayDay(monthOfBirth);
    String subject = getRandomSubject();
    String hobby = getRandomHobby();
    String picture = "fish.png";
    String currentAddressStreet = faker.address().streetAddress();
    String state = getRandomState(); //faker.address().state(); - not used as not all states are available in our app
    String city = getRandomCity(state); //the same

    String fullName = format("%s %s", firstName, lastName);
    String expectedBirthdayDate = format("%s %s,%s",dayOfBirth, monthOfBirth,yearOfBirth);

    @BeforeAll
    static void screenSetUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormByValidData() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobilePhone(mobile)
                .setBirthdayDate(yearOfBirth,monthOfBirth,dayOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(currentAddressStreet)
                .setState(state)
                .setCity(city);

        registrationFormPage.submitRegistrationData();

        registrationFormPage.checkResult("Student Name ",fullName)
                .checkResult("Student Email ",email)
                .checkResult("Gender ",gender)
                .checkResult("Mobile ",mobile)
                .checkResult("Date of Birth ",expectedBirthdayDate)
                .checkResult("Subjects ",subject)
                .checkResult("Hobbies ",hobby)
                .checkResult("Picture ",picture)
                .checkResult(" ",currentAddressStreet)
                .checkResult("State and City ",state + " " + city);

    }

}
