
package models.api.updatedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponseDeviceUpdate {

    private Object errorCode;
    
    private Object errorMessage;
    
    private Result result;
    
    private Boolean success;
    
    private Long timestamp;
    
    private String timestampStr;

}
