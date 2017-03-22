package my.company.steps;

import my.company.steps.helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static my.company.steps.helpers.Locators.PAYMENTS_LOCATOR;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class LandingPage {

    private WebDriver driver;
    static String currentURL1;
    private By paymentsBtn = By.xpath(PAYMENTS_LOCATOR);

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    private void userClicksOnPaymentLink() {
        Common.clickOnElement(paymentsBtn, driver);
    }

    @Step
    public PaymentsPage goToPaymentsPage() {
        userClicksOnPaymentLink();
        return new PaymentsPage(driver);
    }
}
