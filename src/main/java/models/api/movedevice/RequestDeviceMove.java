package models.api.movedevice;

import java.util.List;

import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import models.api.updatedevice.SearchCriteria;

@Data
@Builder
@ToString
public class RequestDeviceMove extends AutorizationRequest {
     
    private Object accountSerialNumber;
     
    private String newDeviceName;
     
    private List<SearchCriteria> searchCriterias;

    
}
