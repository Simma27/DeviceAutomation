package models.api.updatedevice;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Result {
    @Expose
    private String message;

}
