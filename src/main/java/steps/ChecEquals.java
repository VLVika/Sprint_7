package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class ChecEquals {

    @Step("Проверяем через Equals полученный результат")
    public void checkEquals(String response, String expected) {
        Assertions.assertEquals(expected, response, "Ошибка, ожидалось сообщение " + expected);
    }

}
