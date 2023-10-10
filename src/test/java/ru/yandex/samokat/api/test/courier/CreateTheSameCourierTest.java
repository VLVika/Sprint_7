package ru.yandex.samokat.api.test.courier;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Создание одинаковых курьеров")
public class CreateTheSameCourierTest {

    public CourierClient client;
    private ChekGetTrue check;
    private ChecEquals checkEquals;
    private int courierId;
    String expected = "Этот логин уже используется. Попробуйте другой.";


    @Step("создает экземпляры классов для тестирования")
    @BeforeEach
    public void SetUp() {
        client = new CourierClient();
        check = new ChekGetTrue();
        checkEquals = new ChecEquals();
    }


    @DisplayName("Нельзя создать двух одинаковых курьеров")
    @Test
    void createTheSameCourierTest() {
        var courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);

        String responseTheSame = client.createTheSameClient(courier);
        checkEquals.checkEquals(responseTheSame, expected);
        var creds = LoginGenerator.from(courier);

        courierId = client.login(creds);
        assertTrue(courierId != 0, "Ошибка! Поле пустое!!!!");

    }


    @AfterEach
    public void courierDelete() {
        boolean responseDelete = client.isSuccessDelete(courierId);
        check.assertCreateGetTrue(responseDelete);
    }

}
