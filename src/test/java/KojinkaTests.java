import KojinkaPageObjects.*;
import KojinkaPageObjects.CustomLoggerNew.CustomLoggerNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;


public class KojinkaTests {
    WebDriver driver;
    MainPageObject mainPageObject;
    private final static String KOJINKA_BASE_URL = "https://kojinka.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        mainPageObject = new MainPageObject(driver);
        driver.get(KOJINKA_BASE_URL);
    }

    @Test
    @Description("Позитивный тест регистрации")
    @TmsLink("23321")
    @Issue("Спецификация от 12.02.2022 пункт 3.5")
    @Story("Основной функционал/ дымовое тестирование")
    void PositiveRegistrationTest() {
        driver.manage().window().setSize(new Dimension(1800, 1000));
        new MainPageObject(driver).clickRegistrationButton();
        new RegistrationKojinkaPage(driver)
                .emailFieldInput("irinas555@mail.ru")
                .firstnameFieldInput("Ирина")
                .telephoneFieldInput("8-926-27-55-30")
                .passwordFieldInput("qwe123")
                .confirmPasswordFieldInput("qwe123")
                .clickRegistrationButton();
        new SuccessfulRegistrationPage(driver).waitSuccessfulRegistrationMessage();
    }

    @Test
    @Description("Добавление конкретного продукта в корзину")
    @TmsLink("23321")
    @Issue("Чек-лист №35")
    @Story("Основной функционал/ дымовое тестирование")
    void addSpecificProduct() {
        new MainPageObject(driver)
                .clickLoginButton()
                .loginInput("irinasiv8@mail.ru")
                .passwordInput("qwe12345")
                .clickLoginButton();
        new PersonalAccountPage(driver);
        new CatalogBlock(driver)
                .catalogButtonClick()
                .backpacksClick()
                .findBackpackByNameClick()
                .addShoppingСartButtonClick()
                .AsserThatProductInTheShoppingСartButton();
    }

    @AfterEach
    void tearDown() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logs.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }
        driver.quit();
    }
}
