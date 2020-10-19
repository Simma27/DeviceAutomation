package models.api.updatedevice;


import com.google.gson.annotations.Expose;
import models.api.createdevice.Result;

public class ResponseDeviceUpdate {

    @Expose
    private int errorCode;
    @Expose
    private Object errorMessage;
    @Expose
    private models.api.createdevice.Result result;
    @Expose
    private Boolean success;
    @Expose
    private Long timestamp;
    @Expose
    private String timestampStr;

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public models.api.createdevice.Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestampStr() {
        return timestampStr;
    }

    public void setTimestampStr(String timestampStr) {
        this.timestampStr = timestampStr;
    }


}
