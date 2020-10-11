import models.api.BodyRequestToCreateDevice;
import models.api.BodyResponseCreatedDevice;
import services.BasicService;

public class CustomerDataprovider {

    public Object[] getCreatedDevice() {
        return new Object[] {BodyRequestToCreateDevice.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("Simma6 ")
                .type(BasicService.ACCOUNT_SERIAL_NUMBER)
                .build()
        };
    }
}
