package steps;

import io.qameta.allure.Step;
import ru.java.samokat.pojo.CreateOrderRequest;
import ru.java.samokat.pojo.Order;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.LocalVariables.CANCEL;
import static utils.LocalVariables.ORDER;
import static utils.Specification.*;

public class OrderClient {


    @Step("Отправляем json запрос/создаём заказ в приложении, полученный ответ кладём в переменную")
    public  int createOrder(CreateOrderRequest request) {
        return given()
                .spec(REQ_SPEC)
                .body(request)
                .when()
                .post(ORDER)
                .then()
                .spec(RES_SPEC_CREATED)
                .extract().jsonPath().getInt("track");
    }

    @Step("Отправляем json запрос на отмену заказа в приложении, полученный ответ кладём в переменную")
    public  boolean cancelOrder(int id) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .put(ORDER + CANCEL + id)
                .then()
                .spec(RES_SPEC_OK)
                .extract().jsonPath().getBoolean("ok");
    }

    @Step("Отправляем json запрос на получение списка заказов, полученный список кладём в переменную")
    public List<Order> getOrder() {
        List<Order> respons =
                given()
                .spec(REQ_SPEC)
                .get(ORDER)
                .then()
                .spec(RES_SPEC_OK)
                .extract().body().jsonPath().getList("orders",Order.class);
        return respons;
    }
}
