package ru.java.samokat.pojo;

public class CourierLoginRequest {

    private String login;
    private String password;

    public CourierLoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierLoginRequest() {
    }

    public static CourierLoginRequest from(CreateNewCouriersRequest courier){
        return new CourierLoginRequest(courier.getLogin(), courier.getPassword());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
