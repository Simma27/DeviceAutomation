package models.api.updatedevice;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import models.api.deletedevice.Result;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "errorCode",
        "errorMessage",
        "timestamp",
        "timestampStr",
        "result"
})
public class ResponseDeviceUpdate {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("errorCode")
    private int errorCode;
    @JsonProperty("errorMessage")
    private Object errorMessage;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("timestampStr")
    private String timestampStr;
    @JsonProperty("result")
    private models.api.deletedevice.Result result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("errorCode")
    public Object getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("errorMessage")
    public Object getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("errorMessage")
    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("timestampStr")
    public String getTimestampStr() {
        return timestampStr;
    }

    @JsonProperty("timestampStr")
    public void setTimestampStr(String timestampStr) {
        this.timestampStr = timestampStr;
    }

    @JsonProperty("result")
    public models.api.deletedevice.Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}