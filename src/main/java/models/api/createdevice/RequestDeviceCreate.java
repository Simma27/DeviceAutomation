package models.api.createdevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import config.AutorizationRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class RequestDeviceCreate extends AutorizationRequest {
    @JsonProperty
    private int accountSerialNumber;
    @JsonProperty
    private String address;
    @JsonProperty
    private boolean applyAutomationProfiles;
    @JsonProperty
    private boolean automaticTestDiscovery;
    @JsonProperty
    private boolean clearOnOk;
    @JsonProperty
    private String comment;
    @JsonProperty
    private boolean configBackupEnabled;
    @JsonProperty
    private boolean doNotResolveAddress;
    @JsonProperty
    private int flapPreventionWaitCycles;
    @JsonProperty
    private String locationName;
    @JsonProperty
    private String model;
    @JsonProperty
    private String name;
    @JsonProperty
    private boolean processCollectionEnabled;
    @JsonProperty
    private boolean rediscoveryEnabled;
    @JsonProperty
    private boolean showOnSummary;
    @JsonProperty
    private boolean smartNotify;
    @JsonProperty
    private String tag1;
    @JsonProperty
    private String tag2;
    @JsonProperty
    private String tag3;
    @JsonProperty
    private String tag4;
    @JsonProperty
    private String tag5;
    @JsonProperty
    private int type;
    @JsonProperty
    private String vendor;
}
