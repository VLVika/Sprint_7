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

    @Step("Отправляем json запрос/создаём 2го эдентичного курьера в приложении, полученный ответ кладём в переменную")
    public  String createTheSameClient(CreateNewCouriersRequest request) {
        return given()
                .spec(REQ_SPEC)
                .body(request)
                .when()
                .post(PATH_COURIER)
                .then()
                .spec(RES_SPEC_CONFLICT)
                .extract().jsonPath().getString("message");
    }


    @Step("Отправляем json запрос/логинимся в приложении, полученный ответ в виде id кладём в переменную")
    public int login(CourierLoginRequest creds) {
        int id =  given()
                .spec(REQ_SPEC)
                .body(creds)
                .when()
                .post(PATH_COURIER + COURIER_LOGIN)
                .then()
                .spec(RES_SPEC_OK)
                .extract().jsonPath().getInt("id");
        return id;
    }

    @Step("Отправляем json запрос/логинимся в приложении с неправильным password или login, полученный ответ кладём в переменную")
    public String loginWithWrongParams(CourierLoginRequest creds) {
        String message =  given()
                .spec(REQ_SPEC)
                .body(creds)
                .when()
                .post(PATH_COURIER + COURIER_LOGIN)
                .then()
                .spec(RES_SPEC_NOT_FOUND)
                .extract().jsonPath().getString("message");
        return message;
    }

    @Step("Отправляем json запрос/логинимся в приложении с пустым полем password или login, полученный ответ кладём в переменную")
    public String loginWithEmptyField(CourierLoginRequest creds) {
        String message =  given()
                .spec(REQ_SPEC)
                .body(creds)
                .when()
                .post(PATH_COURIER + COURIER_LOGIN)
                .then()
                .spec(RES_SPEC_BAD_REQUEST)
                .extract().jsonPath().getString("message");
        return message;
    }


    @Step("Отправляем delete запрос для удаления курьера, полученный ответ boolean кладем в переменную")
    public boolean isSuccessDelete(int id) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .delete(PATH_COURIER + "/" + id)
                .then()
                .spec(RES_SPEC_OK)
                .extract().jsonPath().getBoolean("ok");
    }

    @Step("Отправляем запрос для создания курьера, с пустым полем, полученный ответ кладем в переменную")
    public String fewDataForCreateCourier(CreateNewCouriersRequest courier) {
        return given()
                .spec(REQ_SPEC)
                .body(courier)
                .when()
                .post(PATH_COURIER)
                .then()
                .spec(RES_SPEC_BAD_REQUEST)
                .extract().jsonPath().getString("message");
    }



}
