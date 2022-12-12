import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoreTest {

    WebDriver driver;

    //Данные
    protected final String email = "diplom3test@gmail.com";
    protected final String password = "1234567890pass";

    @Before
    public void setup() {

        //Переключение на Хром
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

       /*   //Переключение на Яндекс.Браузер
        ChromeOptions options = new ChromeOptions();System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\valde\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);*/
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
