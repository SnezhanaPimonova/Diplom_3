package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By signOutButton = By.xpath(".//button[text()='Выход']");
    private final By profileButton = By.xpath(".//a[text()='Профиль']");

    private final WebDriver driver;

    public ProfilePage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("Нажатие на ссылку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие на ссылку логотип")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Нажатие на кнопку Выход")
    public void clickSignOutButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(signOutButton).click();
    }

    @Step("Получить текст кнопки Профиль")
    public String getTextProfileButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        return driver.findElement(profileButton).getText();
    }
}
