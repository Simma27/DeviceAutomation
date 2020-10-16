package models.api.movedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import models.api.updatedevice.SearchCriteriaUpdate;

@Data
@Builder
@ToString
public class SearchCriteria {

    private String searchOption;

    private Object searchTerms;
}
