package com.yuliya1303.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    enum subjects {
        English, Chemistry, Commerce, Economics
    }

    enum hobbies {
        Sports, Reading, Music
    }

    enum gender {
        Male, Female, Other
    }

    enum states {
        NCR, Haryana
    }

    //not all, just to try
    enum months {
        January, February, March, April
    }

    public static String getRandomSubject() {
        List<subjects> subjectsList = Arrays.asList(subjects.values());
        Random randomSubject = new Random();
        return String.valueOf(subjectsList.get(randomSubject.nextInt(subjectsList.size())));
    }

    public static String getRandomHobby() {
        List<hobbies> hobbiesList = Arrays.asList(hobbies.values());
        Random randomHobby = new Random();
        return String.valueOf(hobbiesList.get(randomHobby.nextInt(hobbiesList.size())));
    }

    public static String getRandomGender() {
        List<gender> gendersList = Arrays.asList(gender.values());
        Random randomGender = new Random();
        return String.valueOf(gendersList.get(randomGender.nextInt(gendersList.size())));
    }

    public static String getRandomState() {
        List<states> StatesList = Arrays.asList(states.values());
        Random randomState = new Random();
        return String.valueOf(StatesList.get(randomState.nextInt(StatesList.size())));
    }

    public static String getRandomCity(String value) {
        String city;
        switch (value) {
            case "NCR":
                List<String> CitiesListNCR = List.of("Delhi", "Gurgaon");
                Random randomCityNCR = new Random();
                city = CitiesListNCR.get(randomCityNCR.nextInt(CitiesListNCR.size()));
                break;

            case "Haryana":
                List<String> CitiesListHar = List.of("Karnal", "Panipat");
                Random randomCityHar = new Random();
                city = CitiesListHar.get(randomCityHar.nextInt(CitiesListHar.size()));
                break;

            case "Uttar Pradesh":
                List<String> CitiesListPrad = List.of("Agra", "Lucknow");
                Random randomCityPrad = new Random();
                city = CitiesListPrad.get(randomCityPrad.nextInt(CitiesListPrad.size()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
        return city;
    }

    public static String getRandomMonthsOfBirth() {
        List<months> monthsList = Arrays.asList(months.values());
        Random randomMonths = new Random();
        return String.valueOf(monthsList.get(randomMonths.nextInt(monthsList.size())));
    }

    public static String getRandomBirthdayDay(String value) {
        Random randomDay = new Random();
        int monthNumberOfBirth = Arrays.asList(months.values()).indexOf(value);
        int day = 1 + randomDay.nextInt(31);

        if (monthNumberOfBirth == 2 && day > 28) {
            day = day - 3;
        } else {
            if ((monthNumberOfBirth % 2 == 0 && monthNumberOfBirth != 8) && day == 31) {
                day = day - 1;
            }
        }
        return String.valueOf(day);
    }
}
