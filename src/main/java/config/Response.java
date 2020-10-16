package config;

import lombok.Data;
import models.api.createdevice.Result;
@Data
public class Response {

    private Object errorCode;

    private Object errorMessage;

    private Result result;

    private Boolean success;

    private Long timestamp;

    private String timestampStr;
}
