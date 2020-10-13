import models.api.Device;
import models.api.DeviceUpdateProperty;
import org.testng.annotations.DataProvider;
import services.BasicService;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataprovider {

    @DataProvider
    public Object[] getCreatedDevice() {
        return new Device[]{Device.builder()
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
        return new Device[]{Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(0L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(1L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(2L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(3L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(4L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(5L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(6L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(7L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(8L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(9L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(10L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(11L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(12L).build()
                , Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(13L).build()
        };
    }

    @DataProvider
    public static Object[] getDataToUpdateDevice() {
        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<>();
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("SUSPEND")
                .propertyValue("true")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_NAME")
                .propertyValue("ExampleDevice")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_TYPE")
                .propertyValue("0")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("ADDRESS")
                .propertyValue("127.0.0.5")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DO_NOT_RESOLVE_ADDRESS")
                .propertyValue("false")
                .build());

        return new Device[]{Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .deviceUpdateProperties(deviceUpdateProperties)
                .build()
        };
    }

    @DataProvider
    public static Object[] getDataToUpdateDeviceDifferentLine() {
        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<>();
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("SUSPEND")
                .propertyValue("true")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_NAME")
                .propertyValue("ExampleDevice")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_TYPE")
                .propertyValue("0")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("ADDRESS")
                .propertyValue("127.0.0.5")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("DO_NOT_RESOLVE_ADDRESS")
                .propertyValue("false")
                .build());
        deviceUpdateProperties.add(DeviceUpdateProperty
                .builder()
                .propertyName("COMMENT")
                .propertyValue("Different lines")
                .build());

        return new Device[]{Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .deviceUpdateProperties(deviceUpdateProperties)
                .build()
        };
    }

}
