package steps;

import io.qameta.allure.Step;
import ru.java.samokat.pojo.CourierLoginRequest;
import ru.java.samokat.pojo.CreateNewCouriersRequest;

import static io.restassured.RestAssured.given;
import static utils.LocalVariables.COURIER_LOGIN;
import static utils.LocalVariables.PATH_COURIER;
import static utils.Specification.*;

public class CourierClient {

@Step("Отправляем json запрос/создаём курьера в приложении, полученный ответ кладём в переменную")
    public  boolean createClient(CreateNewCouriersRequest request) {
        return given()
                .spec(REQ_SPEC)
                .body(request)
                .when()
                .post(PATH_COURIER)
                .then()
                .spec(RES_SPEC_CREATED)
                .extract().jsonPath().getBoolean("ok");
    }


    @Step("Отправляем json запрос/логинимся в приложении, полученный ответ в виде id кладём в переменную")
    public int login(CourierLoginRequest creds) {
        return given()
                .spec(REQ_SPEC)
                .body(creds)
                .when()
                .post(PATH_COURIER + COURIER_LOGIN)
                .then()
                .spec(RES_SPEC_OK)
                .extract().jsonPath().getInt("id");
    }
}
