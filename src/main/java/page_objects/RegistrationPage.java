package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends CorePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + REGISTER;
    }

    //Поле Имя
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInput;

    //Поле Email
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInput;

    //Поле Пароль
    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInput;

    //Кнопка Зарегистрироваться
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement signUpButton;

    //Ошибка Некорректный пароль
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordError;

    //Шаги
    @Step("Ввести имя")
    public void fillNameInput(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Ввести Email")
    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввести пароль")
    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Заполнить все поля")
    public void fillAllTheFields(String name, String email, String password) {
        this.fillNameInput(name);
        this.fillEmailInput(email);
        this.fillPasswordInput(password);
    }

    @Step("клик на кнопку Зарегистрироваться")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Получить текст ошибки Некорректный пароль")
    public String getIncorrectPasswordErrorText() {
        return incorrectPasswordError.getText();
    }

    //Ожидания
    public void waitForSignUpButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signUpButton));
    }

    public void waitForIncorrectPasswordError() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(incorrectPasswordError));
    }
}
