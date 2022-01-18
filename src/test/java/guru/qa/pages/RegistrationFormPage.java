package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.testData.StudentData;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormPage {

    private final String MODAL_TITLE = "Thanks for submitting the form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobilePhoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressTextarea = $("#currentAddress"),
            stateElem = $("#state"),
            stateInput = $("#react-select-3-input"),
            cityElem = $("#city"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg");

    private ElementsCollection
            genderRadio = $$("#genterWrapper label"),
            hobbiesCheckBox = $$("#hobbiesWrapper label"),
            tableLines = $$(".table-responsive tbody tr");

    public RegistrationFormPage openPage() {
        // Открываем браузер по ссылке
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationFormPage typeFirstName(String firstName) {
        // Заполняем поле First Name
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage typeLastName(String lastName) {
        // Заполняем поле Last Name
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage typeEmail(String email) {
        // Заполняем поле Email
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage chooseGender(String gender) {
        // Выбор Gender
        genderRadio.findBy(text(gender)).click();
        return this;
    }

    public RegistrationFormPage typeMobilePhone(String mobilePhone) {
        // Заполняем поле Mobile
        mobilePhoneInput.setValue(mobilePhone);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String dateOfBirth, String monthOfBirth, String yearOfBirth) {
        // Заполняем поле Date of Birth
        dateOfBirthInput.click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dateOfBirth).click();
        return this;
    }

    public RegistrationFormPage typeSubjects(String subjects) {
        // Заполняем поле Subjects
        subjectsInput.scrollTo().click();
        subjectsInput.sendKeys(subjects);
        subjectsInput.pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobbies(String hobbies) {
        // Выбор Hobbies
        hobbiesCheckBox.findBy(text(hobbies)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String pictureName) {
        // Загрузка Picture
        uploadPictureButton.uploadFile(new File("src/test/resources/img/" + pictureName));
        return this;
    }

    public RegistrationFormPage typeCurrentAddress(String address) {
        // Заполняем Current Address
        currentAddressTextarea.setValue(address);
        return this;
    }

    public RegistrationFormPage selectState(String state) {
        // Выбор State
        stateElem.click();
        stateInput.sendKeys(state);
        stateInput.pressEnter();
        return this;
    }

    public RegistrationFormPage selectCity(String city) {
        // Выбор City
        cityElem.click();
        cityInput.sendKeys(city);
        cityInput.pressEnter();
        return this;
    }

    public RegistrationFormPage submitForm() {
        // Нажатие кнопки Submit
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkResultsTitle() {
        // Модальное окно
        modalTitle.shouldHave(text(MODAL_TITLE));
        return this;
    }

    // проверка с коллекции
    private Map<String, String> expectedStudentData = new HashMap<String, String>() {{
        put("Student Name", StudentData.firstName + " " + StudentData.lastName);
        put("Student Email", StudentData.email);
        put("Gender", StudentData.gender);
        put("Mobile", StudentData.mobilePhone);
        put("Date of Birth", StudentData.dateOfBirth + " " + StudentData.monthOfBirth + "," + StudentData.yearOfBirth);
        put("Subjects", StudentData.subjects);
        put("Hobbies", StudentData.hobbies1 + ", " + StudentData.hobbies2);
        put("Picture", StudentData.pictureName);
        put("Address", StudentData.address);
        put("State and City", StudentData.state + " " + StudentData.city);
    }};

    public RegistrationFormPage checkResultsValue() {
        // Проверка данные
        tableLines.snapshot();
        for (SelenideElement tableLine : tableLines) {
            String key = tableLine.$("td").text();
            String expectedValue = expectedStudentData.get(key);
            String actualValue = tableLine.$("td", 1).text();
            assertEquals(expectedValue, actualValue, "Student test data is not equal");
        }
        return this;
    }
}
