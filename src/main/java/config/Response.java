package config;

import com.google.gson.annotations.Expose;
import lombok.Data;
import models.api.createdevice.Result;
@Data
/**
 * The parent class for the response body.
 */
public class Response {
    @Expose
    private Object errorCode;
    @Expose
    private Object errorMessage;
    @Expose
    private Result result;
    @Expose
    private Boolean success;
    @Expose
    private Long timestamp;
    @Expose
    private String timestampStr;
}
