package models.api.updatedevice;

import java.util.List;

import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceUpdate extends AutorizationRequest {

    private int serialNumber;

    private List<DeviceUpdateProperty> deviceUpdateProperties;

    private List<SearchCriteriaUpdate> searchCriteriaUpdates;

}
