import org.junit.Assert;
import org.junit.Test;
import pages.*;
import io.qameta.allure.junit4.DisplayName;

public class LogInTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной странице")
    public void loginWithButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps.createUser(user);
        mainPage.clickLoginButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        String actual = mainPage.getTextCreateOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginWithPersonalAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        String actual = mainPage.getTextCreateOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти' в форме регистрации")
    public void loginWithButtonOnRegistrationPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickSignInButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        String actual = mainPage.getTextCreateOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти' в форме восстановления пароля")
    public void loginWithButtonOnForgotPasswordPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        userSteps.createUser(user);
        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickSingInButton();
        loginPage.loginUserAccount(user.getEmail(), user.getPassword());
        String actual = mainPage.getTextCreateOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }
}
