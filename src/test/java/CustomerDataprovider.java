import Impl.Service;
import models.api.Device;
import models.api.DeviceUpdateProperty;
import models.api.SearchCriteria;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static config.DeviceConfig.*;

public class CustomerDataprovider {

    static Service service = new Service();

    @DataProvider
    public Object[] getParamToCreateDevice() {
        return new Device[]{Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build()
        };
    }

    @DataProvider
    public Object[][] getCreatedDevice() {
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        return new Device[][]{{createdDevice}};
    }

    @DataProvider
    public Object[] getCreatedDifferentType() {
        return new Device[]{Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(0L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(1L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(2L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(3L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(4L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(5L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(6L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(7L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(8L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(9L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(10L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(11L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(12L).build()
                , Device.builder().username(USERNAME).password(PASSWORD).accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("Simma").type(13L).build()
        };
    }

    @DataProvider
    public Object[][] getDataToMoveDevice() {
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());

        List<SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(String.valueOf(createdDevice.getResult().getDevice().getSerialNumber()))
                .build());

        return new Device[][]{{createdDevice
                , Device
                .builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(moveDevice)
                .build()
        }};
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

        return new Device[][]{{Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .deviceUpdateProperties(deviceUpdateProperties)
                .build(), Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .deviceUpdateProperties(deviceUpdateProperties)
                .build()}};
    }


}
