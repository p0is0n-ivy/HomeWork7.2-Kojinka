package KojinkaPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class SuccessfulRegistrationPage extends BaseView {
    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final static String elementSuccessfulRegistrationMessageByXpath = "//h1[contains(.,'Ваша учётная запись создана!')]";
    @FindBy(xpath = elementSuccessfulRegistrationMessageByXpath)
    private WebElement elementSuccessfulRegistrationMessage;


    public SuccessfulRegistrationPage waitSuccessfulRegistrationMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementSuccessfulRegistrationMessageByXpath)));
        assertThat(elementSuccessfulRegistrationMessage, isDisplayed());
        return this;
    }
}
