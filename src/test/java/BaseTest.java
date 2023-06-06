import io.restassured.response.ValidatableResponse;
import user.User;
import user.UserCredentials;
import steps.UserSteps;
import user.UserGenerator;
import constants.Constants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver driver;
    User user;
    UserSteps userSteps;
    private String accessToken;

    @Before
    public void setUp() {
        driver = BrowserFactory.getDriver(Constants.CHROME_BROWSER);
        driver.get(Constants.MAIN_PAGE_URL);
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
