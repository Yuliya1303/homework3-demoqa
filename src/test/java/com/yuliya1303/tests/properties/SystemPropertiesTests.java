package com.yuliya1303.tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void someTest5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1080");
    }
}
