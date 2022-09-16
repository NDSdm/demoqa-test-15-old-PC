package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationPracticeForm {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1720x1440";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Dmitriy");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.test");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("test test index:123");
        $("#gender-radio-1").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--008:not(.react-datepicker__day--selected").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();;
        $("#subjectsInput").setValue("English").pressEnter();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("uploadPicture").uploadFromClasspath("img/1.png");

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Dmitriy Ivanov"),
                text("test@test.test"),
                text("1234567890"),
                text("test test index:123"));
        $("#closeLargeModal").click();
    }
}
