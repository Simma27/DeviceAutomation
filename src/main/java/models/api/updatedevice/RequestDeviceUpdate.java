
package models.api.updatedevice;

import java.util.List;

import config.Autorization;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceUpdate extends Autorization {

    private Long serialNumber;
    private List<DeviceUpdateProperty> deviceUpdateProperties;
    private List<SearchCriteria> searchCriterias;

}
