package ru.java.samokat.pojo;


public class CreateNewCouriersRequest extends CourierLoginRequest {

    private String firstName;

    public CreateNewCouriersRequest() {
    }

    public CreateNewCouriersRequest(String login, String password, String firstName) {

        this.firstName = firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
