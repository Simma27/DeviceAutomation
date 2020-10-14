
package models.api.deletedevice;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import config.Autorization;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceDelete implements Autorization {

    private List<SearchCriteria> searchCriterias;

}
