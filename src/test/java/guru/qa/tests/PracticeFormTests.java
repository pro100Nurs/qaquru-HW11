package guru.qa.tests;

import guru.qa.pages.RegistrationFormPage;
import guru.qa.testData.StudentData;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    StudentData studentData = new StudentData();

    @Test
    void fillStudentRegForm() {

        registrationFormPage
                .openPage()
                .typeFirstName(studentData.firstName)
                .typeLastName(studentData.lastName)
                .typeEmail(studentData.email)
                .chooseGender(studentData.gender)
                .typeMobilePhone(studentData.mobilePhone)
                .setDateOfBirth(studentData.dateOfBirth, studentData.monthOfBirth, studentData.yearOfBirth)
                .typeSubjects(studentData.subjects)
                .chooseHobbies(studentData.hobbies1)
                .chooseHobbies(studentData.hobbies2)
                .uploadPicture(studentData.pictureName)
                .typeCurrentAddress(studentData.address)
                .selectState(studentData.state)
                .selectCity(studentData.city)
                .submitForm();

        registrationFormPage
                .checkResultsTitle()
                // с коллекции
                .checkResultsValue();
                /* без колекции
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
                */
    }
}
