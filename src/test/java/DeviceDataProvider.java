
import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.SearchCriteria;
import models.api.updatedevice.DeviceUpdateProperty;
import models.api.updatedevice.RequestDeviceUpdate;
import org.apache.commons.lang3.RandomStringUtils;
import services.DeviceService;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static config.DeviceConfig.ACCOUNT_SERIAL_NUMBER;
import static config.DeviceConfig.DEFAULT_LOCATION;

public class DeviceDataProvider {

    static DeviceService deviceService = new DeviceService();

    @DataProvider
    public Object[] getRequestBodyToCreateDevice() {
        return new Object[]{getRequestParameterDevice()};
    }

    @DataProvider
    public Object[][] getResponseCreatedDevice() {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(getRequestParameterDevice());
        return new ResponseDeviceCreate[][]{{createdDevice}};
    }

    @DataProvider
    public Object[] getRequestBodyToCreateDeviceDifferentTypes() {
        RequestDeviceCreate[] deviceCreates = new RequestDeviceCreate[14];
        for (int i = 0; i < 14; i++) {
            RequestDeviceCreate requestDeviceCreate = getRequestParameterDevice();
            requestDeviceCreate.setType(i);
            deviceCreates[i] = requestDeviceCreate;
        }
        return deviceCreates;
    }

    @DataProvider
    public Object[] getDataToUpdateDevice() {

        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(getRequestParameterDevice());

        List<DeviceUpdateProperty> deviceUpdateProperties = new ArrayList<>();

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

        return new Object[][]{{createdDevice, RequestDeviceUpdate
                .builder()
                .serialNumber(createdDevice.getResult().getDevice().getSerialNumber())
                .deviceUpdateProperties(deviceUpdateProperties)
                .build()}};
    }

    @DataProvider
    public Object[] getDataToUpdateDevices() {

        List<DeviceUpdateProperty> deviceUpdateDEVICE_NAME = new ArrayList<>();
        List<DeviceUpdateProperty> deviceUpdateDEVICE_TYPE = new ArrayList<>();
        List<DeviceUpdateProperty> deviceUpdateADDRESS = new ArrayList<>();
        List<DeviceUpdateProperty> deviceUpdateDO_NOT_RESOLVE_ADDRESS = new ArrayList<>();

        deviceUpdateDEVICE_NAME.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_NAME")
                .propertyValue("ExampleDevice")
                .build());
        deviceUpdateDEVICE_TYPE.add(DeviceUpdateProperty
                .builder()
                .propertyName("DEVICE_TYPE")
                .propertyValue("0")
                .build());
        deviceUpdateADDRESS.add(DeviceUpdateProperty
                .builder()
                .propertyName("ADDRESS")
                .propertyValue("127.0.0.5")
                .build());
        deviceUpdateDO_NOT_RESOLVE_ADDRESS.add(DeviceUpdateProperty
                .builder()
                .propertyName("DO_NOT_RESOLVE_ADDRESS")
                .propertyValue("false")
                .build());

        return new Object[][]{{RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(deviceUpdateDEVICE_NAME)
                .build()}, {RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(deviceUpdateDEVICE_TYPE)
                .build() } , {RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(deviceUpdateADDRESS)
                .build() }, {RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(deviceUpdateDO_NOT_RESOLVE_ADDRESS)
                .build() }};
    }

    @DataProvider
    public Object[][] getDataToMoveDevice() {

        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(getRequestParameterDevice());

        List<SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(models.api.movedevice.SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(createdDevice.getResult().getDevice().getSerialNumber())
                .build());

        return new Object[][]{{createdDevice
                , RequestDeviceMove
                .builder()
                .newDeviceName(RandomStringUtils.randomAlphabetic(8))
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(moveDevice)
                .build()
        }};
    }

    public static synchronized RequestDeviceCreate getRequestParameterDevice() {
        return RequestDeviceCreate.builder()
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address((int) (Math.random() * 255) + "." + (int) (Math.random() * 255) + "." + (int) (Math.random() * 255) + "." + (int) (Math.random() * 255))
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
                .build();
    }

//    public static ResponseDeviceCreate[] getCreatedDeviceDifferentType() {
//        ResponseDeviceCreate[] deviceCreates = new ResponseDeviceCreate[14];
//        for (int i = 0; i < 14; i++) {
//            RequestDeviceCreate requestDeviceCreate = getRequestParameterDevice();
//            requestDeviceCreate.setType(i);
//            deviceCreates[i] = deviceService.createDevicePositiv(requestDeviceCreate);
//        }
//        return deviceCreates;
//    }

//        @DataProvider
//    public Object[] getCreatedDeviceDifferentTypes() {
//        return getCreatedDeviceDifferentType();
//    }
//

    public static ResponseDeviceCreate getResponseCreatedDevices() {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(getRequestParameterDevice());
        return createdDevice;
    }


}
