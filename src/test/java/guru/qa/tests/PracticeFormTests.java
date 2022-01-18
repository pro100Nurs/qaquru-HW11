package guru.qa.tests;

import guru.qa.pages.RegistrationFormPage;
import guru.qa.testData.StudentData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("pro100Nurs")
@Tag("practiceFormTest")
public class PracticeFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Fill student registration form")
    void fillStudentRegForm() {
        step("Open students registration form", () -> {
            registrationFormPage
                    .openPage();
        });

        step("Fill the Practice form", () -> {
            step("Input first name, last name, email, gender and phone number", () -> {
                registrationFormPage
                        .typeFirstName(StudentData.firstName)
                        .typeLastName(StudentData.lastName)
                        .typeEmail(StudentData.email)
                        .chooseGender(StudentData.gender)
                        .typeMobilePhone(StudentData.mobilePhone);
            });
            step("Set date", () -> {
                registrationFormPage
                        .setDateOfBirth(StudentData.dateOfBirth, StudentData.monthOfBirth, StudentData.yearOfBirth);
            });
            step("Set subjects", () -> {
                registrationFormPage
                        .typeSubjects(StudentData.subjects);
            });
            step("Set hobbies", () -> {
                registrationFormPage
                        .chooseHobbies(StudentData.hobbies1)
                        .chooseHobbies(StudentData.hobbies2);
            });
            step("Upload image", () -> {
                registrationFormPage
                        .uploadPicture(StudentData.pictureName);
            });
            step("Set address", () -> {
                registrationFormPage
                        .typeCurrentAddress(StudentData.address)
                        .selectState(StudentData.state)
                        .selectCity(StudentData.city);
            });
            step("Submit form", () -> {
                registrationFormPage
                        .submitForm();
            });
        });

        step("Verify successful form submit", () -> {
            registrationFormPage
                    .checkResultsTitle()
                    .checkResultsValue();
        });
    }
}
