package steps;

import org.apache.commons.lang3.RandomStringUtils;
import ru.java.samokat.pojo.CreateNewCouriersRequest;

import java.util.Random;

public class CourierGenerator {

    public static CreateNewCouriersRequest genericCourier() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin("Иван1286");
        request.setPassword("1258");
        request.setFirstName("ИванV9");
        return request;
    }

    public static CreateNewCouriersRequest random() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4,9));
        request.setPassword("1258");
        request.setFirstName("ИванV9");
        return request;
    }
}
