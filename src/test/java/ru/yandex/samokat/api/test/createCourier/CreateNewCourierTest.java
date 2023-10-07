package ru.yandex.samokat.api.test.createCourier;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;
import steps.LoginGenerator;


@DisplayName("Создание курьера")
public class CreateNewCourierTest {

    private CourierClient client;
    private final ChekGetTrue check = new ChekGetTrue();
    private int CorierId;


    @Step("создает экземпляры классов для тестирования")
    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
    }


    @DisplayName("Проверка успешного создания нового курьера")
    @Description("Проверяет успешное создание курьера с рандомным именем, затем логинится в приложение, получет id курьера и удаляет его")
    @Test
    void createNewCourierTest(){

        var courier = CourierGenerator.random();
        boolean response = client.createClient(courier);
        check.assertCreateGetTrue(response);

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
