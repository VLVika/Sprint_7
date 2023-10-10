package ru.yandex.samokat.api.test.order;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.Order;
import steps.OrderClient;

import java.util.List;

@DisplayName("Получает список заказов")
public class GetOrderTest {

    public OrderClient client;


    @Step("создает экземпляры классов для тестирования")
    @BeforeEach
    public void SetUp() {
        client = new OrderClient();
    }

    @DisplayName("Получает список заказов")
    @Test
    void getOrderTest() {
        List<Order> ordersList = client.getOrder();
        Assertions.assertFalse(ordersList.isEmpty());
    }

}
