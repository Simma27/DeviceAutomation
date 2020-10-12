
package models.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteria {

    private String searchOption;

    private String searchTerms;


}
