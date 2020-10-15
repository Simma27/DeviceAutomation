import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.ResponseDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.ResponseDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import models.api.updatedevice.ResponseDeviceUpdate;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.DeviceService;

public class DeviceTestAPI {

    DeviceService deviceService = new DeviceService();

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        Assert.assertEquals(createdDevice.getResult().getMessage(), "New NetworkDevice has been created with Serial Number: "
                        + createdDevice.getResult().getDevice().getSerialNumber(), "Device is not created");
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceDifferentType(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        Assert.assertNotNull(createdDevice, "Device is not created!");
        Assert.assertFalse(createdDevice.getResult().getDevice().getDeviceTypeStr().equalsIgnoreCase("INVALID"), "Non-existent device type");
        Assert.assertEquals(requestBody.getType(), createdDevice.getResult().getDevice().getDeviceType(), "The types of the request parameter \"DeviceType\" and the created Device type do not match");

        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceTwiceTest(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate similarDeviceOne = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceCreate similarDeviceTwo = deviceService.createDeviceNegativ(requestBody);
        Assert.assertEquals(similarDeviceTwo.getErrorCode(), -100.0, "Error code is not -100");
        Assert.assertEquals(similarDeviceTwo.getErrorMessage(), "Unable to create network device: You already have a device named ExampleDevice", "Unexpected error message, Error message: " + similarDeviceTwo.getErrorMessage());
        Assert.assertNull(similarDeviceTwo.getResult().getDevice(), "There is a device that should not be");
        Assert.assertNull(similarDeviceTwo.getResult().getMessage(), "There is a message that should not be");
        deviceService.deleteDevicePositiv(similarDeviceOne.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getRequestBodyToCreateDevice", dataProviderClass = DeviceDataProvider.class)
    public void createDeviceWithoutName(RequestDeviceCreate requestBody) {
        requestBody.setName(null);
        ResponseDeviceCreate createdDevice = deviceService.createDeviceNegativ(requestBody);
        Assert.assertEquals(createdDevice.getErrorCode(), -100.0, "Error code is not -100");
        Assert.assertEquals(createdDevice.getErrorMessage(), "Unable to create network device: Please make sure that all the mandatory properties have been provided! ( type, name, address, locationName)"
                , "Unexpected error message, Error message: " + createdDevice.getErrorMessage());
        Assert.assertNull(createdDevice.getResult().getDevice(), "There is a device that should not be");
        Assert.assertNull(createdDevice.getResult().getMessage(), "Unexpected message, Error message: " + createdDevice.getErrorMessage());
    }

    @Test(dataProvider = "getResponseCreatedDevice", dataProviderClass = DeviceDataProvider.class)
    public void deleteDevice(ResponseDeviceCreate responseDeviceCreate) {
        ResponseDeviceDelete responseDeleteDevice = deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ", "Unexpected  message, Error message: " + responseDeleteDevice.getErrorMessage());
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = DeviceDataProvider.class)
    public void deleteDifferentDevice(RequestDeviceCreate requestBody) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceDelete responseDeleteDevice = deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(),"Successful! Total 1 devices have been deleted. "
                ,"Unexpected message, Error message: " + responseDeleteDevice.getErrorMessage());
    }

    @Test
    public void deleteWithoutRequestBody() {
        ResponseDeviceDelete responseDeleteDevice = deviceService.deleteDevice(new Object());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -1.0, "Error code is not -1, Error code: " + responseDeleteDevice.getErrorCode());
        Assert.assertTrue(responseDeleteDevice.getErrorMessage().toString().contains("serialNumber=<null>,searchCriterias=<null>,modelSessionManager=<null>,username=<null>,password=<null>"));
        Assert.assertNull(responseDeleteDevice.getResult(), "There is a Result that should not be");
    }

    @Test(dataProvider = "getResponseCreatedDevice", dataProviderClass = DeviceDataProvider.class)
    public void deleteSimilarDeviceTwiceTest(ResponseDeviceCreate responseDeviceCreate) {
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
        ResponseDeviceDelete responseDeleteDevice = deviceService.deleteDeviceNegativ(responseDeviceCreate.getResult().getDevice().getSerialNumber());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -4.0, "Error code is not -1, Error code: " + responseDeleteDevice.getErrorCode());
        Assert.assertEquals(responseDeleteDevice.getErrorMessage(),"No devices matched the search criterias"
                ,"Unexpected error message, Error message: " + responseDeleteDevice.getErrorMessage());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Failed"
                ,"Unexpected message, Error message: " + responseDeleteDevice.getErrorMessage());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDevice(RequestDeviceCreate requestBody, RequestDeviceUpdate updateDevice) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDevicePositiv(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully"
                ,"Unexpected message, Error message: " + responseUpdateDevice.getErrorMessage());
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceAddCommentTest(RequestDeviceCreate requestBody, RequestDeviceUpdate updateDevice) {
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDevicePositiv(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(),"Updated successfully"
                ,"Unexpected message, Error message: " + responseUpdateDevice.getErrorMessage());
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }


    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutChanges(RequestDeviceCreate requestBody, RequestDeviceUpdate updateDevice) {
        updateDevice.setDeviceUpdateProperties(null);
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDeviceNegativ(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getErrorCode(), -412.0, "Error code is not -412, Error code: " + responseUpdateDevice.getErrorCode());
        Assert.assertEquals(responseUpdateDevice.getErrorMessage(), "Specify at least one parameter to be modified", "Unexpected error message, Error message: " + responseUpdateDevice.getErrorMessage());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(),"Failed"
                ,"Unexpected message, Error message: " + responseUpdateDevice.getErrorMessage());
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = DeviceDataProvider.class)
    public void updateDeviceWithoutSerialNumber(RequestDeviceCreate requestBody, RequestDeviceUpdate updateDevice) {
        updateDevice.setSerialNumber(null);
        ResponseDeviceCreate createdDevice = deviceService.createDevicePositiv(requestBody);
        ResponseDeviceUpdate responseUpdateDevice = deviceService.updateDevicePositiv(updateDevice);
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(),"Updated successfully"
                ,"Unexpected message, Error message: " + responseUpdateDevice.getErrorMessage());
        deviceService.deleteDevicePositiv(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        ResponseDeviceMove responseMoveDevice = deviceService.moveDevicePositiv(moveDevice);
        Assert.assertEquals(responseMoveDevice.getResult().getMessage(),"Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. Total 1 device(s) has(have) been ignored due to same department violation."
                ,"Unexpected message, Error message: " + responseMoveDevice.getErrorMessage());
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutSearchCriteriaTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        moveDevice.setSearchCriterias(null);
        ResponseDeviceMove responseMoveDevice = deviceService.moveDeviceNegativ(moveDevice);
        Assert.assertEquals((responseMoveDevice.getErrorCode()),(-412.0)
                ,"Error code is not -412, Error code: " + responseMoveDevice.getErrorCode());
        Assert.assertEquals(responseMoveDevice.getErrorMessage(),"Search criterias can not be null."
                ,"Unexpected error message, Error message: " + responseMoveDevice.getErrorMessage());
        Assert.assertNull(responseMoveDevice.getResult().getMessage(), "There is a message that should not be");
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToMoveDevice", dataProviderClass = DeviceDataProvider.class)
    public void moveDeviceWithoutDepartmentTest(ResponseDeviceCreate responseDeviceCreate, RequestDeviceMove moveDevice) {
        moveDevice.setAccountSerialNumber(null);
        ResponseDeviceMove responseMoveDevice = deviceService.moveDeviceNegativ(moveDevice);
        Assert.assertEquals(responseMoveDevice.getErrorCode(), -412.0
                ,"Error code is not -412, Error code: " + responseMoveDevice.getErrorCode());
        Assert.assertEquals(responseMoveDevice.getErrorMessage(),"Destination account serial number is mandatory to be provided."
                ,"Unexpected error message, Error message: " + responseMoveDevice.getErrorMessage());
        Assert.assertNull(responseMoveDevice.getResult().getMessage(), "There is a message that should not be");
        deviceService.deleteDevicePositiv(responseDeviceCreate.getResult().getDevice().getSerialNumber());
    }
}