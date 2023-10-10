package ru.yandex.samokat.api.test.courier;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.samokat.pojo.CreateNewCouriersRequest;
import steps.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Создание курьера - негативные тесты")
public class CreateCourierNegativTest {

    String expected = "Недостаточно данных для создания учетной записи";

    private CourierClient client;
    private ChecEquals check;


    @Step("создает экземпляры классов для тестирования")
    @BeforeEach
    public void SetUp() {
        client = new CourierClient();
        check = new ChecEquals();
    }


    @DisplayName("Попытка создания курьера с пустым обязательным полем Пароль в json запроса")
    @Test
    void createCourierWithEmptyPassword() {

        var courier = CourierGenerator.withEmptyPassword();

        String requestEmptyPassword = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyPassword, expected);

    }


    @DisplayName("Попытка создания курьера с пустым обязательным полем Логин в json запроса")
    @Test
    void createCourierWithEmptyLogin() {

        var courier = CourierGenerator.withEmptyLogin();

        String requestEmptyLogin = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyLogin, expected);

    }

    @DisplayName("Попытка создания курьера без поля FirstName в json запросе")
    @Test
    void createCourierWithoutFieldFirstName() {

        var courier = CourierGenerator.withoutFieldFirstName();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName, expected);

    }

    @DisplayName("Попытка создания курьера без поля Пароль в json запросе")
    @Test
    void createCourierWithoutFieldPassword() {

        var courier = CourierGenerator.withoutFieldPassword();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName, expected);

    }


    @DisplayName("Попытка создания курьера без поля Логин в json запросе")
    @Test
    void createCourierWithoutFieldLogin() {

        var courier = CourierGenerator.withoutFieldLogin();

        String requestEmptyFirstName = client.fewDataForCreateCourier(courier);

        check.checkEquals(requestEmptyFirstName, expected);

    }

    @DisplayName("Логин курьера в систему негитивные тесты")
    public static class LoginCourierNegativeTest {

        private CourierClient client;
        private ChecEquals checEquals;
        String expected = "Недостаточно данных для входа";
        String password = "1258";
        String login = "Ivan258";
        private String resalt = "Учетная запись не найдена";


        @Step("создает экземпляры классов для тестирования")
        @BeforeEach
        public void SetUp() {
            client = new CourierClient();
            checEquals = new ChecEquals();
        }

        @DisplayName("Логин курьера в систему с пустым поле логин")
        @Test
        void loginCourierWithEmptyFieldLogin() {
            var creds = LoginGenerator.requestWithEmptyLogin(password);
            String corierMessage = client.loginWithEmptyField(creds);
            checEquals.checkEquals(corierMessage, expected);

        }

        @DisplayName("Логин курьера в систему с пустым поле пароль")
        @Test
        void loginCourierWithEmptyFieldPassword() {
            var creds = LoginGenerator.requestWithEmptyPassword(login);
            String corierMessage = client.loginWithEmptyField(creds);
            checEquals.checkEquals(corierMessage, expected);

        }

        @DisplayName("Логин курьера в систему без поля пароль")
        @Test
        void loginCourierWithoutFieldPassword() {
            var creds = LoginGenerator.requestWithoutFieldPassword(login);
            String corierMessage = client.loginWithEmptyField(creds);
            checEquals.checkEquals(corierMessage, expected);

        }

        @DisplayName("Логин курьера в систему без поля логин")
        @Test
        void loginCourierWithoutFieldLogin() {
            var creds = LoginGenerator.requestWithoutFieldLogin(password);
            String corierMessage = client.loginWithEmptyField(creds);
            checEquals.checkEquals(corierMessage, expected);

        }

        @DisplayName("Логин курьера в систему с несуществующими параметрами")
        @Test
        void loginFictitiousCourier() {
            var creds = LoginGenerator.requestFictitious();
            String corierMessage = client.loginWithWrongParams(creds);
            checEquals.checkEquals(corierMessage, resalt);

        }

    }

    @DisplayName("Логин курьера в системе")
    public static class LoginCourierTest {

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

    @DisplayName("Логин курьера в системе с неправильными параметрами")
    public static class LoginCourierWrongParamsTest {


        private CourierClient client;
        private ChekGetTrue check;
        private ChecEquals checEquals;
        private CreateNewCouriersRequest courier;
        private String corierMessage;
        private int courierId;
        private String expected = "Учетная запись не найдена";


        @BeforeEach
        public void SetUp() {
            client = new CourierClient();
            check = new ChekGetTrue();
            checEquals = new ChecEquals();
            courier = CourierGenerator.random();
            boolean response = client.createClient(courier);
            check.assertCreateGetTrue(response);
        }


        @DisplayName("Логин курьера в системе с неправильным паролем")
        @Test
        void loginCourierWithWrongPasswordTest() {
            var creds = LoginGenerator.fromLogin(courier);
            corierMessage = client.loginWithWrongParams(creds);
            checEquals.checkEquals(corierMessage, expected);
        }

        @DisplayName("Логин курьера в системе с неправильным логином")
        @Test
        void loginCourierWithWrongLoginTest() {
            var creds = LoginGenerator.fromPassword(courier);
            corierMessage = client.loginWithWrongParams(creds);
            checEquals.checkEquals(corierMessage, expected);
        }


        @AfterEach
        public void courierDelete() {
            var creds = LoginGenerator.from(courier);
            courierId = client.login(creds);
            assertTrue(courierId != 0, "Ошибка! Поле пустое!!!!");
            boolean responseDelete = client.isSuccessDelete(courierId);
            check.assertCreateGetTrue(responseDelete);
        }

    }

}
