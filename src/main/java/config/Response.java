package config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import models.api.createdevice.Result;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The parent class for the response body.
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "errorCode",
        "errorMessage",
        "timestamp",
        "timestampStr",
        "result"
})
public class Response {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("errorCode")
    private Object errorCode;
    @JsonProperty("errorMessage")
    private Object errorMessage;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("timestampStr")
    private String timestampStr;
    @JsonProperty("result")
    private Result result;
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
    public void setErrorCode(Object errorCode) {
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
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
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
    public Result getResult() {
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