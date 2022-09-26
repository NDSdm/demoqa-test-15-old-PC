package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

public class RegistationFormTest {
    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1720x1440";
        Configuration.holdBrowserOpen = true;
    }

    String name = "Dmitriy";
    String surname = "Ivanov";
    String email = "test@test.test";
    String number = "1234567890";
    String address = "test test index:123";

    @Test
    void formTest() {
        registrationForm.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender("Male")
                .setNumber(number).setBirthDate("08", "August", "1998")
                .setSubject("English")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setPicture("img/1.png")
                .setAddress(address)
                .setLocation("NCR", "Delhi")
                .clickSubmit();

        registrationForm.checkResult("Student Name", (name + " " + surname))
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", "08 August,1998")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "1.png")
                .checkResult("Address", address)
                .checkResult("State and City", "NCR Delhi");
    }
}
