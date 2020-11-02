package device.models.api.updatedevice;

import device.config.request.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class RequestDeviceUpdate extends AutorizationRequest {
     
    private int serialNumber;
     
    private List<DeviceUpdateProperty> deviceUpdateProperties;
     
    private List<SearchCriteria> searchCriterias;

}
