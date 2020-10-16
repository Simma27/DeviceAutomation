package models.api.movedevice;

import java.util.List;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceMove extends AutorizationRequest {

    private Object accountSerialNumber;

    private String newDeviceName;

    private List<SearchCriteria> searchCriterias;

    
}
