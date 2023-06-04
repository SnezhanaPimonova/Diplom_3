package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final By singInButton = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти")
    public void clickSingInButton() {
        driver.findElement(singInButton).click();
    }
}
