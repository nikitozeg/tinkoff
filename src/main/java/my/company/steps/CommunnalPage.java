package my.company.steps;

import my.company.steps.helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static my.company.steps.helpers.Locators.*;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class CommunnalPage {

    private WebDriver driver;

    CommunnalPage(WebDriver driver) {
        this.driver = driver;
        Common.checkValues(COMMUN_GRID_LOCATOR, driver);
    }

    private By locationLocator = By.xpath(LOCATION_LOCATOR);

    @Step
    public void setLocation(String location) {
        changeLocationTo(location);
    }

    @Step
    public void checkProviderIsAbsent(String location) {
        List<WebElement> communalProvidersList = driver.findElements(By.xpath(COMMUNAL_PROVIDERS_LOCATOR));
        for (WebElement el : communalProvidersList) {
            assert !el.getText().equalsIgnoreCase(location) : "Item " + location + " is found on the page";
        }
    }

    @Step
    public ZhkuMskPage clickOnGridElement(int num) {
        getListElement().get(num).click();
        return new ZhkuMskPage(driver);
    }

    @Step
    private List<WebElement> getListElement() {
        return driver.findElements(By.xpath(COMMUN_GRID_LOCATOR));
    }

    @Step
    public WebElement getElement(int i) {
        return getListElement().get(i).findElement(By.xpath(".//span[text()]"));
    }

    @Step
    private CommunnalPage changeLocationTo(String name) {
        Common.clickOnElement(locationLocator, driver);
        Common.clickOnElement(By.xpath("//span[text()=\"" + name + "\"]"), driver);
        Common.checkValues(COMMUN_GRID_LOCATOR, driver);
        return this;
    }
}
