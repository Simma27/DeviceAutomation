package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DeviceUpdateProperty {

    private String propertyName;

    private String propertyValue;
    
}
