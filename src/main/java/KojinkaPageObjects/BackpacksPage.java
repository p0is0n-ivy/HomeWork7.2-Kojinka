package KojinkaPageObjects;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BackpacksPage extends BaseView {
    public BackpacksPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class = 'a-category-kojinka-item']")
    private List<WebElement> backpacksList;

    @Step("Найти рюкзак по названию")
    public ProductDescriptionPage findBackpackByNameClick() {
        backpacksList.stream().filter(p -> p.getText().contains("Кожаный рюкзак \"Вена\" (коричневый антик)")).findFirst().get().click();
        return new ProductDescriptionPage(driver);
    }

}
