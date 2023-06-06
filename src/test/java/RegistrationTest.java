import io.qameta.allure.junit4.DisplayName;
import user.UserGenerator;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void createNewUserTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterRegistrationData(user.getName(), user.getEmail(), user.getPassword());
        String actual = loginPage.getLoginButtonText();
        Assert.assertEquals("Войти", actual);
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    public void createNewUserWithShortPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = new UserGenerator().getRandomUserWithIncorrectPassword();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterRegistrationData(user.getName(), user.getEmail(), user.getPassword());
        String actual = registrationPage.getTextAboutShortPassword();
        Assert.assertEquals("Некорректный пароль", actual);

    }

}

