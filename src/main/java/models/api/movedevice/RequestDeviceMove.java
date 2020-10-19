package models.api.movedevice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class RequestDeviceMove extends AutorizationRequest {
    @JsonProperty
    private Object accountSerialNumber;
    @JsonProperty
    private String newDeviceName;
    @JsonProperty
    private List<SearchCriteria> searchCriterias;

    
}
