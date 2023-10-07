package steps;

import org.apache.commons.lang3.RandomStringUtils;
import ru.java.samokat.pojo.CourierLoginRequest;
import ru.java.samokat.pojo.CreateNewCouriersRequest;

public class LoginGenerator {

    //получаем логин и пароль используемые при создании курьера
    public static CourierLoginRequest from(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(courier.getLogin(), courier.getPassword());
    }

    //получаем логин используемый при создании курьера, пароль рандомный
    public static CourierLoginRequest fromLogin(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(courier.getLogin(), RandomStringUtils.randomAlphanumeric(3, 7));
    }

    //получаем пароль используемый при создании курьера, логин рандомный
    public static CourierLoginRequest fromPassword(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(RandomStringUtils.randomAlphanumeric(3, 7), courier.getPassword());
    }

    public static CourierLoginRequest requestWithEmptyLogin(String password){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin("");
        request.setPassword(password);
        return request;
    }

    public static CourierLoginRequest requestWithEmptyPassword(String login){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(login);
        request.setPassword("");
        return request;
    }

    public static CourierLoginRequest requestWithoutFieldPassword(String login){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(login);
        return request;
    }

    public static CourierLoginRequest requestWithoutFieldLogin(String password){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setPassword(password);
        return request;
    }

    public static CourierLoginRequest requestFictitious(){
        CourierLoginRequest request = new CourierLoginRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setPassword(RandomStringUtils.randomAlphanumeric(4, 9));
        return request;
    }

}
