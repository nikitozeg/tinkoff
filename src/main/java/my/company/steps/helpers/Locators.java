package my.company.steps.helpers;

public class Locators {
    public static String PAYMENTS_LOCATOR = "//span[text()=\"Платежи\"]";

    public static String FIELD_PAYER_CODE_LOCATOR = "//input[@name='fieldpayerCode']";
    public static String LOOKUP_RESULTS_LOCATOR = "//div[@class=\"ui-search-flat__title-box\"]";
    public static String COMMUN_PAYMENTS_LOCATOR = "//span[text()=\"Коммунальные платежи\"]";
    public static String COMMUNAL_PROVIDERS_LOCATOR = "//a[contains(@class,\"ui-menu__link_icons_active\")]/span[@class=\"ui-link__text\"]";
    public static String LOOKUP_INPUT_LOCATOR = "//input[@class=\"ui-search-input__input\"]";

    public static String COMMUN_GRID_LOCATOR = "//li[@class=\"ui-menu__item ui-menu__item_icons\"]";
    public static String LOCATION_LOCATOR = "//span[@class=\"ui-link payment-page__title_inner\"]";

    public static String PERIOD_LOCATOR = "//input[@name='fieldperiod']";
    public static String PAYERCODE_LOCATOR = "//input[@name='fieldpayerCode']";
    public static String ERROR_MSG_LOCATOR = "//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']";

}
