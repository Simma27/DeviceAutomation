import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.deletedevice.ResponseDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.ResponseDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import models.api.updatedevice.ResponseDeviceUpdate;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.DeviceService;
import services.DeviceType;
import services.Specification;

import static config.ApiDeviceConfig.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class DeviceTestAPI {

    DeviceService deviceService = new DeviceService();

    @Test(dataProvider = "getRequestBodyToCreateDeviceDifferentType", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        Assert.assertEquals(createdDevice.getResult().getMessage(),"New NetworkDevice has been created with Serial Number: "
                        + createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertEquals(requestBody.getAccountSerialNumber(),createdDevice.getResult().getDevice().getAccountSerialNumber());
        Assert.assertEquals(requestBody.getAddress(), createdDevice.getResult().getDevice().getDeviceAddress());
        Assert.assertEquals(requestBody.getComment(), createdDevice.getResult().getDevice().getComment());
        Assert.assertEquals(requestBody.getFlapPreventionWaitCycles(), createdDevice.getResult().getDevice().getFlapPreventionWaitCycles());
        Assert.assertEquals(requestBody.getLocationName(), createdDevice.getResult().getDevice().getLocationName());
        Assert.assertEquals(requestBody.getModel(), createdDevice.getResult().getDevice().getModel());
        Assert.assertEquals(requestBody.getName(), createdDevice.getResult().getDevice().getDeviceName());
        Assert.assertEquals(requestBody.getTag1(), createdDevice.getResult().getDevice().getTag1());
        Assert.assertEquals(requestBody.getTag2(), createdDevice.getResult().getDevice().getTag2());
        Assert.assertEquals(requestBody.getTag3(), createdDevice.getResult().getDevice().getTag3());
        Assert.assertEquals(requestBody.getTag4(), createdDevice.getResult().getDevice().getTag4());
        Assert.assertEquals(requestBody.getTag5(), createdDevice.getResult().getDevice().getTag5());
        Assert.assertEquals(requestBody.getType(), createdDevice.getResult().getDevice().getDeviceType());
        Assert.assertEquals(DeviceType.getDeviceTypeStr(requestBody.getType()), createdDevice.getResult().getDevice().getDeviceTypeStr());
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTwiceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate DeviceOne = deviceService.createDevicePositiv(requestBody);
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
        deviceService.deleteDevicePositiv(DeviceOne.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceWithoutName(RequestDeviceCreate requestBody) {
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

    @Test(dataProvider = "getResponseCreatedDevice", dataProviderClass = DeviceDataProvider.class)
    public void deleteDevice(ResponseDeviceCreate createdDevice) {
//        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceDelete responseDeleteDevice = deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage()
                ,"Successful! Total 1 devices have been deleted. ");
    }

    @Test
    public void deleteWithoutRequestBody() {
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
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
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

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDevice(ResponseDeviceCreate createdDevice, RequestDeviceUpdate updateDevice) {
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDevicePositiv(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutChanges(ResponseDeviceCreate createdDevice, RequestDeviceUpdate updateDevice) {
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
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutSerialNumber(ResponseDeviceCreate createdDevice, RequestDeviceUpdate updateDevice) {
        updateDevice.setSerialNumber(0);
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDevicePositiv(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(),"Updated successfully");
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        ResponseDeviceMove responseMoveDevice = deviceService.moveDevicePositiv(moveDevice);
        Assert.assertEquals(responseMoveDevice.getResult().getMessage()
                ,"Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. " +
                        "Total 1 device(s) has(have) been ignored due to same department violation.");
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
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
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutDepartment(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        moveDevice.setAccountSerialNumber(null);
        given()
                .spec(Specification.getRequestSpecification())
                .body(moveDevice)
                .post(MOVE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecificationNegativ())
                .body("errorCode", equalTo(-412))
                .body("errorMessage", equalTo("Destination account serial number is mandatory to be provided."))
                .body("result.message", equalTo(null));
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

}