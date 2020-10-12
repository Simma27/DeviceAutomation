import models.api.Device;
import models.api.deviceUpdateProperty;
import org.testng.annotations.DataProvider;
import services.BasicService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataprovider {

    @DataProvider
    public Object[] getCreatedDevice() {
        return new Device[] { Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build()
        };
    }

    @DataProvider
    public Object[] getCreatedDifferentType() {
        return new Device[] {Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(0)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(1)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(2)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(3)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(4)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(5)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(6)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(7)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(8)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(9)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(10)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(11)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(12)).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(13)).build()
        };
    }

    @DataProvider
    public Object[] getDataToUpdateDevice() {
        List<deviceUpdateProperty> deviceUpdateProperties = new ArrayList<deviceUpdateProperty>();
        deviceUpdateProperties.add(deviceUpdateProperty
                .builder()
                .propertyName("SUSPEND")
                .propertyValue("true")
                .build());
        deviceUpdateProperties.add(deviceUpdateProperty
                .builder()
                .propertyName("DEVICE_NAME")
                .propertyValue("ExampleDevice")
                .build());
        deviceUpdateProperties.add(deviceUpdateProperty
                .builder()
                .propertyName("DEVICE_TYPE")
                .propertyValue("0")
                .build());
        deviceUpdateProperties.add(deviceUpdateProperty
                .builder()
                .propertyName("ADDRESS")
                .propertyValue("127.0.0.5")
                .build());
        deviceUpdateProperties.add(deviceUpdateProperty
                .builder()
                .propertyName("DO_NOT_RESOLVE_ADDRESS")
                .propertyValue("false")
                .build());
        return new Device[] { Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build(), Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .deviceUpdateProperties(deviceUpdateProperties)
                .build()
        };
    }
}
