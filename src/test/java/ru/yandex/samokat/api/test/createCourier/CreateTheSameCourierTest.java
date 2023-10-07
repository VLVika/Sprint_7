package ru.yandex.samokat.api.test.createCourier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CourierLoginRequest;
import steps.*;

@DisplayName("Создание одинаковых курьеров")
public class CreateTheSameCourierTest {

    public CourierClient client;
    private ChekGetTrue check;
    private  ChecEquals checkEquals;
    private int CorierId;
    String expected = "Этот логин уже используется. Попробуйте другой.";



    @BeforeEach
    public void SetUp(){
      client = new CourierClient();
      check = new ChekGetTrue();
      checkEquals = new ChecEquals();
    }



    @DisplayName("Нельзя создать двух одинаковых курьеров")
    @Test
    void createTheSameCourierTest(){
        var courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);

        String responseTheSame = client.createTheSameClient(courier);
        checkEquals.checkEquals(responseTheSame,expected);
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
