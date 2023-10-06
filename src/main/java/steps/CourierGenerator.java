package steps;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import ru.java.samokat.pojo.CreateNewCouriersRequest;

public class CourierGenerator {


    public static CreateNewCouriersRequest genericCourier(String login, String password, String firstName) {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest(login, password, firstName);
        return request;
    }

    @Step("Создает json request с параметрами")
    public static CreateNewCouriersRequest random() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setPassword("1258");
        request.setFirstName("ИванV9");
        return request;
    }

    @Step("Создает json request с 2 параметрами и пустым полем Password")
    public static CreateNewCouriersRequest withEmptyPassword() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setPassword("");
        request.setFirstName("ИванV9");
        return request;
    }

    @Step("Создает json request с 2 параметрами и пустым полем Login")
    public static CreateNewCouriersRequest withEmptyLogin() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin("");
        request.setPassword("1258");
        request.setFirstName("ИванV9");
        return request;
    }

    @Step("Создает json request с 2 полями без поля FirstName")
    public static CreateNewCouriersRequest withoutFieldFirstName() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setPassword("1258");
        return request;

    }

    @Step("Создает json request с 2 полями без поля Password")
    public static CreateNewCouriersRequest withoutFieldPassword() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setLogin(RandomStringUtils.randomAlphanumeric(4, 9));
        request.setFirstName("ИванV9");
        return request;
    }

    @Step("Создает json request с 2 полями без поля Login")
    public static CreateNewCouriersRequest withoutFieldLogin() {
        CreateNewCouriersRequest request = new CreateNewCouriersRequest();
        request.setPassword("1258");
        request.setFirstName("ИванV9");
        return request;
    }
}
