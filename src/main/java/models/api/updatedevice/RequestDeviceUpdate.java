package models.api.updatedevice;

import java.util.List;

import com.google.gson.annotations.Expose;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceUpdate extends AutorizationRequest {
    @Expose
    private int serialNumber;
    @Expose
    private List<DeviceUpdateProperty> deviceUpdateProperties;
    @Expose
    private List<SearchCriteria> searchCriterias;

}
