import io.qameta.allure.junit4.DisplayName;

import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.junit.Assert.assertTrue;

public class GoToConstructorTest extends TestBase {

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по клику на Конструктор")
    public void goToConstructorTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        boolean result = mainPage.waitingForMainPageLoading();
        assertTrue(result);
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по клику на логотип")
    public void goToConstructorWithLogoTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogoButton();
        boolean result = mainPage.waitingForMainPageLoading();
        assertTrue(result);
    }
}
