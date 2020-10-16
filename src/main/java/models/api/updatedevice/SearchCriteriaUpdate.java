package models.api.updatedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteriaUpdate {

    private String searchOption;

    private int searchTerms;

}
