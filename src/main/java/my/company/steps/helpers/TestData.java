package my.company.steps.helpers;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static final List<String> payerCodeTestData = Arrays.asList("123456789", "12345678901", "Abc");
    public static final List<String> periodCodeTestData = Arrays.asList("13.2015", "99.2017");

    public static final String mandatoryFieldMessage="Поле обязательное";
    public static final String incorrectFieldMessage="Поле неправильно заполнено";
    public static final String incorrectField1Message="Поле заполнено некорректно";
}
