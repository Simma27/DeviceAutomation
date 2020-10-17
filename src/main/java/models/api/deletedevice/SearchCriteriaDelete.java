package models.api.deletedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteriaDelete {

    private String searchOption;
    
    private Object searchTerms;

}
