package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunButton = By.xpath(".//span[text()='Булки']");
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    public final By headerText = By.xpath(".//*[text()='Соберите бургер']");
    public final By menuText = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на пункт меню Булки")
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step("Нажатие на пункт меню Соусы")
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("Нажатие на пункт меню Начинки")
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    @Step("Проверка текста текущего меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(menuText).getText();
    }

    @Step("Получить текст кнопки Оформить заказ")
    public String getTextCreateOrderButton() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Текст Соберите бургер отображается")
    public boolean waitingForMainPageLoading() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerText));
        return driver.findElement(headerText).isDisplayed();
    }

}
