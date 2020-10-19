package models.api.deletedevice;

import java.util.List;

import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceDelete extends AutorizationRequest {

    private List<SearchCriteria> searchCriterias;

    private int serialNumber;
}
