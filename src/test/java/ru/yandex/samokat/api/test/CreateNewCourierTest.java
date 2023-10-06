package ru.yandex.samokat.api.test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CourierLoginRequest;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;


import static io.restassured.RestAssured.given;


@DisplayName("Создание курьера")
public class CreateNewCourierTest {

    private CourierClient client;
    private final ChekGetTrue check = new ChekGetTrue();
    private int CorierId;


    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
    }


    @DisplayName("Проверка успешного создания нового курьера")
    @Description("Проверяет успешное создание курьера с рандомным именем, затем логинится в приложение, получет id курьера и удаляет его")
    @Test
    void createNewCourierTest(){

        var courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);

        var creds = CourierLoginRequest.from(courier);
        CorierId = client.login(creds);
        assert CorierId!=0;


    }

    @AfterEach
    public void courierDelete(){

        boolean responseDelete = client.isSuccessDelete(CorierId);
        check.assertCreateGetTrue(responseDelete);
    }


}
