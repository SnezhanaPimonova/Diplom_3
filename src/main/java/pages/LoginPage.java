package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registrationButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    private final By forgotPasswordButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Восстановить пароль')]");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля email")
    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на ссылку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на ссылку Восстановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Заполнение полей ввода на странице входа и нажатие кнопки Войти")
    public void loginUserAccount(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    @Step("Получить текст кнопки Войти")
    public String getLoginButtonText() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).getText();
    }

}
