
package models.api.movedevice;

import java.util.List;
import config.Autorization;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceMove extends Autorization {

    private Long accountSerialNumber;

    private String newDeviceName;

    private List<SearchCriteria> searchCriterias;

    private Long serialNumber;
    
}