import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_objects.LoginPage;
import page_objects.RegistrationPage;

public class RegistrationTest extends CoreTest {

    RegistrationPage registrationPage;

    private final String name = "Valdo";
    private String email, password;

    @Before
    public void start() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());
        registrationPage.waitForSignUpButton();

        email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
    }

    @Test
    @DisplayName("Успешно создание пользователя")
    public void createUserSuccessfullyTest() {
        password = RandomStringUtils.randomAlphanumeric(10);

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();

        Assert.assertEquals(loginPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка ошибки поля Пароль при создании пользователя")
    public void createUserWithIncorrectPasswordTest() {
        //Минимальный пароль — шесть символов
        password = "8765";

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();

        registrationPage.waitForIncorrectPasswordError();
        Assert.assertEquals("Некорректный пароль", registrationPage.getIncorrectPasswordErrorText());
    }
}
