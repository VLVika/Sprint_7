package ru.yandex.samokat.api.test.loginCourier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.*;


@DisplayName("Логин курьера в систему негитивные тесты")
public class LoginCourierNegativeTest  {

    private CourierClient client;
    private ChecEquals checEquals;
    String expected = "Недостаточно данных для входа";
    String password = "1258";
    String login = "Ivan258";
    private String resalt = "Учетная запись не найдена";


    @BeforeEach
    public void SetUp(){
        client = new CourierClient();
        checEquals = new ChecEquals();
    }

    @DisplayName("Логин курьера в систему с пустым поле логин")
    @Test
    void loginCourierWithEmptyFieldLogin(){
        var creds = LoginGenerator.requestWithEmptyLogin(password);
        String corierMessage = client.loginWithEmptyField(creds);
        checEquals.checkEquals(corierMessage,expected);

    }

    @DisplayName("Логин курьера в систему с пустым поле пароль")
    @Test
    void loginCourierWithEmptyFieldPassword(){
        var creds = LoginGenerator.requestWithEmptyPassword(login);
        String corierMessage = client.loginWithEmptyField(creds);
        checEquals.checkEquals(corierMessage,expected);

    }

    @DisplayName("Логин курьера в систему без поля пароль")
    @Test
    void loginCourierWithoutFieldPassword(){
        var creds = LoginGenerator.requestWithoutFieldPassword(login);
        String corierMessage = client.loginWithEmptyField(creds);
        checEquals.checkEquals(corierMessage,expected);

    }

    @DisplayName("Логин курьера в систему без поля логин")
    @Test
    void loginCourierWithoutFieldLogin(){
        var creds = LoginGenerator.requestWithoutFieldLogin(password);
        String corierMessage = client.loginWithEmptyField(creds);
        checEquals.checkEquals(corierMessage,expected);

    }

    @DisplayName("Логин курьера в систему с несуществующими параметрами")
    @Test
    void loginFictitiousCourier(){
        var creds = LoginGenerator.requestFictitious();
        String corierMessage = client.loginWithWrongParams(creds);
        checEquals.checkEquals(corierMessage,resalt);

    }



}
