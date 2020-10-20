import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.EmptyRequest;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.deletedevice.SearchCriteria;
import models.api.movedevice.RequestDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import services.DeviceService;
import config.DeviceType;
import models.api.specification.Specification;

import java.util.Collections;

import static config.ApiDeviceConfig.*;
import static config.UpdateDeviceConfig.DEVICE_SERIAL_NUMBER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class DeviceTestAPI {
    
    private static final String PREFIX = "result.device.";
    
    DeviceService deviceService = new DeviceService();

    @Test(dataProvider = "getRequestBodyToCreateDeviceDifferentTypes", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTest(RequestDeviceCreate requestBody) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .body(PREFIX + "accountSerialNumber", equalTo(requestBody.getAccountSerialNumber()))
                .body(PREFIX + "clearOnOk", equalTo(requestBody.isClearOnOk()))
                .body(PREFIX + "configBackupEnabled", equalTo(requestBody.isConfigBackupEnabled()))
                .body(PREFIX + "deviceAddress", equalTo(requestBody.getAddress()))
                .body(PREFIX + "deviceName", equalTo(requestBody.getName()))
                .body(PREFIX + "deviceType", equalTo(requestBody.getType()))
                .body(PREFIX + "deviceTypeStr", equalTo(DeviceType.find(requestBody.getType())))
                .body(PREFIX + "flapPreventionWaitCycles", equalTo(requestBody.getFlapPreventionWaitCycles()))
                .body(PREFIX + "locationName", equalTo(requestBody.getLocationName()))
                .body(PREFIX + "model", equalTo(requestBody.getModel()))
                .body(PREFIX + "showOnSummary", equalTo(requestBody.isShowOnSummary()))
                .body(PREFIX + "smartNotify", equalTo(requestBody.isSmartNotify()))
                .body(PREFIX + "tag1", equalTo(requestBody.getTag1()))
                .body(PREFIX + "tag2", equalTo(requestBody.getTag2()))
                .body(PREFIX + "tag3", equalTo(requestBody.getTag3()))
                .body(PREFIX + "tag4", equalTo(requestBody.getTag4()))
                .body(PREFIX + "tag5", equalTo(requestBody.getTag5()))
                .body(PREFIX + "vendor", equalTo(requestBody.getVendor()))
                .extract()
                .as(ResponseDeviceCreate.class);
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTwiceTest(RequestDeviceCreate requestBody) {
        deviceService.createDevice(requestBody);
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-100))
                .body("errorMessage", equalTo("Unable to create network device: You already have a device named " + requestBody.getName()))
                .body("result.device", equalTo(null))
                .body("result.message", equalTo(null));
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceWithoutNameTest(RequestDeviceCreate requestBody) {
        requestBody.setName(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-100))
                .body("errorMessage", equalTo("Unable to create network device: Please make sure that all the mandatory properties have been provided! ( type, name, address, locationName)"))
                .body("result.device", equalTo(null))
                .body("result.message", equalTo(null));
    }

    @Test(dataProvider = "getRequestsToDeleteDeviceDifferentType", dataProviderClass = DeviceDataProvider.class)
    public void deleteDeviceTest(RequestDeviceDelete requestDeviceDelete) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestDeviceDelete)
                .post(DELETE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Successful! Total 1 devices have been deleted. "));
    }

    @Test
    public void deleteWithoutRequestBodyTest() {
        given()
                .spec(Specification.getRequestSpecification())
                .body(new EmptyRequest())
                .post(DELETE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-1))
                .body("errorMessage", containsString("serialNumber=<null>,searchCriterias=<null>,modelSessionManager=<null>,username=<null>,password=<null>"))
                .body("result", equalTo(null));
    }

    @Test(dataProvider = "getResponseCreatedDevice", dataProviderClass = DeviceDataProvider.class)
    public void deleteSimilarDeviceTwiceTest(ResponseDeviceCreate responseDeviceCreate) {
        deviceService.deleteDevice(responseDeviceCreate.getResult().getDevice().getSerialNumber());
        given()
                .spec(Specification.getRequestSpecification())
                .body(RequestDeviceDelete.builder()
                        .serialNumber(responseDeviceCreate.getResult().getDevice().getSerialNumber())
                        .searchCriterias(Collections.singletonList(SearchCriteria
                                .builder()
                                .searchOption(DEVICE_SERIAL_NUMBER.name())
                                .searchTerms(responseDeviceCreate.getResult().getDevice().getSerialNumber())
                                .build()))
                        .build())
                .post(DELETE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-4))
                .body("errorMessage", equalTo("No devices matched the search criterias"))
                .body("result.message", equalTo("Failed"));
    }

    @Test(dataProvider = "getDataToUpdateDevices", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceTest(RequestDeviceUpdate updateDevice) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Updated successfully"));
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutChangesTest(RequestDeviceUpdate updateDevice) {
        updateDevice.setDeviceUpdateProperties(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Specify at least one parameter to be modified"))
                .body("result.message", equalTo("Failed"));
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutSerialNumberTest(RequestDeviceUpdate updateDevice) {
        updateDevice.setSerialNumber(0);
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Updated successfully"));
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceTest(RequestDeviceMove moveDevice) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. " +
                        "Total 1 device(s) has(have) been ignored due to same department violation."));
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutSearchCriteriaTest(RequestDeviceMove moveDevice) {
        moveDevice.setSearchCriterias(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Search criterias can not be null."))
                .body("result.message", equalTo(null));
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutDepartmentTest(RequestDeviceMove moveDevice) {
        moveDevice.setAccountSerialNumber(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Destination account serial number is mandatory to be provided."))
                .body("result.message", equalTo(null));
    }

    @AfterSuite
    public void cleanDevice() {deviceService.deleteDevice(RequestDeviceDelete.builder().build());}

}