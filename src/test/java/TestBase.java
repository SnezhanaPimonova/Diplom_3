import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import user.User;
import user.UserCredentials;
import steps.UserSteps;
import user.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    private final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public WebDriver driver;
    User user;
    UserSteps userSteps;
    private String accessToken;

    @Before
    public void setUp() {
        //хром браузер
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //  расскоментировать строки 29-30 для запуска тестов через Яндекс браузер и закомментировать строки с хром браузером
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        driver.get(MAIN_PAGE_URL);
        userSteps = new UserSteps();
        user = new UserGenerator().getRandomUser();
    }

    @After
    public void tearDown() {
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = UserSteps.loginUser(new UserCredentials(user.getEmail(), user.getPassword()));
            accessToken = responseLogin.extract().path("accessToken");
            if (accessToken == null) {
                return;
            }
            UserSteps.deleteUser(accessToken);
        }
    }
}
