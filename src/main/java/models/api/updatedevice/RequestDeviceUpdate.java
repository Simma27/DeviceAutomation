
package models.api.updatedevice;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import config.Autorization;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RequestDeviceUpdate implements Autorization {

    @Expose
    private List<DeviceUpdateProperty> deviceUpdateProperties;
    @Expose
    private List<SearchCriteria> searchCriterias;

    public List<DeviceUpdateProperty> getDeviceUpdateProperties() {
        return deviceUpdateProperties;
    }

    public void setDeviceUpdateProperties(List<DeviceUpdateProperty> deviceUpdateProperties) {
        this.deviceUpdateProperties = deviceUpdateProperties;
    }

    public List<SearchCriteria> getSearchCriterias() {
        return searchCriterias;
    }

    public void setSearchCriterias(List<SearchCriteria> searchCriterias) {
        this.searchCriterias = searchCriterias;
    }

}
