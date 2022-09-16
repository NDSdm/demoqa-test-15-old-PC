package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationPracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1720x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Dmitriy";
        String lastName = "Ivanov";
        String userEmail = "test@test.test";
        String userNumber = "1234567890";
        String dateOfBirthInput = "08.08.88";
        String currentAddress = "test test index:123";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#currentAddress").setValue(currentAddress);
        $("#gender-radio-1").doubleClick();


        $("#output #firstName").shouldHave(text(firstName));
        $("#output #lastName").shouldHave(text(lastName));
        $("#output #userEmail").shouldHave(text(userEmail));
        $("#output #userNumber").shouldHave(text(userNumber));
        $("#output #dateOfBirthInput").shouldHave(text(dateOfBirthInput));
        $("#output #currentAddress").shouldHave(text(currentAddress));
    }
}
