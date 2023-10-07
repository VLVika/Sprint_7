package steps;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import ru.java.samokat.pojo.CourierLoginRequest;
import ru.java.samokat.pojo.CreateNewCouriersRequest;

public class LoginGenerator {
    
    @Step("при создании request для логина в системе получает логин и пароль используемые при создании курьера")
    public static CourierLoginRequest from(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(courier.getLogin(), courier.getPassword());
    }

    @Step("при создании request для логина в системе получает логин используемый при создании курьера, пароль рандомный")
    public static CourierLoginRequest fromLogin(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(courier.getLogin(), RandomStringUtils.randomAlphanumeric(3, 7));
    }

    @Step("при создании request для логина в системе получает логин используемый при создании курьера, логин рандомный")
    public static CourierLoginRequest fromPassword(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(RandomStringUtils.randomAlphanumeric(3, 7), courier.getPassword());
    }

    @Step("при создании request для логина в системе оставляет пустым поле логин")
    public static CourierLoginRequest requestWithEmptyLogin(String password){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin("");
        request.setPassword(password);
        return request;
    }

    @Step("при создании request для логина в системе оставляет пустым поле пароль")
    public static CourierLoginRequest requestWithEmptyPassword(String login){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(login);
        request.setPassword("");
        return request;
    }

    @Step("при создании request для логина в системе использует 1 поле логин")
    public static CourierLoginRequest requestWithoutFieldPassword(String login){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(login);
        return request;
    }

    @Step("при создании request для логина в системе использует 1 поле пароль")
    public static CourierLoginRequest requestWithoutFieldLogin(String password){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setPassword(password);
        return request;
    }

    @Step("при создании request для логина в системе использует несуществующий логин и пароль")
    public static CourierLoginRequest requestFictitious(){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setPassword(RandomStringUtils.randomAlphanumeric(4, 9));
        return request;
    }

}
