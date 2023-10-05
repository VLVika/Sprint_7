package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class ChekGetTrue {

    @Step("Проверяем через assertTrue полученный результат")
    public void assertCreateGetTrue(boolean response) {
        Assertions.assertTrue(response);
    }
}
