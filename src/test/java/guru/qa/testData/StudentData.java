package guru.qa.testData;

import com.github.javafaker.Faker;

public class StudentData {

    Faker faker = new Faker();

    /* Тестовые данные для формы */
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobilePhone = faker.phoneNumber().subscriberNumber(10),
            dateOfBirth = "01",
            monthOfBirth = "January",
            yearOfBirth = "1991",
            subjects = "Computer Science",
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            pictureName = "toolsqa.jpg",
            address = faker.address().streetAddress(),
            state = "Haryana",
            city = "Karnal";
}
