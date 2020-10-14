
package models.api.createdevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Result {

    
    private Device device;
    
    private String message;
    

}
