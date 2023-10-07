package steps;

import io.qameta.allure.Step;
import ru.java.samokat.pojo.CreateOrderRequest;

public class OrderGenerator {

    @Step("Создает request на создание заказа")
    public static CreateOrderRequest createOrderRequest(String[] color){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setFirstName("Васильев");
        request.setLastName("Василий");
        request.setAddress("ул. Ямская, 5");
        request.setMetroStation(4);
        request.setPhone("+7 800 355 35 35");
        request.setRentTime(5);
        request.setDeliveryDate("2023-10-08");
        request.setComment("комментарий");
        request.setColor(color);
        return request;
    }
}
