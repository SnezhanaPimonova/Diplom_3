import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends TestBase {
    @Test
    @DisplayName("Переход к разделу Булки")
    public void bunButtonClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        mainPage.clickBunButton();
        String actual = mainPage.getTextFromSelectedMenu();
        Assert.assertEquals("Булки", actual);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void saucesButtonClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        String actual = mainPage.getTextFromSelectedMenu();
        Assert.assertEquals("Соусы", actual);

    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void fillingsButtonClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        String actual = mainPage.getTextFromSelectedMenu();
        assertEquals("Начинки", actual);
    }
}
