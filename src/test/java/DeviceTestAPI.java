import models.api.Device;
import models.api.SearchCriteria;
import org.testng.Assert;
import org.testng.annotations.Test;
import Impl.Service;
import services.BasicService;

import java.util.ArrayList;
import java.util.List;

public class DeviceTestAPI {

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTest(Device newDevice) {

        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        Assert.assertTrue(createdDevice.getSuccess(), "Parameter \"success\" is false");
        Assert.assertNull(createdDevice.getErrorCode(), "Have error number: " + createdDevice.getErrorCode());
        Assert.assertNull(createdDevice.getErrorMessage(), "Have error message: " + createdDevice.getErrorMessage());
        Assert.assertNotNull(createdDevice.getTimestamp());
        Assert.assertNotNull(createdDevice.getTimestampStr());
        Assert.assertEquals(createdDevice.getResult().getMessage()
                , "New NetworkDevice has been created with Serial Number: "
                        + createdDevice.getResult().getDevice().getSerialNumber(), "Device is not created");
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceDifferentType(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        Assert.assertNotNull(createdDevice, "");
        Assert.assertNotNull(createdDevice.getTimestamp());
        Assert.assertNotNull(createdDevice.getTimestampStr());
        Assert.assertFalse(createdDevice.getResult().getDevice().getDeviceTypeStr().equalsIgnoreCase("INVALID"), "INVALID");
        Assert.assertEquals(newDevice.getType(), createdDevice.getResult().getDevice().getDeviceType(), "ASSERT EQUALS");
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTwiceTest(Device newDevice) {
        Device similarDeviceOne = Service.createDevice(newDevice);
        Device similarDeviceTwo = Service.createDevice(newDevice);
        assert similarDeviceTwo != null;
        Assert.assertFalse(similarDeviceTwo.getSuccess());
        Assert.assertEquals(similarDeviceTwo.getErrorCode(), -100.0);
        Assert.assertNotNull(similarDeviceTwo.getTimestamp());
        Assert.assertNotNull(similarDeviceTwo.getTimestampStr());
        Assert.assertEquals(similarDeviceTwo.getErrorMessage(), "Unable to create network device: You already have a device named ExampleDevice");
        Assert.assertNull(similarDeviceTwo.getResult().getDevice());
        Assert.assertNull(similarDeviceTwo.getResult().getMessage());
        assert similarDeviceOne != null;
        Service.deleteDevice(similarDeviceOne.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceWithoutName(Device newDevice) {
        newDevice.setName(null);
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        Assert.assertFalse(createdDevice.getSuccess());
        Assert.assertEquals(createdDevice.getErrorCode(), -100.0);
        Assert.assertEquals(createdDevice.getErrorMessage(), "Unable to create network device: Please make sure that all the mandatory properties have been provided! ( type, name, address, locationName)");
        Assert.assertNotNull(createdDevice.getTimestamp());
        Assert.assertNotNull(createdDevice.getTimestampStr());
        Assert.assertNull(createdDevice.getResult().getDevice());
        Assert.assertNull(createdDevice.getResult().getMessage());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void deleteDevice(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertTrue(responseDeleteDevice.getSuccess());
        Assert.assertNull(responseDeleteDevice.getErrorCode());
        Assert.assertNull(responseDeleteDevice.getErrorMessage());
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = CustomerDataprovider.class)
    public void deleteDifferentDevice(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertTrue(responseDeleteDevice.getSuccess());
        Assert.assertNull(responseDeleteDevice.getErrorCode());
        Assert.assertNull(responseDeleteDevice.getErrorMessage());
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test
    public void deleteWithoutRequestBody() {
        Device responseDeleteDevice = Service.deleteDevice(Device.builder().build());
        assert responseDeleteDevice != null;
        Assert.assertFalse(responseDeleteDevice.getSuccess());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -1.0);
        Assert.assertTrue(responseDeleteDevice.getErrorMessage().toString().contains("serialNumber=<null>,searchCriterias=<null>,modelSessionManager=<null>,username=<null>,password=<null>"));
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertNull(responseDeleteDevice.getResult());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void deleteSimilarDeviceTwiceTest(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        assert responseDeleteDevice != null;
        Assert.assertFalse(responseDeleteDevice.getSuccess());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -4.0);
        Assert.assertEquals(responseDeleteDevice.getErrorMessage(), "No devices matched the search criterias");
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Failed");
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDevice(Device updateDevice) {
        Device createdDevice = Service.createDevice(Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = Service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        System.out.println(responseUpdateDevice.toString());
        Assert.assertTrue(responseUpdateDevice.getSuccess());
        Assert.assertNull(responseUpdateDevice.getErrorCode());
        Assert.assertNull(responseUpdateDevice.getErrorMessage());
        Assert.assertNotNull(responseUpdateDevice.getTimestamp());
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceAddCommentTest(Device updateDevice) {
        Device createdDevice = Service.createDevice(Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = Service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        System.out.println(responseUpdateDevice.toString());
        Assert.assertTrue(responseUpdateDevice.getSuccess());
        Assert.assertNull(responseUpdateDevice.getErrorCode());
        Assert.assertNull(responseUpdateDevice.getErrorMessage());
        Assert.assertNotNull(responseUpdateDevice.getTimestamp());
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }


    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceWithoutChanges(Device updateDevice) {

        updateDevice.setDeviceUpdateProperties(null);
        Device createdDevice = Service.createDevice(Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = Service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        System.out.println(responseUpdateDevice.toString());
        Assert.assertFalse(responseUpdateDevice.getSuccess());
        Assert.assertEquals(responseUpdateDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseUpdateDevice.getErrorMessage(), "Specify at least one parameter to be modified");
        Assert.assertNotNull(responseUpdateDevice.getTimestamp());
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Failed");
        assert createdDevice != null;
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDeviceWithoutSerialNumber(Device updateDevice) {

        updateDevice.setSerialNumber(null);
        Device createdDevice = Service.createDevice(Device.builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .address("127.0.0.5")
                .locationName(BasicService.DEFAULT_LOCATION)
                .name("ExampleDevice")
                .type((long) 0)
                .build());
        Device responseUpdateDevice = Service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        System.out.println(responseUpdateDevice.toString());
        Assert.assertTrue(responseUpdateDevice.getSuccess());
        Assert.assertNull(responseUpdateDevice.getErrorCode());
        Assert.assertNull(responseUpdateDevice.getErrorMessage());
        Assert.assertNotNull(responseUpdateDevice.getTimestamp());
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        assert createdDevice != null;
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceTest(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;
        List<SearchCriteria> moveDevice = new ArrayList<SearchCriteria>();

        moveDevice.add(SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(String.valueOf(createdDevice.getResult().getDevice().getSerialNumber()))
                .build());
        Device responseMoveDevice = Service.moveDevice(Device
                .builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .searchCriterias(moveDevice)
                .build());

        System.out.println(responseMoveDevice.toString());
        Assert.assertTrue(responseMoveDevice.getSuccess());
        Assert.assertNull(responseMoveDevice.getErrorCode());
        Assert.assertNull(responseMoveDevice.getErrorMessage());
        Assert.assertNotNull(responseMoveDevice.getTimestamp());
        Assert.assertNotNull(responseMoveDevice.getTimestampStr());
        Assert.assertEquals(responseMoveDevice.getResult().getMessage(), "Total 0 device(s) has(have) been moved to department with name: Core Infrastructure. Total 1 device(s) has(have) been ignored due to same department violation.");
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceWithoutSearchCriteriaTest(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;

        Device responseMoveDevice = Service.moveDevice(Device
                .builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .accountSerialNumber(BasicService.ACCOUNT_SERIAL_NUMBER)
                .build());

        assert responseMoveDevice != null;
        System.out.println(responseMoveDevice.toString());
        Assert.assertFalse(responseMoveDevice.getSuccess());
        Assert.assertEquals(responseMoveDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseMoveDevice.getErrorMessage(), "Search criterias can not be null.");
        Assert.assertNotNull(responseMoveDevice.getTimestamp());
        Assert.assertNotNull(responseMoveDevice.getTimestampStr());
        Assert.assertNull(responseMoveDevice.getResult().getMessage());
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void moveDeviceWithoutDepartmentTest(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        assert createdDevice != null;

        List<SearchCriteria> moveDevice = new ArrayList<SearchCriteria>();

        moveDevice.add(SearchCriteria
                .builder()
                .searchOption("DEVICE_SERIAL_NUMBER")
                .searchTerms(String.valueOf(createdDevice.getResult().getDevice().getSerialNumber()))
                .build());

        Device responseMoveDevice = Service.moveDevice(Device
                .builder()
                .username(BasicService.USERNAME)
                .password(BasicService.PASSWORD)
                .searchCriterias(moveDevice)
                .build());

        assert responseMoveDevice != null;
        System.out.println(responseMoveDevice.toString());
        Assert.assertFalse(responseMoveDevice.getSuccess());
        Assert.assertEquals(responseMoveDevice.getErrorCode(), -412.0);
        Assert.assertEquals(responseMoveDevice.getErrorMessage(), "Destination account serial number is mandatory to be provided.");
        Assert.assertNotNull(responseMoveDevice.getTimestamp());
        Assert.assertNotNull(responseMoveDevice.getTimestampStr());
        Assert.assertNull(responseMoveDevice.getResult().getMessage());
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }
}