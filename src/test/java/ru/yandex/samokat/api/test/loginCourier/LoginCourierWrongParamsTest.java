package ru.yandex.samokat.api.test.loginCourier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CreateNewCouriersRequest;
import steps.*;

@DisplayName("Логин курьера в системе с неправильными параметрами")
public class  LoginCourierWrongParamsTest {


    private CourierClient client;
    private ChekGetTrue check;
    private ChecEquals checEquals;
    private CreateNewCouriersRequest courier;
    private String corierMessage;
    private int CorierId;
    private String expected = "Учетная запись не найдена";


    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
        check = new ChekGetTrue();
        checEquals = new ChecEquals();
        courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);
    }



    @DisplayName("Логин курьера в системе с неправильным паролем")
    @Test
    void loginCourierWithWrongPasswordTest(){
        var creds = LoginGenerator.fromLogin(courier);
        corierMessage = client.loginWithWrongParams(creds);
        checEquals.checkEquals(corierMessage,expected);
    }

    @DisplayName("Логин курьера в системе с неправильным логином")
    @Test
    void loginCourierWithWrongLoginTest(){
        var creds = LoginGenerator.fromPassword(courier);
        corierMessage = client.loginWithWrongParams(creds);
        checEquals.checkEquals(corierMessage,expected);
    }


    @AfterEach
    public void courierDelete(){
        var creds = LoginGenerator.from(courier);
        CorierId = client.login(creds);
        assert CorierId!=0;
        boolean responseDelete = client.isSuccessDelete(CorierId);
        check.assertCreateGetTrue(responseDelete);
    }



}
