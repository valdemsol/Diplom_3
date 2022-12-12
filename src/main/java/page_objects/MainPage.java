package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends CorePage {

    //Кнопка Войти в аккаунт
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement signInButton;

    //Кнопка Оформить заказ
    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement getOrderButton;

    // Личный кабинет
    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement personalAccount;

    //Текущий раздел
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private WebElement currentTab;

    //Раздел Булки
    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunsTab;

    //Раздел Соусы
    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement saucesTab;

    //Раздел Начинки
    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement toppingTab;

    public MainPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl;
    }

    //Шаги
    @Step("Клик на кнопку Войти в аккаунт")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccount() {
        personalAccount.click();
    }

    @Step("Получить название активного раздела ингредиентов")
    public String getCurrentTabText() {
        return currentTab.getText();
    }

    @Step("Клик на раздел Булки")
    public void clickBunsTab() {
        bunsTab.click();
    }

    @Step("Клик на раздел Соусы")
    public void clickSaucesTab() {
        saucesTab.click();
    }

    @Step("Клик на раздел Начинки")
    public void clickToppingsTab() {
        toppingTab.click();
    }

    @Step("Проверка, что кнопка Оформить заказ отображается")
    public boolean isDisplayedGetOrderButton() {
        return getOrderButton.isDisplayed();
    }

    //Ожидания
    public void waitForSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signInButton));
    }

    public void waitForOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(getOrderButton));
    }
}
