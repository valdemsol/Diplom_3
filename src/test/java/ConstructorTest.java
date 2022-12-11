import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_objects.MainPage;

public class ConstructorTest extends CoreTest {

    MainPage mainPage;

    @Before
    public void start() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void switchToBunsTabTest() {
        //Сначала выбор другого раздела т.к. изначально "Булки" выбраны сразу при загрузке страницы
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        Assert.assertEquals("Булки", mainPage.getCurrentTabText());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void switchToSaucesTabTest() {
        mainPage.clickSaucesTab();
        Assert.assertEquals("Соусы", mainPage.getCurrentTabText());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void switchToToppingsTabTest() {
        mainPage.clickToppingsTab();
        Assert.assertEquals("Начинки", mainPage.getCurrentTabText());
    }
}
