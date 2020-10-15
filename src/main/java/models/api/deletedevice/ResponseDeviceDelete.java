package models.api.deletedevice;

import config.Response;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import models.api.createdevice.Result;

@Data
@Builder
@ToString
public class ResponseDeviceDelete {

    private Object errorCode;

    private Object errorMessage;

    private Result result;

    private Boolean success;

    private Long timestamp;

    private String timestampStr;

}
