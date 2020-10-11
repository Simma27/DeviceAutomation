
package models.api;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@Data
@Builder
@ToString
public class Device {

    @Expose
    private Object errorCode;
    @Expose
    private Object errorMessage;
    @Expose
    private Result result;
    @Expose
    private Boolean success;
    @Expose
    private Long timestamp;
    @Expose
    private String timestampStr;
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
    private Long serialNumber;
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

    private Long type;
    @Expose
    private String vendor;
    @Expose
    private Object virtualMachine;

    private String username;

    private String password;

    private String address;

    private Boolean applyAutomationProfiles;

    private Boolean automaticTestDiscovery;

    private String name;

    private List<SearchCriteria> searchCriterias;
}
