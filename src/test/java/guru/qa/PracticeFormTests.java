package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configBeforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegForm() {

        /* Тестовые данные для формы */
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "exp@mail.ru";
        String gender = "Male";
        String mobilePhone = "7071234567";
        String dateOfBirth = "01";
        String monthOfBirth = "January";
        String yearOfBirth = "1991";
        String subjects = "Computer Science";
        String hobbies1 = "Sports";
        String hobbies2 = "Reading";
        String picturePath = "src/test/resources/toolsqa.jpg";
        String pictureName = "toolsqa.jpg";
        String address = "Test Current Address";
        String state = "Haryana";
        String city = "Karnal";

        // Открываем браузер по ссылке
        open("https://demoqa.com/automation-practice-form");

        // Заполняем поле First Name
        $("#firstName").setValue(firstName);

        // Заполняем поле Last Name
        $("#lastName").setValue(lastName);

        // Заполняем поле Email
        $("#userEmail").setValue(email);

        // Выбор Gender
        $$("#genterWrapper label").findBy(text(gender)).click();

        // Заполняем поле Mobile
        $("#userNumber").setValue(mobilePhone);

        // Заполняем поле Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dateOfBirth).click();

        // Заполняем поле Subjects
        $("#subjectsInput").scrollTo().click();
        $("#subjectsInput").sendKeys(subjects);
        $("#subjectsInput").pressEnter();

        // Выбор Hobbies
        $$("#hobbiesWrapper label").findBy(text(hobbies1)).click();
        $$("#hobbiesWrapper label").findBy(text(hobbies2)).click();

        // Загрузка Picture
        $("#uploadPicture").uploadFile(new File(picturePath));

        // Заполняем Current Address
        $("#currentAddress").setValue(address);

        // Выбор State
        $("#state").click();
        $("#react-select-3-input").sendKeys(state);
        $("#react-select-3-input").pressEnter();
        // Выбор City
        $("#city").click();
        $("#react-select-4-input").sendKeys(city);
        $("#react-select-4-input").pressEnter();

        // Нажатие кнопки Submit
        $("#submit").click();

        // Модальное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        /* Проверка данные */
        $(byXpath("//td[text()='Student Name']/following-sibling::td")).shouldHave(text(firstName + " " + lastName));
        $(byXpath("//td[text()='Student Email']/following-sibling::td")).shouldHave(text(email));
        $(byXpath("//td[text()='Gender']/following-sibling::td")).shouldHave(text(gender));
        $(byXpath("//td[text()='Mobile']/following-sibling::td")).shouldHave(text(mobilePhone));
        $(byXpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text(dateOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(byXpath("//td[text()='Subjects']/following-sibling::td")).shouldHave(text(subjects));
        $(byXpath("//td[text()='Hobbies']/following-sibling::td")).shouldHave(text(hobbies1 + ", " + hobbies2));
        $(byXpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text(pictureName));
        $(byXpath("//td[text()='Address']/following-sibling::td")).shouldHave(text(address));
        $(byXpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text(state + " " + city));

    }
}
