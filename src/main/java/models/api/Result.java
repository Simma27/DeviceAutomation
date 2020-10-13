package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Result class used to form the response as a device class
 */
@Data
@Builder
@ToString
public class Result {
   
    private Device device;
   
    private String message;

}
