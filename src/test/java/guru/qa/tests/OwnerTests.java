package guru.qa.tests;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Test
    @DisplayName("Read credentials.properties file")
    void readCredentialsTest() {
        step("Read and print console credentials.properties file", () -> {
            String login = credentials.login();
            String password = credentials.password();
            String message = format("https://%s:%s@65.108.161.82:4444/wd/hub/", login, password);

            System.out.println("Login: " + login);
            System.out.println("Password: " + password);
            System.out.println("Remote web driver url: " + message);
        });
    }
}
