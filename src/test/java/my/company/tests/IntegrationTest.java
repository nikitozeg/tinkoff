package my.company.tests;

import my.company.steps.*;
import my.company.steps.helpers.TestSettings;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static org.junit.Assert.assertEquals;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

@Title("Suite contain positive and negative cases")
@Description("In this suite we'll make integration test")

public class IntegrationTest extends TestSettings {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Valid email and password")
    @Test
    public void lookAndFeelTest() throws Exception {
        LandingPage header = new LandingPage(driver);
        PaymentsPage paymentsPage = header.goToPaymentsPage();
        CommunnalPage communalPayments = paymentsPage.goToCommunalPage();
        communalPayments.setLocation("г. Москва");
        assertEquals(communalPayments.getElement(0).getText(), "ЖКУ-Москва");
        ZhkuMskPage zhkuMsk = communalPayments.clickOnGridElement(0);
        zhkuMsk.checkCodeValidation();
        zhkuMsk.checkDateValidation();
        header.goToPaymentsPage();
        paymentsPage.userLookupItem("ЖКУ-Москва").lookupHasResult().checkFirstItem("ЖКУ-Москва").userClicksOnFoundItem(0);
        header.goToPaymentsPage();
        paymentsPage.goToCommunalPage();
        communalPayments.setLocation("г. Санкт-Петербург");
        communalPayments.checkProviderIsAbsent("ЖКУ-Москва");
    }


}

