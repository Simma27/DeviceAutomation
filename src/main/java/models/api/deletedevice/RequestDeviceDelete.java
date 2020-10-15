package models.api.deletedevice;

import java.util.List;

import config.Autorization;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceDelete extends Autorization {

    private List<SearchCriteria> searchCriterias;

    private Long serialNumber;
}
