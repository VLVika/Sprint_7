package ru.yandex.samokat.api.test.loginCourier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CreateNewCouriersRequest;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;
import steps.LoginGenerator;


@DisplayName("Логин курьера в системе")
public class LoginCourierTest {

    private CourierClient client;
    private ChekGetTrue check;
    private CreateNewCouriersRequest courier;
    protected int CorierId;


    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
        check = new ChekGetTrue();
        courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);
    }




    @DisplayName("Логин курьера в системе")
    @Test
    void loginCourierTest(){
        var creds = LoginGenerator.from(courier);
        CorierId = client.login(creds);
        assert CorierId!=0;
    }



    @AfterEach
    public void courierDelete(){
        boolean responseDelete = client.isSuccessDelete(CorierId);
        check.assertCreateGetTrue(responseDelete);
    }

}
