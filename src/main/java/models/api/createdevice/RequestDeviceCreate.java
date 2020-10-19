package models.api.createdevice;

import com.google.gson.annotations.Expose;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestDeviceCreate extends AutorizationRequest {
    @Expose
    private int accountSerialNumber;
    @Expose
    private String address;
    @Expose
    private boolean applyAutomationProfiles;
    @Expose
    private boolean automaticTestDiscovery;
    @Expose
    private boolean clearOnOk;
    @Expose
    private String comment;
    @Expose
    private boolean configBackupEnabled;
    @Expose
    private boolean doNotResolveAddress;
    @Expose
    private int flapPreventionWaitCycles;
    @Expose
    private String locationName;
    @Expose
    private String model;
    @Expose
    private String name;
    @Expose
    private boolean processCollectionEnabled;
    @Expose
    private boolean rediscoveryEnabled;
    @Expose
    private boolean showOnSummary;
    @Expose
    private boolean smartNotify;
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
    private int type;
    @Expose
    private String vendor;
}
