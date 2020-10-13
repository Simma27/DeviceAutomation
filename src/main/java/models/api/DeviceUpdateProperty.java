package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * This class used for update Device.
 * Consists of propertyName, the parameter that will be updated and propertyValue, the parameter value.
 */
@Data
@Builder
@ToString
public class DeviceUpdateProperty {

    private String propertyName;
    private String propertyValue;
    
}
