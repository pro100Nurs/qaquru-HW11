package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    Faker faker = new Faker();

    @Test
    void fillStudentRegForm() {

        /* Тестовые данные для формы */
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String mobilePhone = faker.phoneNumber().subscriberNumber(10);
        String dateOfBirth = "01";
        String monthOfBirth = "January";
        String yearOfBirth = "1991";
        String subjects = "Computer Science";
        String hobbies1 = "Sports";
        String hobbies2 = "Reading";
        String pictureName = "toolsqa.jpg";
        String address = faker.address().streetAddress();
        String state = "Haryana";
        String city = "Karnal";

        registrationFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender(gender)
                .typeMobilePhone(mobilePhone)
                .setDateOfBirth(dateOfBirth, monthOfBirth, yearOfBirth)
                .typeSubjects(subjects)
                .chooseHobbies(hobbies1)
                .chooseHobbies(hobbies2)
                .uploadPicture(pictureName)
                .typeCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        registrationFormPage
                .checkResultsTitle()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", mobilePhone)
                .checkResultsValue("Date of Birth", dateOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResultsValue("Subjects", subjects)
                .checkResultsValue("Hobbies", hobbies1 + ", " + hobbies2)
                .checkResultsValue("Picture", pictureName)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + " " + city);
    }
}
