package models.api.deletedevice;

import config.Enum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteria {

    private Enum searchOption;
    
    private String searchTerms;

}
