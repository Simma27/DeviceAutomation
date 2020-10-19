import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.SearchCriteria;
import models.api.updatedevice.DeviceUpdateProperty;
import models.api.updatedevice.RequestDeviceUpdate;
import org.apache.commons.lang3.RandomStringUtils;
import services.DeviceService;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static config.DeviceConfig.ACCOUNT_SERIAL_NUMBER;
import static config.DeviceConfig.DEFAULT_LOCATION;
import static config.UpdateDeviceConfig.*;

public class DeviceDataProvider {

    static DeviceService deviceService = new DeviceService();

    @DataProvider
    public Object[] getRequestBodyToCreateDevice() {
        return new Object[]{getRequestParameterDevice()};
    }

    @DataProvider
    public Object[][] getResponseCreatedDevice() {
        ResponseDeviceCreate createdDevice = deviceService.createDevice(getRequestParameterDevice());
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
    public Object[] getRequestsToDeleteDeviceDifferentType() {

        RequestDeviceDelete[] deviceDeletes = new RequestDeviceDelete[14];
        ResponseDeviceCreate[] deviceCreates = new ResponseDeviceCreate[14];

        for (int i = 0; i < 14; i++) {
            RequestDeviceCreate requestDeviceCreate = getRequestParameterDevice();
            requestDeviceCreate.setType(i);
            deviceCreates[i] = deviceService.createDevice(requestDeviceCreate);
            models.api.deletedevice.SearchCriteria searchCriteria = models.api.deletedevice.SearchCriteria
                    .builder()
                    .searchOption(DEVICE_SERIAL_NUMBER)
                    .searchTerms(deviceCreates[i].getResult().getDevice().getSerialNumber())
                    .build();
            deviceDeletes[i] = RequestDeviceDelete
                    .builder()
                    .serialNumber(deviceCreates[i].getResult().getDevice().getSerialNumber())
                    .searchCriterias(new ArrayList<>(Collections.singletonList(searchCriteria)))
                    .build();
        }
        return deviceDeletes;
    }

    @DataProvider
    public Object[] getDataToUpdateDevices() {

        RequestDeviceUpdate[] requestDeviceUpdates = new RequestDeviceUpdate[4];

        requestDeviceUpdates[0] = RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(new ArrayList<>(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(DEVICE_NAME)
                        .propertyValue("Example")
                        .build())))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build();
        requestDeviceUpdates[1] = RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(new ArrayList<>(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(DEVICE_TYPE)
                        .propertyValue("2")
                        .build())))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build();
        requestDeviceUpdates[2] = RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(new ArrayList<>(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(ADDRESS)
                        .propertyValue("127.0.0.1")
                        .build())))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build();
        requestDeviceUpdates[3] = RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(new ArrayList<>(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(COMMENT)
                        .propertyValue("Example")
                        .build())))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build();

        return requestDeviceUpdates;
    }

    @DataProvider
    public  Object[][] getDataToMoveDevice() {

        ResponseDeviceCreate createdDevice = deviceService.createDevice(getRequestParameterDevice());

        List<SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(SearchCriteria
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

    public synchronized static RequestDeviceCreate getRequestParameterDevice() {
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
                .vendor("Example")
                .build();
    }

    public static ResponseDeviceCreate getResponseCreatedDevices() {
        return deviceService.createDevice(getRequestParameterDevice());
    }

        @DataProvider
        public Object[] getDataToUpdateDevice() {

            ResponseDeviceCreate createdDevice = deviceService.createDevice(getRequestParameterDevice());

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

}
