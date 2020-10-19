
package models.api.createdevice;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Device {

    @Expose
    private String accountName;
    @Expose
    private Long accountSerialNumber;
    @Expose
    private Object agentId;
    @Expose
    private List<Object> applicationProfiles;
    @Expose
    private Object assetId;
    @Expose
    private Boolean clearOnOk;
    @Expose
    private String comment;
    @Expose
    private Boolean configBackupEnabled;
    @Expose
    private Long configBackupFrequency;
    @Expose
    private String deviceAddress;
    @Expose
    private String deviceDetailUrl;
    @Expose
    private String deviceName;
    @Expose
    private Long deviceType;
    @Expose
    private String deviceTypeStr;
    @Expose
    private String deviceUpdateUrl;
    @Expose
    private String eventMgrUrl;
    @Expose
    private Boolean exported;
    @Expose
    private Long flapPreventionWaitCycles;
    @Expose
    private Boolean isSuspended;
    @Expose
    private Object liveConnectEnabled;
    @Expose
    private String locationName;
    @Expose
    private Long locationSerialNumber;
    @Expose
    private String model;
    @Expose
    private Long monitorConfigCount;
    @Expose
    private Object organizationId;
    @Expose
    private Boolean processCollectionEnabled;
    @Expose
    private Object processCollectorType;
    @Expose
    private Object processMonitorConfig;
    @Expose
    private Object processMonitorConfigName;
    @Expose
    private Long rediscoveryDeletedTestsAction;
    @Expose
    private Boolean rediscoveryEnabled;
    @Expose
    private Long rediscoveryFrequency;
    @Expose
    private Long rediscoveryNewTestsAction;
    @Expose
    private Long rediscoveryUpdatedTestsAction;
    @Expose
    private int serialNumber;
    @Expose
    private Boolean showOnSummary;
    @Expose
    private Boolean smartNotify;
    @Expose
    private String tag1;
    @Expose
    private String tag2;
    @Expose
    private String tag3;
    @Expose
    private String tag4;
    @Expose
    private String tag5;
    @Expose
    private String vendor;
    @Expose
    private Object virtualMachine;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountSerialNumber() {
        return accountSerialNumber;
    }

    public void setAccountSerialNumber(Long accountSerialNumber) {
        this.accountSerialNumber = accountSerialNumber;
    }

    public Object getAgentId() {
        return agentId;
    }

    public void setAgentId(Object agentId) {
        this.agentId = agentId;
    }

    public List<Object> getApplicationProfiles() {
        return applicationProfiles;
    }

    public void setApplicationProfiles(List<Object> applicationProfiles) {
        this.applicationProfiles = applicationProfiles;
    }

    public Object getAssetId() {
        return assetId;
    }

    public void setAssetId(Object assetId) {
        this.assetId = assetId;
    }

    public Boolean getClearOnOk() {
        return clearOnOk;
    }

    public void setClearOnOk(Boolean clearOnOk) {
        this.clearOnOk = clearOnOk;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getConfigBackupEnabled() {
        return configBackupEnabled;
    }

    public void setConfigBackupEnabled(Boolean configBackupEnabled) {
        this.configBackupEnabled = configBackupEnabled;
    }

    public Long getConfigBackupFrequency() {
        return configBackupFrequency;
    }

    public void setConfigBackupFrequency(Long configBackupFrequency) {
        this.configBackupFrequency = configBackupFrequency;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public String getDeviceDetailUrl() {
        return deviceDetailUrl;
    }

    public void setDeviceDetailUrl(String deviceDetailUrl) {
        this.deviceDetailUrl = deviceDetailUrl;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeStr() {
        return deviceTypeStr;
    }

    public void setDeviceTypeStr(String deviceTypeStr) {
        this.deviceTypeStr = deviceTypeStr;
    }

    public String getDeviceUpdateUrl() {
        return deviceUpdateUrl;
    }

    public void setDeviceUpdateUrl(String deviceUpdateUrl) {
        this.deviceUpdateUrl = deviceUpdateUrl;
    }

    public String getEventMgrUrl() {
        return eventMgrUrl;
    }

    public void setEventMgrUrl(String eventMgrUrl) {
        this.eventMgrUrl = eventMgrUrl;
    }

    public Boolean getExported() {
        return exported;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Long getFlapPreventionWaitCycles() {
        return flapPreventionWaitCycles;
    }

    public void setFlapPreventionWaitCycles(Long flapPreventionWaitCycles) {
        this.flapPreventionWaitCycles = flapPreventionWaitCycles;
    }

    public Boolean getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(Boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public Object getLiveConnectEnabled() {
        return liveConnectEnabled;
    }

    public void setLiveConnectEnabled(Object liveConnectEnabled) {
        this.liveConnectEnabled = liveConnectEnabled;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getLocationSerialNumber() {
        return locationSerialNumber;
    }

    public void setLocationSerialNumber(Long locationSerialNumber) {
        this.locationSerialNumber = locationSerialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getMonitorConfigCount() {
        return monitorConfigCount;
    }

    public void setMonitorConfigCount(Long monitorConfigCount) {
        this.monitorConfigCount = monitorConfigCount;
    }

    public Object getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Object organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getProcessCollectionEnabled() {
        return processCollectionEnabled;
    }

    public void setProcessCollectionEnabled(Boolean processCollectionEnabled) {
        this.processCollectionEnabled = processCollectionEnabled;
    }

    public Object getProcessCollectorType() {
        return processCollectorType;
    }

    public void setProcessCollectorType(Object processCollectorType) {
        this.processCollectorType = processCollectorType;
    }

    public Object getProcessMonitorConfig() {
        return processMonitorConfig;
    }

    public void setProcessMonitorConfig(Object processMonitorConfig) {
        this.processMonitorConfig = processMonitorConfig;
    }

    public Object getProcessMonitorConfigName() {
        return processMonitorConfigName;
    }

    public void setProcessMonitorConfigName(Object processMonitorConfigName) {
        this.processMonitorConfigName = processMonitorConfigName;
    }

    public Long getRediscoveryDeletedTestsAction() {
        return rediscoveryDeletedTestsAction;
    }

    public void setRediscoveryDeletedTestsAction(Long rediscoveryDeletedTestsAction) {
        this.rediscoveryDeletedTestsAction = rediscoveryDeletedTestsAction;
    }

    public Boolean getRediscoveryEnabled() {
        return rediscoveryEnabled;
    }

    public void setRediscoveryEnabled(Boolean rediscoveryEnabled) {
        this.rediscoveryEnabled = rediscoveryEnabled;
    }

    public Long getRediscoveryFrequency() {
        return rediscoveryFrequency;
    }

    public void setRediscoveryFrequency(Long rediscoveryFrequency) {
        this.rediscoveryFrequency = rediscoveryFrequency;
    }

    public Long getRediscoveryNewTestsAction() {
        return rediscoveryNewTestsAction;
    }

    public void setRediscoveryNewTestsAction(Long rediscoveryNewTestsAction) {
        this.rediscoveryNewTestsAction = rediscoveryNewTestsAction;
    }

    public Long getRediscoveryUpdatedTestsAction() {
        return rediscoveryUpdatedTestsAction;
    }

    public void setRediscoveryUpdatedTestsAction(Long rediscoveryUpdatedTestsAction) {
        this.rediscoveryUpdatedTestsAction = rediscoveryUpdatedTestsAction;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getShowOnSummary() {
        return showOnSummary;
    }

    public void setShowOnSummary(Boolean showOnSummary) {
        this.showOnSummary = showOnSummary;
    }

    public Boolean getSmartNotify() {
        return smartNotify;
    }

    public void setSmartNotify(Boolean smartNotify) {
        this.smartNotify = smartNotify;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getTag4() {
        return tag4;
    }

    public void setTag4(String tag4) {
        this.tag4 = tag4;
    }

    public String getTag5() {
        return tag5;
    }

    public void setTag5(String tag5) {
        this.tag5 = tag5;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Object getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(Object virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

}
