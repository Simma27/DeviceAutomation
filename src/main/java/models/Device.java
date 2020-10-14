package models;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * The Device configures all devices managed by Traverse.
 * Each row contains the Department, Device Name, Address, Device type, State (Active or Suspended) and Location.
 * This class is used for requests and responses for basic device functions.
 */
@Data
@Builder
@ToString
public class Device {

    private Object errorCode;

    private Object errorMessage;

    private Result result;

    private Boolean success;

    private Long timestamp;

    private String timestampStr;

    private String accountName;

    private Long accountSerialNumber;

    private Object agentId;

    private List<Object> applicationProfiles;

    private Object assetId;

    private Boolean clearOnOk;

    private String comment;

    private Boolean configBackupEnabled;

    private Long configBackupFrequency;

    private String deviceAddress;

    private String deviceDetailUrl;

    private String deviceName;

    private Long deviceType;

    private String deviceTypeStr;

    private String deviceUpdateUrl;

    private String eventMgrUrl;

    private Boolean exported;

    private Long flapPreventionWaitCycles;

    private Boolean isSuspended;

    private Object liveConnectEnabled;

    private String locationName;

    private Long locationSerialNumber;

    private String model;

    private Long monitorConfigCount;

    private Object organizationId;

    private Boolean processCollectionEnabled;

    private Object processCollectorType;

    private Object processMonitorConfig;

    private Object processMonitorConfigName;

    private Long rediscoveryDeletedTestsAction;

    private Boolean rediscoveryEnabled;

    private Long rediscoveryFrequency;

    private Long rediscoveryNewTestsAction;

    private Long rediscoveryUpdatedTestsAction;

    private Long serialNumber;

    private Boolean showOnSummary;

    private Boolean smartNotify;

    private String tag1;

    private String tag2;

    private String tag3;

    private String tag4;

    private String tag5;

    private Long type;

    private String vendor;

    private Object virtualMachine;

    private String username;

    private String password;

    private String address;

    private Boolean applyAutomationProfiles;

    private Boolean automaticTestDiscovery;

    private String name;

    private List<SearchCriteria> searchCriterias;

    private String propertyName;

    private String propertyValue;

    private DeviceUpdateProperty deviceUpdateProperty;

    private List<DeviceUpdateProperty> deviceUpdateProperties;

    private SearchCriteria searchCriteria;

}
