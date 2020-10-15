import config.Config;
import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import org.apache.commons.lang3.RandomStringUtils;
import services.DeviceService;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Array;
import java.util.Arrays;

import static config.Config.ACCOUNT_SERIAL_NUMBER;
import static config.Config.DEFAULT_LOCATION;

public class DeviceDataProvider {

    static DeviceService deviceService = new DeviceService();

    @DataProvider
    public Object[] getRequestBodyToCreateDevice() {
        return new RequestDeviceCreate[]{
                RequestDeviceCreate.builder()
                        .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                        .address("127.0.0.5")
                        .applyAutomationProfiles(true)
                        .automaticTestDiscovery(true)
                        .clearOnOk(false)
                        .comment("Comment")
                        .configBackupEnabled(false)
                        .doNotResolveAddress(false)
                        .flapPreventionWaitCycles(-1)
                        .locationName(DEFAULT_LOCATION)
                        .model("Model")
                        .name(RandomStringUtils.randomAlphabetic(8))
                        .processCollectionEnabled(false)
                        .rediscoveryEnabled(false)
                        .showOnSummary(true)
                        .smartNotify(true)
                        .tag1("tag1")
                        .tag2("tag2")
                        .tag3("tag3")
                        .tag4("tag4")
                        .tag5("tag5")
                        .type(0)
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
                .type(0)
                .build());
        return new ResponseDeviceCreate[][]{{createdDevice}};
    }

    @DataProvider
    public Object[] getCreatedDifferentType() {
        RequestDeviceCreate[] deviceCreates = new RequestDeviceCreate[14];
        for (int i = 0; i <= 13; i++) {
            Object[] requestDeviceCreate = getRequestBodyToCreateDevice();

            deviceCreates[i] = getRequestBodyToCreateDevice()
        }
        return new RequestDeviceCreate[]{
        };
    }
//
//    @DataProvider
//    public Object[][] getDataToMoveDevice() {
//        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(RequestDeviceCreate.builder()
//                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
//                .address("127.0.0.5")
//                .locationName(DEFAULT_LOCATION)
//                .name("ExampleDevice")
//                .type(0L)
//                .build());
//
//        List<SearchCriteria> moveDevice = new ArrayList<>();
//
//        moveDevice.add(models.api.movedevice.SearchCriteria
//                .builder()
//                .searchOption("DEVICE_SERIAL_NUMBER")
//                .searchTerms(createdDevice.getResult().getDevice().getSerialNumber())
//                .build());
//
//        return new Object[][]{{createdDevice
//                , RequestDeviceMove
//                .builder()
//                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
//                .searchCriterias(moveDevice)
//                .build()
//        }};
//    }
//
//    @DataProvider
//    public static Object[] getDataToUpdateDevice() {
//
//        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(RequestDeviceCreate.builder()
//                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
//                .address("127.0.0.5")
//                .locationName(DEFAULT_LOCATION)
//                .name("ExampleDevice")
//                .type(0L)
//                .build());
//
//        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<>();
//        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
//                .builder()
//                .propertyName("SUSPEND")
//                .propertyValue("true")
//                .build());
//        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
//                .builder()
//                .propertyName("DEVICE_NAME")
//                .propertyValue("ExampleDevice")
//                .build());
//        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
//                .builder()
//                .propertyName("DEVICE_TYPE")
//                .propertyValue("0")
//                .build());
//        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
//                .builder()
//                .propertyName("ADDRESS")
//                .propertyValue("127.0.0.5")
//                .build());
//        deviceUpdateProperties.add(models.api.updatedevice.DeviceUpdateProperty
//                .builder()
//                .propertyName("DO_NOT_RESOLVE_ADDRESS")
//                .propertyValue("false")
//                .build());
//
//        return new Object[][]{{createdDevice,
//                RequestDeviceUpdate
//                        .builder()
//                        .deviceUpdateProperties(deviceUpdateProperties)
//                        .build()}};
//    }


}
