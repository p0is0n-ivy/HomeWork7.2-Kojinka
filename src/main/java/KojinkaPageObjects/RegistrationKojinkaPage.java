package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationKojinkaPage extends BaseView {
    public RegistrationKojinkaPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//li[contains(.,'Регистрация')]")
    private WebElement registrationButton;


    @FindBy(name = "register[email]")
    private WebElement emailField;

    @Step("Ввод данных в поле email ")
    public RegistrationKojinkaPage emailFieldInput(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @FindBy(name = "register[firstname]")
    private WebElement firstnameField;

    @Step("Ввод данных в поле firstname")
    public RegistrationKojinkaPage firstnameFieldInput(String firstname) {
        firstnameField.sendKeys(firstname);
        return this;
    }

    private WebElement telephoneField;

    @Step("Ввод данных в поле telephone")
    public RegistrationKojinkaPage telephoneFieldInput(String telephone) {
        telephoneField.sendKeys(telephone);
        return this;
    }

    @FindBy(name = "register[password]")
    private WebElement passwordField;

    @Step("Ввод данных в поле password")
    public RegistrationKojinkaPage passwordFieldInput(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @FindBy(name = "register[confirm_password]")
    private WebElement confirmPasswordField;

    @Step("Ввод данных в поле confirm password")
    public RegistrationKojinkaPage confirmPasswordFieldInput(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }

    @FindBy(xpath = "//a[contains(.,'Продолжить')]")
    private WebElement continueButton;

    @Step("Нажать на кнопку 'Продолжить'")
    public SuccessfulRegistrationPage clickRegistrationButton() {
        continueButton.click();
        return new SuccessfulRegistrationPage(driver);
    }
}
