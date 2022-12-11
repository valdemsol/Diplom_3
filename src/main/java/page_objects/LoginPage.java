package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CorePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + LOGIN;
    }

    //Поле Email
    @FindBy(xpath = ".//input[@name = 'name']")
    private WebElement emailInput;

    //Поле Password
    @FindBy(xpath = ".//input[@type = 'password']")
    private WebElement passwordInput;

    //Кнопка Войти
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement signInButton;

    //Шаги
    @Step("Ввести почту")
    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввести пароль")
    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Ввести почту и пароль")
    public void fillEmailAndPassword(String email, String password) {
        this.fillEmailInput(email);
        this.fillPasswordInput(password);
    }

    @Step("Клик на кнопку Войти")
    public void clickSignInButton() {
        signInButton.click();
    }

    //Ожидания
    public void waitForSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signInButton));
    }
}
