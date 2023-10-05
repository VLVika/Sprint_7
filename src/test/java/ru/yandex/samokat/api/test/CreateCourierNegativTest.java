package ru.yandex.samokat.api.test;

import org.junit.jupiter.api.Test;
import steps.ChecEquals;
import steps.CourierClient;
import steps.CourierGenerator;

import static io.restassured.RestAssured.given;

public class CreateCourierNegativTest {

    String expected = "Недостаточно данных для создания учетной записи";

    private final CourierClient client = new CourierClient();
    private final ChecEquals check = new ChecEquals();


    @Test
    void createCourierWithEmptyPassword(){

        var courier = CourierGenerator.withEmptyPassword();

        String requestEmptyPassword = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyPassword,expected);

    }



    @Test
    void createCourierWithEmptyLogin(){

        var courier = CourierGenerator.withEmptyLogin();

        String requestEmptyLogin = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyLogin,expected);

    }

    @Test
    void createCourierWithoutFieldFirstName(){

        var courier = CourierGenerator.withoutFieldFirstName();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }

    @Test
    void createCourierWithoutFieldPassword(){

        var courier = CourierGenerator.withoutFieldPassword();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }

    @Test
    void createCourierWithoutFieldLogin(){

        var courier = CourierGenerator.withoutFieldLogin();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName,expected);

    }

}
