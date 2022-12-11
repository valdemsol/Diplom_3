import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_objects.LoginPage;
import page_objects.MainPage;
import page_objects.PasswordRecoveryPage;
import page_objects.RegistrationPage;

public class LoginTest extends CoreTest {

    MainPage mainPage;
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;
    LoginPage loginPage;

    @After
    public void end() {
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();
        loginPage.fillEmailAndPassword(super.email, super.password);
        loginPage.clickSignInButton();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void clickLogInOnMainPageTest() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();

        mainPage.clickSignInButton();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void clickPersonalAccountButtonOnMainPageTest() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();

        mainPage.clickPersonalAccount();
    }

    @Test
    @DisplayName("Вход в приложение через кнопку на форме регистрации")
    public void clickSignInLinkOnRegistrationPageTest() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());
        registrationPage.waitForSignUpButton();
        registrationPage.clickSignInLink();
    }

    @Test
    @DisplayName("Вход через кнопку Войти в форме восстановления пароля")
    public void clickSignInLinkOnPasswordRecoveryPageTest() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        PageFactory.initElements(driver, passwordRecoveryPage);
        driver.get(passwordRecoveryPage.getCurrentUrl());
        passwordRecoveryPage.waitForRestorePasswordButton();
        passwordRecoveryPage.clickSignInLink();
    }
}
