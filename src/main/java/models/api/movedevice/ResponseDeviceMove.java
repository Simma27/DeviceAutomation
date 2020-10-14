
package models.api.movedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class ResponseDeviceMove {
    
    private int errorCode;
    
    private String errorMessage;
    
    private Result result;
    
    private Boolean success;
    
    private Long timestamp;
    
    private String timestampStr;

}
