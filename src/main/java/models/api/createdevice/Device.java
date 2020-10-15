
package models.api.createdevice;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Device {

    private String accountName;
    
    private int accountSerialNumber;
    
    private List<Object> applicationProfiles;
    
    private boolean clearOnOk;
    
    private String comment;
    
    private boolean configBackupEnabled;
    
    private int configBackupFrequency;
    
    private String deviceAddress;
    
    private String deviceDetailUrl;
    
    private String deviceName;
    
    private int deviceType;
    
    private String deviceTypeStr;
    
    private String deviceUpdateUrl;
    
    private String eventMgrUrl;
    
    private boolean exported;
    
    private int flapPreventionWaitCycles;
    
    private boolean isSuspended;
    
    private Object liveConnectEnabled;
    
    private String locationName;

    private Object agentId;
    
    private int locationSerialNumber;
    
    private String model;
    
    private int monitorConfigCount;
    
    private Object organizationId;

    private Object assetId;
    
    private boolean processCollectionEnabled;
    
    private int processCollectorType;
    
    private int processMonitorConfig;
    
    private Object processMonitorConfigName;
    
    private int rediscoveryDeletedTestsAction;
    
    private boolean rediscoveryEnabled;
    
    private int rediscoveryFrequency;
    
    private int rediscoveryNewTestsAction;
    
    private int rediscoveryUpdatedTestsAction;
    
    private int serialNumber;
    
    private boolean showOnSummary;
    
    private boolean smartNotify;
    
    private String tag1;
    
    private String tag2;
    
    private String tag3;
    
    private String tag4;
    
    private String tag5;
    
    private String vendor;
    
    private Object virtualMachine;

}
