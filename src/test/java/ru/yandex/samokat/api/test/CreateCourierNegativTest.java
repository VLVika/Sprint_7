package ru.yandex.samokat.api.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ChecEquals;
import steps.CourierClient;
import steps.CourierGenerator;

import static io.restassured.RestAssured.given;

@DisplayName("Создание курьера - негативные тесты")
public class CreateCourierNegativTest {

    String expected = "Недостаточно данных для создания учетной записи";

    private CourierClient client;
    private ChecEquals check;


    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
        check = new ChecEquals();
    }


    @DisplayName("Попытка создания курьера с пустым обязательным полем Пароль в json запроса")
    @Test
    void createCourierWithEmptyPassword(){

        var courier = CourierGenerator.withEmptyPassword();

        String requestEmptyPassword = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyPassword,expected);

    }


    @DisplayName("Попытка создания курьера с пустым обязательным полем Логин в json запроса")
    @Test
    void createCourierWithEmptyLogin(){

        var courier = CourierGenerator.withEmptyLogin();

        String requestEmptyLogin = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyLogin,expected);

    }

    @DisplayName("Попытка создания курьера без поля FirstName в json запросе")
    @Test
    void createCourierWithoutFieldFirstName(){

        var courier = CourierGenerator.withoutFieldFirstName();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }

    @DisplayName("Попытка создания курьера без поля Пароль в json запросе")
    @Test
    void createCourierWithoutFieldPassword(){

        var courier = CourierGenerator.withoutFieldPassword();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }


    @DisplayName("Попытка создания курьера без поля Логин в json запросе")
    @Test
    void createCourierWithoutFieldLogin(){

        var courier = CourierGenerator.withoutFieldLogin();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }

}
