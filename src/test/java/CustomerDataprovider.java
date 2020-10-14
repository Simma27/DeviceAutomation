import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.movedevice.RequestDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import services.DeviceService;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static config.DeviceConfig.*;

public class CustomerDataprovider {

    static DeviceService deviceService = new DeviceService();

    @DataProvider
    public Object[] getRequestBodyToCreateDevice() {
        return new RequestDeviceCreate[]{
                RequestDeviceCreate.builder()
                        .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                        .address("127.0.0.5")
                        .locationName(DEFAULT_LOCATION)
                        .name("ExampleDevice")
                        .type((long) 0)
                        .build()
        };
    }

    @DataProvider
    public Object[][] getResponseCreatedDevice() {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(RequestDeviceCreate
                .builder()
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        return new ResponseDeviceCreate[][]{{createdDevice}};
    }

    @DataProvider
    public Object[] getCreatedDifferentType() {
        return new RequestDeviceCreate[]{RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(0L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(1L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(2L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(3L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(4L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(5L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(6L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(7L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(8L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(9L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(10L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(11L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(12L).build()
                , RequestDeviceCreate.builder().accountSerialNumber(ACCOUNT_SERIAL_NUMBER).address("127.0.0.5").locationName(DEFAULT_LOCATION).name("ExampleDevice").type(13L).build()
        };
    }

    @DataProvider
    public Object[][] getDataToMoveDevice() {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(RequestDeviceCreate.builder()
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());

        List<models.api.movedevice.SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(models.api.movedevice.SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(createdDevice.getResult().getDevice().getSerialNumber())
                .build());

        return new Object[][]{{createdDevice
                , RequestDeviceMove
                .builder()
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(moveDevice)
                .build()
        }};
    }

    @DataProvider
    public static Object[] getDataToUpdateDevice() {
        List<models.api.updatedevice.DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<>();
        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
                .builder()
                .propertyName("SUSPEND")
                .propertyValue("true")
                .build());
        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_NAME")
                .propertyValue("ExampleDevice")
                .build());
        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_TYPE")
                .propertyValue("0")
                .build());
        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
                .builder()
                .propertyName("ADDRESS")
                .propertyValue("127.0.0.5")
                .build());
        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
                .builder()
                .propertyName("DO_NOT_RESOLVE_ADDRESS")
                .propertyValue("false")
                .build());

        return new Object[][]{{RequestDeviceCreate.builder()
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build(),
                RequestDeviceUpdate
                        .builder()
                        .deviceUpdateProperties(deviceUpdateProperties)
                        .build()}};
    }


}
