package ru.yandex.samokat.api.test.order;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import steps.ChekGetTrue;
import steps.OrderClient;
import steps.OrderGenerator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Создание заказа")
public class CreateOrderTest {

    public OrderClient client;
    private int orderId;
    private ChekGetTrue check;

    @Step("создает экземпляры классов для тестирования")
    @BeforeEach
    public void SetUp() {
        client = new OrderClient();
        check = new ChekGetTrue();
    }


    @DisplayName("Создает заказ с разным параметром - цвет")
    @ParameterizedTest(name = "Создание заказа с цветом/цветами {0}")
    @MethodSource("generateData")
    void createOrderTest(String[] color) {
        var order = OrderGenerator.createOrderRequest(color);
        orderId = client.createOrder(order);
        assertTrue(orderId != 0, "Ошибка! Поле пустое!!!!");

    }

    @Step("Отменяет созданный заказ")
    @AfterEach
    public void orderCancel() {
        boolean responseCancel = client.cancelOrder(orderId);
        check.assertCreateGetTrue(responseCancel);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of((Object) new String[]{""}),
                Arguments.of((Object) new String[]{"BLACK"}),
                Arguments.of((Object) new String[]{"GREY"}),
                Arguments.of((Object) new String[]{"BLACK", "GREY"})
        );

    }

}
