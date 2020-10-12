
package models.api;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class deviceUpdateProperty {

    private String propertyName;

    private String propertyValue;
    
}
