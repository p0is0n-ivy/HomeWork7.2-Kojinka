package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class  ShoppingСartPage extends BaseView {
    public ShoppingСartPage(WebDriver driver) {
        super(driver);
    }
    private final static String elementLocatorContainsProductName = "//a[contains(.,'Кожаный рюкзак \"Вена\" (коричневый антик)')]";
    @FindBy(xpath = elementLocatorContainsProductName)
    WebElement productAddedShoppingСartButton;

    @Step("Проверка добавления товара в корзину")
    public ShoppingСartPage AsserThatProductInTheShoppingСartButton () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocatorContainsProductName)));
        assertThat(productAddedShoppingСartButton, isDisplayed());
        assertThat(driver.getCurrentUrl(), containsString("route=checkout/simplecheckout"));
        return this;
        }
}


