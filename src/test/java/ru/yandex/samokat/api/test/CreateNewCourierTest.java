package ru.yandex.samokat.api.test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CourierLoginRequest;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;


import static io.restassured.RestAssured.given;


@DisplayName("Создание курьера")
public class CreateNewCourierTest {

    private final CourierClient client = new CourierClient();
    private final ChekGetTrue check = new ChekGetTrue();



    @DisplayName("Проверка успешного создания нового курьера")
    @Description("Проверяет успешное создание курьера с рандомным именем, затем логинится в приложение, получет id курьера и удаляет его")
    @Test
    void createNewCourierTest(){

        var courier = CourierGenerator.random();

        boolean response = client.createClient(courier);

        check.assertCreateGetTrue(response);

        var creds = CourierLoginRequest.from(courier);

        int id = client.login(creds);

        assert id!=0;

        boolean responseDelete = client.isSuccessDelete(id);

        check.assertCreateGetTrue(responseDelete);

    }



}
