import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class LogOutTest extends BaseTest {

    @Test
    @DisplayName("Выход из профиля через кнопку 'Выход' в личном кабинете")
    public void logOutTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        userSteps.createUser(user);
        mainPage.clickLoginButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.clickSignOutButton();
        String actual = loginPage.getLoginButtonText();
        Assert.assertEquals("Войти", actual);
    }
}