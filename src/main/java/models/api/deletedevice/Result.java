package models.api.deletedevice;

import com.google.gson.annotations.Expose;

import models.api.createdevice.Device;

public class Result {

    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
