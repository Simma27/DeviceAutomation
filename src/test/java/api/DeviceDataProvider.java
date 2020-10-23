package api;

import io.qameta.allure.Step;
import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.updatedevice.DeviceUpdateProperty;
import models.api.updatedevice.RequestDeviceUpdate;
import models.api.updatedevice.SearchCriteria;
import org.apache.commons.lang3.RandomStringUtils;
import services.DeviceService;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Collections;

import static config.DeviceConfig.ACCOUNT_SERIAL_NUMBER;
import static config.DeviceConfig.DEFAULT_LOCATION;
import static config.UpdateDeviceConfig.*;

public class DeviceDataProvider {

    static DeviceService deviceService = new DeviceService();

    @DataProvider
    @Step("Get request body to create device")
    public synchronized Object[] getRequestBodyToCreateDevice() {
        return new Object[]{getRequestParameterDevice()};
    }

    @DataProvider
    @Step("Get response body created device")
    public Object[] getResponseCreatedDevice() {
        return new ResponseDeviceCreate[]{deviceService.createDevice(getRequestParameterDevice())};
    }

    @DataProvider
    @Step("Get request body to create device different type")
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
    @Step("Get request body to delete device different type")
    public Object[] getRequestsToDeleteDeviceDifferentType() {

        RequestDeviceDelete[] deviceDeletes = new RequestDeviceDelete[14];

        for (int i = 0; i < 14; i++) {
            RequestDeviceCreate requestDeviceCreate = getRequestParameterDevice();
            requestDeviceCreate.setType(i);
            ResponseDeviceCreate responseDeviceCreate = deviceService.createDevice(requestDeviceCreate);
            SearchCriteria searchCriteria = SearchCriteria
                    .builder()
                    .searchOption(DEVICE_SERIAL_NUMBER.name())
                    .searchTerms(responseDeviceCreate.getResult().getDevice().getSerialNumber())
                    .build();
            deviceDeletes[i] = RequestDeviceDelete
                    .builder()
                    .searchCriterias(Collections.singletonList(searchCriteria))
                    .build();
        }
        return deviceDeletes;
    }

    @DataProvider
    public Object[] getDataToUpdateDevices() {
        return new Object[] {
                RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(DEVICE_NAME.name())
                        .propertyValue("Example")
                        .build()))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build(),
                RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(DEVICE_TYPE.name())
                        .propertyValue("2")
                        .build()))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build(),
                RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(ADDRESS.name())
                        .propertyValue("127.0.0.1")
                        .build()))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build(),
                RequestDeviceUpdate
                .builder()
                .deviceUpdateProperties(Collections.singletonList(DeviceUpdateProperty
                        .builder()
                        .propertyName(COMMENT.name())
                        .propertyValue("Example")
                        .build()))
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .build()};
    }

    @DataProvider
    public synchronized Object[] getDataToUpdateDevice() {
        return new Object[]{RequestDeviceUpdate
                .builder()
                .serialNumber(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                .deviceUpdateProperties(Arrays.asList(
                        DeviceUpdateProperty
                    .builder()
                    .propertyName("DEVICE_NAME")
                    .propertyValue("ExampleDevice")
                    .build(),
                        DeviceUpdateProperty
                    .builder()
                    .propertyName("DEVICE_TYPE")
                    .propertyValue("0")
                    .build(),
                        DeviceUpdateProperty
                    .builder()
                    .propertyName("ADDRESS")
                    .propertyValue("127.0.0.5")
                    .build(),
                        DeviceUpdateProperty
                    .builder()
                    .propertyName("DO_NOT_RESOLVE_ADDRESS")
                    .propertyValue("false")
                    .build()))
                .build()};
    }


    @DataProvider
    public synchronized Object[] getDataToMoveDevice() {
        return new RequestDeviceMove[]{RequestDeviceMove
                .builder()
                .newDeviceName(RandomStringUtils.randomAlphabetic(8))
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(Collections.singletonList(SearchCriteria
                        .builder()
                        .searchOption("DEVICE_SERIAL_NUMBER")
                        .searchTerms(getResponseCreatedDevices().getResult().getDevice().getSerialNumber())
                        .build()))
                .build()
        };
    }
    @Step("Create response created device")
    private synchronized static ResponseDeviceCreate getResponseCreatedDevices() {
        return deviceService.createDevice(getRequestParameterDevice());
    }
    @Step("Create device different type with request")
    private synchronized static RequestDeviceCreate getRequestParameterDevice() {
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
}
