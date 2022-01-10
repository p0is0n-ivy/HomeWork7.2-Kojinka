package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    public class MainPageObject extends BaseView {
        @FindBy(xpath = "//li[.='Регистрация']")
        WebElement registrationButton;

        @Step("Нажать на кнопку 'Регистрация'")
        public RegistrationKojinkaPage clickRegistrationButton() {
            registrationButton.click();
            return new RegistrationKojinkaPage(driver);
        }
        @FindBy(xpath = "//li[contains(.,'ВОЙТИ')]")
        private WebElement loginButton;

        @Step("Нажать на кнопку 'Войти'")
        public LoginPage clickLoginButton() {
            loginButton.click();
            return new LoginPage(driver);
        }

        public MainPageObject(WebDriver driver) {
            super(driver);
        }
    }

