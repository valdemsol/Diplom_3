package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorePage {

    WebDriver driver;

    protected static final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    protected String currentUrl;

    public static final String LOGIN = "login";
    public static final String FORGOT_PASSWORD = "forgot-password";
    public static final String PROFILE = "account/profile";
    public static final String REGISTER = "register";

    public CorePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    //Логотип StellarBurgers
    @FindBy(xpath = ".//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement stellarburgersLogo;

    //ссылка Войти (Вспомнили пароль? / Уже зарегистрированы?)
    @FindBy(xpath = ".//a[text() = 'Войти']")
    private WebElement signInLink;

    @Step("Клик на логотип StellarBurgers")
    public void clickStellarburgersLogo() {
        stellarburgersLogo.click();
    }

    @Step("Нажать на ссылку Войти")
    public void clickSignInLink() {
        signInLink.click();
    }
}
