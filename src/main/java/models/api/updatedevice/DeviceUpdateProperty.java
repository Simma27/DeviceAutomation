package models.api.updatedevice;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DeviceUpdateProperty {
    @Expose
    private String propertyName;
    @Expose
    private String propertyValue;

}
