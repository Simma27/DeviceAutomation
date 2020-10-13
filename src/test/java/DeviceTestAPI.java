import models.api.Device;
import models.api.SearchCriteria;
import org.testng.Assert;
import org.testng.annotations.Test;
import Impl.Service;

import java.util.ArrayList;
import java.util.List;

import static config.DeviceConfig.*;

public class DeviceTestAPI {

    Service service = new Service();

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTest(Device newDevice) {

        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        Assert.assertTrue(createdDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(createdDevice.getErrorCode(), "Have error number: " + createdDevice.getErrorCode());
        Assert.assertNull(createdDevice.getErrorMessage(), "Have error message: " + createdDevice.getErrorMessage());
        Assert.assertNotNull(createdDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(createdDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(createdDevice.getResult().getMessage()
                , "New NetworkDevice has been created with Serial Number: "
                        + createdDevice.getResult().getDevice().getSerialNumber(), "Device is not created");
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceDifferentType(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        System.out.println(createdDevice.toString());
        Assert.assertTrue(createdDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(createdDevice.getErrorCode(), "Have error number: " + createdDevice.getErrorCode());
        Assert.assertNull(createdDevice.getErrorMessage(), "Have error message: " + createdDevice.getErrorMessage());
        Assert.assertNotNull(createdDevice, "Device is not created!");
        Assert.assertNotNull(createdDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(createdDevice.getTimestampStr(), "Error, time is null");
        Assert.assertFalse(createdDevice.getResult().getDevice().getDeviceTypeStr().equalsIgnoreCase("INVALID"), "Non-existent device type");
        Assert.assertEquals(newDevice.getType(), createdDevice.getResult().getDevice().getDeviceType(), "The types of the request parameter \"DeviceType\" and the created Device type do not match");
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTwiceTest(Device newDevice) {
        Device similarDeviceOne = service.createDevice(newDevice);
        Device similarDeviceTwo = service.createDevice(newDevice);
        assert similarDeviceTwo != null;
        Assert.assertFalse(similarDeviceTwo.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(similarDeviceTwo.getErrorCode(), -100.0, "Error code is not -100");
        Assert.assertNotNull(similarDeviceTwo.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(similarDeviceTwo.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(similarDeviceTwo.getErrorMessage(), "Unable to create network device: You already have a device named ExampleDevice");
        Assert.assertNull(similarDeviceTwo.getResult().getDevice(), "There is a device that should not be");
        Assert.assertNull(similarDeviceTwo.getResult().getMessage(), "There is a message that should not be");
        assert similarDeviceOne != null;
        service.deleteDevice(similarDeviceOne.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceWithoutName(Device newDevice) {
        newDevice.setName(null);
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        Assert.assertFalse(createdDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(createdDevice.getErrorCode(), -100.0, "Error code is not -100");
        Assert.assertEquals(createdDevice.getErrorMessage(), "Unable to create network device: Please make sure that all the mandatory properties have been provided! ( type, name, address, locationName)");
        Assert.assertNotNull(createdDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(createdDevice.getTimestampStr(), "Error, time is null");
        Assert.assertNull(createdDevice.getResult().getDevice(), "There is a device that should not be");
        Assert.assertNull(createdDevice.getResult().getMessage(), "There is a message that should not be");
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void deleteDevice(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        Device responseDeleteDevice = service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertTrue(responseDeleteDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseDeleteDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseDeleteDevice.getErrorMessage(), "There is a ErrorMessage that should not be");
        Assert.assertNotNull(responseDeleteDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = CustomerDataprovider.class)
    public void deleteDifferentDevice(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        Device responseDeleteDevice = service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertTrue(responseDeleteDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseDeleteDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseDeleteDevice.getErrorMessage(), "There is a ErrorMessage that should not be");
        Assert.assertNotNull(responseDeleteDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test
    public void deleteWithoutRequestBody() {
        Device responseDeleteDevice = service.deleteDevice(Device.builder().build());
        assert responseDeleteDevice != null;
        Assert.assertFalse(responseDeleteDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -1.0, "Error code is not -1");
        Assert.assertTrue(responseDeleteDevice.getErrorMessage().toString().contains("serialNumber=<null>,searchCriterias=<null>,modelSessionManager=<null>,username=<null>,password=<null>"));
        Assert.assertNotNull(responseDeleteDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr(), "Error, time is null");
        Assert.assertNull(responseDeleteDevice.getResult(), "There is a Result that should not be");
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void deleteSimilarDeviceTwiceTest(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Device responseDeleteDevice = service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertFalse(responseDeleteDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -4.0);
        Assert.assertEquals(responseDeleteDevice.getErrorMessage(), "No devices matched the search criterias");
        Assert.assertNotNull(responseDeleteDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Failed");
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDevice(Device updateDevice) {
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        Assert.assertTrue(responseUpdateDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseUpdateDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseUpdateDevice.getErrorMessage(), "There is a errorMessage that should not be");
        Assert.assertNotNull(responseUpdateDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceAddCommentTest(Device updateDevice) {
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        Assert.assertTrue(responseUpdateDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseUpdateDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseUpdateDevice.getErrorMessage(), "There is a errorMessage that should not be");
        Assert.assertNotNull(responseUpdateDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }


    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceWithoutChanges(Device updateDevice) {

        updateDevice.setDeviceUpdateProperties(null);
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        Assert.assertFalse(responseUpdateDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(responseUpdateDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseUpdateDevice.getErrorMessage(), "Specify at least one parameter to be modified");
        Assert.assertNotNull(responseUpdateDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Failed");
        assert createdDevice != null;
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceWithoutSerialNumber(Device updateDevice) {

        updateDevice.setSerialNumber(null);
        Device createdDevice = service.createDevice(Device.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        Assert.assertTrue(responseUpdateDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseUpdateDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseUpdateDevice.getErrorMessage(), "There is a errorMessage that should not be");
        Assert.assertNotNull(responseUpdateDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceTest(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;
        List<SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(String.valueOf(createdDevice.getResult().getDevice().getSerialNumber()))
                .build());
        Device responseMoveDevice = service.moveDevice(Device
                .builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(moveDevice)
                .build());

        Assert.assertTrue(responseMoveDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(responseMoveDevice.getErrorCode(), "There is a errorCode that should not be");
        Assert.assertNull(responseMoveDevice.getErrorMessage(), "There is a errorMessage that should not be");
        Assert.assertNotNull(responseMoveDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseMoveDevice.getTimestampStr(), "Error, time is null");
        Assert.assertEquals(responseMoveDevice.getResult().getMessage(), "Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. Total 1 device(s) has(have) been ignored due to same department violation.");
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceWithoutSearchCriteriaTest(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;

        Device responseMoveDevice = service.moveDevice(Device
                .builder()
                .username(USERNAME)
                .password(PASSWORD)
                .accountSerialNumber(ACCOUNT_SERIAL_NUMBER)
                .build());

        assert responseMoveDevice != null;
        Assert.assertFalse(responseMoveDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(responseMoveDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseMoveDevice.getErrorMessage(), "Search criterias can not be null.");
        Assert.assertNotNull(responseMoveDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseMoveDevice.getTimestampStr(), "Error, time is null");
        Assert.assertNull(responseMoveDevice.getResult().getMessage(), "There is a message that should not be");
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceWithoutDepartmentTest(Device newDevice) {
        Device createdDevice = service.createDevice(newDevice);
        assert createdDevice != null;

        List<SearchCriteria> moveDevice = new ArrayList<>();

        moveDevice.add(SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(String.valueOf(createdDevice.getResult().getDevice().getSerialNumber()))
                .build());

        Device responseMoveDevice = service.moveDevice(Device
                .builder()
                .username(USERNAME)
                .password(PASSWORD)
                .searchCriterias(moveDevice)
                .build());

        assert responseMoveDevice != null;
        Assert.assertFalse(responseMoveDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertEquals(responseMoveDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseMoveDevice.getErrorMessage(), "Destination account serial number is mandatory to be provided.");
        Assert.assertNotNull(responseMoveDevice.getTimestamp(), "Error, time is null");
        Assert.assertNotNull(responseMoveDevice.getTimestampStr(), "Error, time is null");
        Assert.assertNull(responseMoveDevice.getResult().getMessage(), "There is a message that should not be");
        service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }
}