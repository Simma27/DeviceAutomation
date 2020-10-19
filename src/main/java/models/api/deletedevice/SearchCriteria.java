package models.api.deletedevice;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SearchCriteria {
    @Expose
    private String searchOption;
    @Expose
    private Object searchTerms;

}
