package KojinkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogBlock extends BaseView {
    public CatalogBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/p[contains(., 'Каталог')]")
    private WebElement catalogButton;

    @Step("Нажать на кнопку 'Каталог'")
    public CatalogBlock catalogButtonClick() {
        catalogButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@class='open-pod-menu']/h2[contains(.,'Рюкзаки')]")
    private WebElement backpacksSection;

    @Step("Выбрать пункт 'Рюкзаки'")
    public BackpacksPage backpacksClick() {
        backpacksSection.click();
        return new BackpacksPage(driver);
    }
}


