package models.api.movedevice;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteria {

    private String searchOption;

    private Object searchTerms;
}
