package ru.java.samokat.pojo;

public class CreateNewCourierResponse {

    private Boolean ok;

    public CreateNewCourierResponse() {
    }

    public CreateNewCourierResponse(Boolean ok) {
        this.ok = ok;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
