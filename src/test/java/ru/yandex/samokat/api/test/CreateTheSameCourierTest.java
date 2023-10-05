package ru.yandex.samokat.api.test;

import org.junit.jupiter.api.Test;
import steps.ChecEquals;
import steps.ChekGetTrue;
import steps.CourierClient;
import steps.CourierGenerator;

public class CreateTheSameCourierTest {

    private final CourierClient client = new CourierClient();
    private final ChekGetTrue check = new ChekGetTrue();
    private final ChecEquals checkEquals = new ChecEquals();
    String expected = "Этот логин уже используется. Попробуйте другой.";


    @Test
    void createTheSameCourierTest(){
        var courier = CourierGenerator.random();

        boolean response = client.createClient(courier);

        check.assertCreateGetTrue(response);

        String responseTheSame = client.createTheSameClient(courier);

        checkEquals.checkEquals(responseTheSame,expected);
    }


}
