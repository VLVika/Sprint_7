package ru.yandex.samokat.api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CreateNewCourierResponse;
import ru.java.samokat.pojo.CreateNewCouriersRequest;
import steps.CourierGenerator;


import static io.restassured.RestAssured.given;
import static ru.yandex.samokat.api.utils.Specification.REQ_SPEC;
import static ru.yandex.samokat.api.utils.Specification.RES_SPEC;
import static steps.CourierGenerator.genericCourier;

public class CreateNewCourierTest {

    @Test
    void createNewCourierTest(){
        var request = CourierGenerator.random();

        boolean response = given()
                .spec(REQ_SPEC)
                .body(request)
                .when()
                .post("courier")
                .then()
                .spec(RES_SPEC)
                .extract().jsonPath().getBoolean("ok");

        Assertions.assertTrue(response);

    }



}
