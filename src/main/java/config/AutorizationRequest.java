package config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The parent class for the request body, with username and password fields for authorization.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class AutorizationRequest {
    @JsonProperty
    public final String username = "superuser";
    @JsonProperty
    public final String password = "traverse";
}
