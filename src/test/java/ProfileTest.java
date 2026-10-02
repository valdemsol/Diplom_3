import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_objects.LoginPage;
import page_objects.MainPage;
import page_objects.ProfilePage;

public class ProfileTest extends CoreTest {

    LoginPage loginPage;
    MainPage mainPage;
    ProfilePage profilePage;

    @Before
    public void start() {
        //Логин в приложении
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        driver.get(loginPage.getCurrentUrl());
        loginPage.waitForSignInButton();

        //Ввод данных
        loginPage.fillEmailAndPassword(super.email, super.password);
        loginPage.clickSignInButton();

        //Переход на главную страницу
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();

        //Переход в профиль с главной страницы
        mainPage.clickPersonalAccount();
        profilePage = new ProfilePage(driver);
        PageFactory.initElements(driver, profilePage);
        profilePage.waitForProfileLink();
    }

    @Test
    @DisplayName("Переход в ЛК c Главной страницы")
    public void clickPersonalAccountButtonToProfilePageTest() {
        Assert.assertEquals(profilePage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор на главной странице")
    public void clickConstructorRedirectedToMainPageTest() {
        profilePage.clickConstructor();
        mainPage.waitForOrderButton();
        Assert.assertEquals(mainPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из ЛК на главную страницу по клику на Лого Stellarburgers")
    public void clickLogoRedirectedToMainPageTest() {
        profilePage.clickStellarburgersLogo();
        mainPage.waitForOrderButton();
        Assert.assertEquals(mainPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из профиля по кнопке «Выйти» в личном кабинете")
    public void clickLogOutButtonLogOutTest() {
        profilePage.clickLogOutButton();
        loginPage.waitForSignInButton();
        Assert.assertEquals(loginPage.getCurrentUrl(), driver.getCurrentUrl());
    }
}
