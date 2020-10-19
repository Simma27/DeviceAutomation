
package models.api.createdevice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isSuspended",
        "configBackupEnabled",
        "locationSerialNumber",
        "locationName",
        "serialNumber",
        "deviceName",
        "accountSerialNumber",
        "accountName",
        "deviceAddress",
        "deviceType",
        "deviceTypeStr",
        "comment",
        "deviceDetailUrl",
        "deviceUpdateUrl",
        "eventMgrUrl",
        "processCollectionEnabled",
        "assetId",
        "agentId",
        "organizationId",
        "liveConnectEnabled",
        "exported",
        "monitorConfigCount",
        "vendor",
        "model",
        "tag1",
        "tag2",
        "tag3",
        "tag4",
        "tag5",
        "flapPreventionWaitCycles",
        "showOnSummary",
        "rediscoveryEnabled",
        "rediscoveryFrequency",
        "rediscoveryNewTestsAction",
        "rediscoveryUpdatedTestsAction",
        "rediscoveryDeletedTestsAction",
        "applicationProfiles",
        "configBackupFrequency",
        "processCollectorType",
        "clearOnOk",
        "smartNotify",
        "processMonitorConfig",
        "processMonitorConfigName",
        "virtualMachine"
})
public class Device {

    @JsonProperty("isSuspended")
    private boolean isSuspended;
    @JsonProperty("configBackupEnabled")
    private boolean configBackupEnabled;
    @JsonProperty("locationSerialNumber")
    private int locationSerialNumber;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("serialNumber")
    private int serialNumber;
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("accountSerialNumber")
    private int accountSerialNumber;
    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("deviceAddress")
    private String deviceAddress;
    @JsonProperty("deviceType")
    private int deviceType;
    @JsonProperty("deviceTypeStr")
    private String deviceTypeStr;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("deviceDetailUrl")
    private String deviceDetailUrl;
    @JsonProperty("deviceUpdateUrl")
    private String deviceUpdateUrl;
    @JsonProperty("eventMgrUrl")
    private String eventMgrUrl;
    @JsonProperty("processCollectionEnabled")
    private boolean processCollectionEnabled;
    @JsonProperty("assetId")
    private int assetId;
    @JsonProperty("agentId")
    private int agentId;
    @JsonProperty("organizationId")
    private int organizationId;
    @JsonProperty("liveConnectEnabled")
    private Object liveConnectEnabled;
    @JsonProperty("exported")
    private boolean exported;
    @JsonProperty("monitorConfigCount")
    private int monitorConfigCount;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("model")
    private String model;
    @JsonProperty("tag1")
    private String tag1;
    @JsonProperty("tag2")
    private String tag2;
    @JsonProperty("tag3")
    private String tag3;
    @JsonProperty("tag4")
    private String tag4;
    @JsonProperty("tag5")
    private String tag5;
    @JsonProperty("flapPreventionWaitCycles")
    private int flapPreventionWaitCycles;
    @JsonProperty("showOnSummary")
    private boolean showOnSummary;
    @JsonProperty("rediscoveryEnabled")
    private boolean rediscoveryEnabled;
    @JsonProperty("rediscoveryFrequency")
    private int rediscoveryFrequency;
    @JsonProperty("rediscoveryNewTestsAction")
    private int rediscoveryNewTestsAction;
    @JsonProperty("rediscoveryUpdatedTestsAction")
    private int rediscoveryUpdatedTestsAction;
    @JsonProperty("rediscoveryDeletedTestsAction")
    private int rediscoveryDeletedTestsAction;
    @JsonProperty("applicationProfiles")
    private List<Object> applicationProfiles = null;
    @JsonProperty("configBackupFrequency")
    private int configBackupFrequency;
    @JsonProperty("processCollectorType")
    private Object processCollectorType;
    @JsonProperty("clearOnOk")
    private boolean clearOnOk;
    @JsonProperty("smartNotify")
    private boolean smartNotify;
    @JsonProperty("processMonitorConfig")
    private Object processMonitorConfig;
    @JsonProperty("processMonitorConfigName")
    private Object processMonitorConfigName;
    @JsonProperty("virtualMachine")
    private Object virtualMachine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isSuspended")
    public boolean getIsSuspended() {
        return isSuspended;
    }

    @JsonProperty("isSuspended")
    public void setIsSuspended(boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    @JsonProperty("configBackupEnabled")
    public boolean getConfigBackupEnabled() {
        return configBackupEnabled;
    }

    @JsonProperty("configBackupEnabled")
    public void setConfigBackupEnabled(boolean configBackupEnabled) {
        this.configBackupEnabled = configBackupEnabled;
    }

    @JsonProperty("locationSerialNumber")
    public int getLocationSerialNumber() {
        return locationSerialNumber;
    }

    @JsonProperty("locationSerialNumber")
    public void setLocationSerialNumber(int locationSerialNumber) {
        this.locationSerialNumber = locationSerialNumber;
    }

    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("serialNumber")
    public int getSerialNumber() {
        return serialNumber;
    }

    @JsonProperty("serialNumber")
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @JsonProperty("accountSerialNumber")
    public int getAccountSerialNumber() {
        return accountSerialNumber;
    }

    @JsonProperty("accountSerialNumber")
    public void setAccountSerialNumber(int accountSerialNumber) {
        this.accountSerialNumber = accountSerialNumber;
    }

    @JsonProperty("accountName")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("accountName")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @JsonProperty("deviceAddress")
    public String getDeviceAddress() {
        return deviceAddress;
    }

    @JsonProperty("deviceAddress")
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    @JsonProperty("deviceType")
    public int getDeviceType() {
        return deviceType;
    }

    @JsonProperty("deviceType")
    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    @JsonProperty("deviceTypeStr")
    public String getDeviceTypeStr() {
        return deviceTypeStr;
    }

    @JsonProperty("deviceTypeStr")
    public void setDeviceTypeStr(String deviceTypeStr) {
        this.deviceTypeStr = deviceTypeStr;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("deviceDetailUrl")
    public String getDeviceDetailUrl() {
        return deviceDetailUrl;
    }

    @JsonProperty("deviceDetailUrl")
    public void setDeviceDetailUrl(String deviceDetailUrl) {
        this.deviceDetailUrl = deviceDetailUrl;
    }

    @JsonProperty("deviceUpdateUrl")
    public String getDeviceUpdateUrl() {
        return deviceUpdateUrl;
    }

    @JsonProperty("deviceUpdateUrl")
    public void setDeviceUpdateUrl(String deviceUpdateUrl) {
        this.deviceUpdateUrl = deviceUpdateUrl;
    }

    @JsonProperty("eventMgrUrl")
    public String getEventMgrUrl() {
        return eventMgrUrl;
    }

    @JsonProperty("eventMgrUrl")
    public void setEventMgrUrl(String eventMgrUrl) {
        this.eventMgrUrl = eventMgrUrl;
    }

    @JsonProperty("processCollectionEnabled")
    public boolean getProcessCollectionEnabled() {
        return processCollectionEnabled;
    }

    @JsonProperty("processCollectionEnabled")
    public void setProcessCollectionEnabled(boolean processCollectionEnabled) {
        this.processCollectionEnabled = processCollectionEnabled;
    }

    @JsonProperty("assetId")
    public Object getAssetId() {
        return assetId;
    }

    @JsonProperty("assetId")
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("agentId")
    public Object getAgentId() {
        return agentId;
    }

    @JsonProperty("agentId")
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @JsonProperty("organizationId")
    public Object getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organizationId")
    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("liveConnectEnabled")
    public Object getLiveConnectEnabled() {
        return liveConnectEnabled;
    }

    @JsonProperty("liveConnectEnabled")
    public void setLiveConnectEnabled(Object liveConnectEnabled) {
        this.liveConnectEnabled = liveConnectEnabled;
    }

    @JsonProperty("exported")
    public boolean getExported() {
        return exported;
    }

    @JsonProperty("exported")
    public void setExported(boolean exported) {
        this.exported = exported;
    }

    @JsonProperty("monitorConfigCount")
    public int getMonitorConfigCount() {
        return monitorConfigCount;
    }

    @JsonProperty("monitorConfigCount")
    public void setMonitorConfigCount(int monitorConfigCount) {
        this.monitorConfigCount = monitorConfigCount;
    }

    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("tag1")
    public String getTag1() {
        return tag1;
    }

    @JsonProperty("tag1")
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    @JsonProperty("tag2")
    public String getTag2() {
        return tag2;
    }

    @JsonProperty("tag2")
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    @JsonProperty("tag3")
    public String getTag3() {
        return tag3;
    }

    @JsonProperty("tag3")
    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    @JsonProperty("tag4")
    public String getTag4() {
        return tag4;
    }

    @JsonProperty("tag4")
    public void setTag4(String tag4) {
        this.tag4 = tag4;
    }

    @JsonProperty("tag5")
    public String getTag5() {
        return tag5;
    }

    @JsonProperty("tag5")
    public void setTag5(String tag5) {
        this.tag5 = tag5;
    }

    @JsonProperty("flapPreventionWaitCycles")
    public int getFlapPreventionWaitCycles() {
        return flapPreventionWaitCycles;
    }

    @JsonProperty("flapPreventionWaitCycles")
    public void setFlapPreventionWaitCycles(int flapPreventionWaitCycles) {
        this.flapPreventionWaitCycles = flapPreventionWaitCycles;
    }

    @JsonProperty("showOnSummary")
    public boolean getShowOnSummary() {
        return showOnSummary;
    }

    @JsonProperty("showOnSummary")
    public void setShowOnSummary(boolean showOnSummary) {
        this.showOnSummary = showOnSummary;
    }

    @JsonProperty("rediscoveryEnabled")
    public boolean getRediscoveryEnabled() {
        return rediscoveryEnabled;
    }

    @JsonProperty("rediscoveryEnabled")
    public void setRediscoveryEnabled(boolean rediscoveryEnabled) {
        this.rediscoveryEnabled = rediscoveryEnabled;
    }

    @JsonProperty("rediscoveryFrequency")
    public int getRediscoveryFrequency() {
        return rediscoveryFrequency;
    }

    @JsonProperty("rediscoveryFrequency")
    public void setRediscoveryFrequency(int rediscoveryFrequency) {
        this.rediscoveryFrequency = rediscoveryFrequency;
    }

    @JsonProperty("rediscoveryNewTestsAction")
    public int getRediscoveryNewTestsAction() {
        return rediscoveryNewTestsAction;
    }

    @JsonProperty("rediscoveryNewTestsAction")
    public void setRediscoveryNewTestsAction(int rediscoveryNewTestsAction) {
        this.rediscoveryNewTestsAction = rediscoveryNewTestsAction;
    }

    @JsonProperty("rediscoveryUpdatedTestsAction")
    public int getRediscoveryUpdatedTestsAction() {
        return rediscoveryUpdatedTestsAction;
    }

    @JsonProperty("rediscoveryUpdatedTestsAction")
    public void setRediscoveryUpdatedTestsAction(int rediscoveryUpdatedTestsAction) {
        this.rediscoveryUpdatedTestsAction = rediscoveryUpdatedTestsAction;
    }

    @JsonProperty("rediscoveryDeletedTestsAction")
    public int getRediscoveryDeletedTestsAction() {
        return rediscoveryDeletedTestsAction;
    }

    @JsonProperty("rediscoveryDeletedTestsAction")
    public void setRediscoveryDeletedTestsAction(int rediscoveryDeletedTestsAction) {
        this.rediscoveryDeletedTestsAction = rediscoveryDeletedTestsAction;
    }

    @JsonProperty("applicationProfiles")
    public List<Object> getApplicationProfiles() {
        return applicationProfiles;
    }

    @JsonProperty("applicationProfiles")
    public void setApplicationProfiles(List<Object> applicationProfiles) {
        this.applicationProfiles = applicationProfiles;
    }

    @JsonProperty("configBackupFrequency")
    public int getConfigBackupFrequency() {
        return configBackupFrequency;
    }

    @JsonProperty("configBackupFrequency")
    public void setConfigBackupFrequency(int configBackupFrequency) {
        this.configBackupFrequency = configBackupFrequency;
    }

    @JsonProperty("processCollectorType")
    public Object getProcessCollectorType() {
        return processCollectorType;
    }

    @JsonProperty("processCollectorType")
    public void setProcessCollectorType(Object processCollectorType) {
        this.processCollectorType = processCollectorType;
    }

    @JsonProperty("clearOnOk")
    public boolean getClearOnOk() {
        return clearOnOk;
    }

    @JsonProperty("clearOnOk")
    public void setClearOnOk(boolean clearOnOk) {
        this.clearOnOk = clearOnOk;
    }

    @JsonProperty("smartNotify")
    public boolean getSmartNotify() {
        return smartNotify;
    }

    @JsonProperty("smartNotify")
    public void setSmartNotify(boolean smartNotify) {
        this.smartNotify = smartNotify;
    }

    @JsonProperty("processMonitorConfig")
    public Object getProcessMonitorConfig() {
        return processMonitorConfig;
    }

    @JsonProperty("processMonitorConfig")
    public void setProcessMonitorConfig(Object processMonitorConfig) {
        this.processMonitorConfig = processMonitorConfig;
    }

    @JsonProperty("processMonitorConfigName")
    public Object getProcessMonitorConfigName() {
        return processMonitorConfigName;
    }

    @JsonProperty("processMonitorConfigName")
    public void setProcessMonitorConfigName(Object processMonitorConfigName) {
        this.processMonitorConfigName = processMonitorConfigName;
    }

    @JsonProperty("virtualMachine")
    public Object getVirtualMachine() {
        return virtualMachine;
    }

    @JsonProperty("virtualMachine")
    public void setVirtualMachine(Object virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
