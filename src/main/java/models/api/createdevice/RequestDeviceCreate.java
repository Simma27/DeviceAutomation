package models.api.createdevice;

import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceCreate extends AutorizationRequest {
     
    private int accountSerialNumber;
     
    private String address;
     
    private boolean applyAutomationProfiles;
     
    private boolean automaticTestDiscovery;
     
    private boolean clearOnOk;
     
    private String comment;
     
    private boolean configBackupEnabled;
     
    private boolean doNotResolveAddress;
     
    private int flapPreventionWaitCycles;
     
    private String locationName;
     
    private String model;
     
    private String name;
     
    private boolean processCollectionEnabled;
     
    private boolean rediscoveryEnabled;
     
    private boolean showOnSummary;
     
    private boolean smartNotify;
     
    private String tag1;
     
    private String tag2;
     
    private String tag3;
     
    private String tag4;
     
    private String tag5;
     
    private int type;
     
    private String vendor;
}
