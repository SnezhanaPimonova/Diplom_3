import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class GoToProfileTest extends TestBase {
    @Test
    @DisplayName("Переход в личный кабинет по клику на Личный кабинет для неавторизованного пользователя")
    public void goToProfileWithoutAuthTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickPersonalAccountButton();
        String actual = loginPage.getLoginButtonText();
        Assert.assertEquals("Войти", actual);
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на Личный кабинет для авторизованного пользователя")
    public void goToProfileWithAuthTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        String actual = profilePage.getTextProfileButton();
        Assert.assertEquals("Профиль", actual);
    }
}