package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * SearchCriteria class used to form request criteria of search.
 */
@Data
@Builder
@ToString
public class SearchCriteria {

    private String searchOption;

    private String searchTerms;


}
