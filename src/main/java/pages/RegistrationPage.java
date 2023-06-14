package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final By userName = By.xpath(".//label[text()='Имя']/../input");
    private final By userEmail = By.xpath(".//label[text()='Email']/../input");
    private final By userPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final By errorAboutShortPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля Имя")
    public void setUserNameInput(String name) {
        driver.findElement(userName).sendKeys(name);
    }

    @Step("Заполнение поля email")
    public void setEmailInput(String email) {
        driver.findElement(userEmail).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void setPasswordInput(String password) {
        driver.findElement(userPassword).sendKeys(password);
    }

    @Step("Заполнение полей ввода на странице Регистрация и нажатие кнопки Зарегистрироваться")
    public void enterRegistrationData(String name, String email, String password) {
        setUserNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        clickRegisterButton();
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажатие на кнопку Войти")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Получить текст о некорректном пароле")
    public String getTextAboutShortPassword() {
        return driver.findElement(errorAboutShortPassword).getText();
    }

}
