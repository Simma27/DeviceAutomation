
package models.api.movedevice;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SearchCriteria {

    @Expose
    private String searchOption;
    @Expose
    private Long searchTerms;

    public String getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
    }

    public Long getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(Long searchTerms) {
        this.searchTerms = searchTerms;
    }

}
