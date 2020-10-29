package models.api.movedevice;

import models.api.updatedevice.SearchCriteria;
import config.request.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class RequestDeviceMove extends AutorizationRequest {
     
    private Object accountSerialNumber;
     
    private String newDeviceName;
     
    private List<SearchCriteria> searchCriterias;

    
}
