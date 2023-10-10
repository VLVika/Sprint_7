package ru.yandex.samokat.api.test.courier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CreateNewCouriersRequest;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;
import steps.LoginGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Логин курьера в системе")
public class LoginCourierTest {

    private CourierClient client;
    private ChekGetTrue check;
    private CreateNewCouriersRequest courier;
    protected int courierId;


    @BeforeEach
    public void SetUp() {
        client = new CourierClient();
        check = new ChekGetTrue();
        courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);
    }


    @DisplayName("Логин курьера в системе")
    @Test
    void loginCourierTest() {
        var creds = LoginGenerator.from(courier);
        courierId = client.login(creds);
        assertTrue(courierId != 0, "Ошибка! Поле пустое!!!!");
    }


    @AfterEach
    public void courierDelete() {
        boolean responseDelete = client.isSuccessDelete(courierId);
        check.assertCreateGetTrue(responseDelete);
    }

}
