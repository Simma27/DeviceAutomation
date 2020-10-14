
package models.api.movedevice;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import config.Autorization;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RequestDeviceMove implements Autorization {

    @Expose
    private Long accountSerialNumber;
    @Expose
    private String newDeviceName;
    @Expose
    private List<SearchCriteria> searchCriterias;

    public Long getAccountSerialNumber() {
        return accountSerialNumber;
    }

    public void setAccountSerialNumber(Long accountSerialNumber) {
        this.accountSerialNumber = accountSerialNumber;
    }

    public String getNewDeviceName() {
        return newDeviceName;
    }

    public void setNewDeviceName(String newDeviceName) {
        this.newDeviceName = newDeviceName;
    }

    public List<SearchCriteria> getSearchCriterias() {
        return searchCriterias;
    }

    public void setSearchCriterias(List<SearchCriteria> searchCriterias) {
        this.searchCriterias = searchCriterias;
    }

}
