package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement loginField;

    @Step("Ввод данных в поле email")
    public LoginPage loginInput (String email) {
        loginField.sendKeys(email);
        return this;
    }

    @FindBy(name = "password")
    private WebElement passwordField;

    @Step("Ввод данных в поле password")
    public LoginPage passwordInput (String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement entryButton;

    @Step("Нажать на кнопку 'Войти'")
    public PersonalAccountPage clickLoginButton() {
        entryButton.click();
        return new PersonalAccountPage(driver);
    }
}
