package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDescriptionPage extends BaseView {
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/p[contains(.,'В Корзину')]")
    WebElement addShoppingСartButton;

    @Step("Нажать на кнопку 'В корзину'")
    public ShoppingСartPage addShoppingСartButtonClick() {
        addShoppingСartButton.click();
        return new ShoppingСartPage(driver);
    }
}




