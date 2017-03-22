package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static my.company.steps.helpers.Common.waitXpathElementVisible;
import static my.company.steps.helpers.Locators.*;
import static my.company.steps.helpers.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class ZhkuMskPage {
    static String currentURL;
    private WebDriver driver;

    ZhkuMskPage(WebDriver driver) {
        this.driver = driver;
        waitXpathElementVisible(PAYERCODE_LOCATOR,driver);
    }

    @Step
    public void checkCodeValidation() {

        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(ENTER);
        assertEquals(mandatoryFieldMessage,driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());

        for (String value: payerCodeTestData) {
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).clear();
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(value);
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(ENTER);
            assertEquals(incorrectFieldMessage,driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());

        }
        currentURL = driver.getCurrentUrl();
    }

    @Step
    public void checkDateValidation() {
        //fill payerCode (to hide validation messages on PayerCode field)
        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).clear();
        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys("1234567890");

        for (String value:periodCodeTestData) {
            driver.findElement(By.xpath(PERIOD_LOCATOR)).clear();
            driver.findElement(By.xpath(PERIOD_LOCATOR)).sendKeys(value);
            driver.findElement(By.xpath(PERIOD_LOCATOR)).sendKeys(ENTER);
            assertEquals(incorrectField1Message,driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());
        }
    }
}
