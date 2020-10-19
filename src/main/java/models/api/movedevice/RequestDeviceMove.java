package models.api.movedevice;

import java.util.List;

import com.google.gson.annotations.Expose;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceMove extends AutorizationRequest {
    @Expose
    private Object accountSerialNumber;
    @Expose
    private String newDeviceName;
    @Expose
    private List<SearchCriteria> searchCriterias;

    
}
