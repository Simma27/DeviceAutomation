package models.api.createdevice;

import config.Autorization;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceCreate extends Autorization {

    private Long accountSerialNumber;
    
    private String address;
    
    private Boolean applyAutomationProfiles;
    
    private Boolean automaticTestDiscovery;
    
    private Boolean clearOnOk;
    
    private String comment;
    
    private Boolean configBackupEnabled;
    
    private Boolean doNotResolveAddress;
    
    private Long flapPreventionWaitCycles;
    
    private String locationName;
    
    private String model;
    
    private String name;
    
    private Boolean processCollectionEnabled;
    
    private Boolean rediscoveryEnabled;
    
    private Boolean showOnSummary;
    
    private Boolean smartNotify;
    
    private String tag1;
    
    private String tag2;
    
    private String tag3;
    
    private String tag4;
    
    private String tag5;
    
    private Long type;
    
    private String vendor;
}
