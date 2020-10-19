import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import org.testng.annotations.Test;
import services.DeviceService;
import models.DeviceType;
import models.api.specification.Specification;

import static config.ApiDeviceConfig.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class DeviceTestAPI {
    private static final String prefix = "result.device.";
    DeviceService deviceService = new DeviceService();

    @Test(dataProvider = "getRequestBodyToCreateDeviceDifferentTypes", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate createdDevice = given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .body(prefix + "accountSerialNumber", equalTo(requestBody.getAccountSerialNumber()))
                .body(prefix + "clearOnOk", equalTo(requestBody.isClearOnOk()))
                .body(prefix + "configBackupEnabled", equalTo(requestBody.isConfigBackupEnabled()))
                .body(prefix + "deviceAddress", equalTo(requestBody.getAddress()))
                .body(prefix + "deviceName", equalTo(requestBody.getName()))
                .body(prefix + "deviceType", equalTo(requestBody.getType()))
                .body(prefix + "deviceTypeStr", equalTo(DeviceType.getDeviceTypeStr(requestBody.getType())))
                .body(prefix + "flapPreventionWaitCycles", equalTo(requestBody.getFlapPreventionWaitCycles()))
                .body(prefix + "locationName", equalTo(requestBody.getLocationName()))
                .body(prefix + "model", equalTo(requestBody.getModel()))
                .body(prefix + "showOnSummary", equalTo(requestBody.isShowOnSummary()))
                .body(prefix + "smartNotify", equalTo(requestBody.isSmartNotify()))
                .body(prefix + "tag1", equalTo(requestBody.getTag1()))
                .body(prefix + "tag2", equalTo(requestBody.getTag2()))
                .body(prefix + "tag3", equalTo(requestBody.getTag3()))
                .body(prefix + "tag4", equalTo(requestBody.getTag4()))
                .body(prefix + "tag5", equalTo(requestBody.getTag5()))
                .body(prefix + "vendor", equalTo(requestBody.getVendor()))
                .extract()
                .as(ResponseDeviceCreate.class);
        deviceService.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTwiceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate DeviceOne = deviceService.createDevice(requestBody);
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-100))
                .body("errorMessage", containsString("Unable to create network device: You already have a device named " + requestBody.getName()))
                .body("result.device", equalTo(null))
                .body("result.message", equalTo(null));
        deviceService.deleteDevice(DeviceOne.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceWithoutNameTest(RequestDeviceCreate requestBody) {
        requestBody.setName(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-100))
                .body("errorMessage", containsString("Unable to create network device: Please make sure that all the mandatory properties have been provided! ( type, name, address, locationName)"))
                .body("result.device", equalTo(null))
                .body("result.message", equalTo(null));
    }

    @Test(dataProvider = "getRequestsToDeleteDeviceDifferentType", dataProviderClass = DeviceDataProvider.class)
    public void deleteDeviceTest(RequestDeviceDelete requestDeviceDelete){
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestDeviceDelete)
                .post(DELETE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Successful! Total 1 devices have been deleted. "));
    }

    @Test
    public void deleteWithoutRequestBodyTest() {
        given()
                .spec(Specification.getRequestSpecification())
                .body(new Object())
                .post(DELETE_DEVICE)
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
                        .build())
                .post(DELETE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-4))
                .body("errorMessage", containsString("No devices matched the search criterias"))
                .body("result.message", equalTo("Failed"));
    }

    @Test(dataProvider = "getDataToUpdateDevices", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceTest(RequestDeviceUpdate updateDevice) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Updated successfully"));
        deviceService.deleteDevice(updateDevice.getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutChangesTest(ResponseDeviceCreate createdDevice, RequestDeviceUpdate updateDevice) {
        updateDevice.setDeviceUpdateProperties(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Specify at least one parameter to be modified"))
                .body("result.message", equalTo("Failed"));
        deviceService.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutSerialNumberTest(ResponseDeviceCreate createdDevice, RequestDeviceUpdate updateDevice) {
        updateDevice.setSerialNumber(0);
        given()
                .spec(Specification.getRequestSpecification())
                .body(updateDevice)
                .post(UPDATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Updated successfully"));
        deviceService.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .body("result.message", equalTo("Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. " +
                        "Total 1 device(s) has(have) been ignored due to same department violation."));
        deviceService.deleteDevice(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutSearchCriteriaTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        moveDevice.setSearchCriterias(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Search criterias can not be null."))
                .body("result.message", equalTo(null));
        deviceService.deleteDevice(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutDepartmentTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        moveDevice.setAccountSerialNumber(null);
        System.out.println(moveDevice.getSearchCriterias());
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Destination account serial number is mandatory to be provided."))
                .body("result.message", equalTo(null));
        deviceService.deleteDevice(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

}