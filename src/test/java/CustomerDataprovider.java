import models.api.Device;
import org.testng.annotations.DataProvider;
import services.BasicService;

public class CustomerDataprovider {

    @DataProvider
    public Object[] getCreatedDevice() {
        return new Device[] { Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("Simma")
                .type(BasicService.ACCOUNT_SERIAL_NUMBER)
                .build()
        };
    }
}
