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
        return new Device[]{Device.builder().username(BasicService.USERNAME).password(BasicService.PASSWORD).accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(BasicService.DEFAULT_LOCATION).name("Simma").type(Long.valueOf(0)).build()
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
    public static Object[] getDataToUpdateDevice() {
        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<DeviceUpdateProperty>();
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
        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<DeviceUpdateProperty>();
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
