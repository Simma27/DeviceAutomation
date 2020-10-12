import models.api.Device;
import models.api.deviceUpdateProperty;
import org.testng.Assert;
import org.testng.annotations.Test;
import Impl.Service;
import services.BasicService;

import java.util.ArrayList;
import java.util.List;

public class DeviceTestAPI {

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTest(Device newDevice){

        Device createdDevice = Service.createDevice(newDevice);
        Assert.assertNotNull(createdDevice, "");
        Assert.assertTrue(createdDevice.getSuccess());
        Assert.assertNull(createdDevice.getErrorCode());
        Assert.assertNull(createdDevice.getErrorMessage());
        Assert.assertNotNull(createdDevice.getTimestamp());
        Assert.assertNotNull(createdDevice.getTimestampStr());
        Assert.assertEquals(createdDevice.getResult().getMessage()
                , "New NetworkDevice has been created with Serial Number: "
                        + createdDevice.getResult().getDevice().getSerialNumber());
        System.out.println(createdDevice.getResult().getDevice().getSerialNumber());
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
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertTrue(responseDeleteDevice.getSuccess());
        Assert.assertNull(responseDeleteDevice.getErrorCode());
        Assert.assertNull(responseDeleteDevice.getErrorMessage());
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test(dataProvider = "getCreatedDifferentType", dataProviderClass = CustomerDataprovider.class)
    public void deleteDifferentDevice (Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertTrue(responseDeleteDevice.getSuccess());
        Assert.assertNull(responseDeleteDevice.getErrorCode());
        Assert.assertNull(responseDeleteDevice.getErrorMessage());
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Successful! Total 1 devices have been deleted. ");
    }

    @Test
    public void deleteWithoutRequestBody(){
        Device responseDeleteDevice = Service.deleteDevice(Device.builder().build());
        Assert.assertFalse(responseDeleteDevice.getSuccess());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -1.0);
        Assert.assertTrue(responseDeleteDevice.getErrorMessage().toString().contains("serialNumber=<null>,searchCriterias=<null>,modelSessionManager=<null>,username=<null>,password=<null>"));
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertNull(responseDeleteDevice.getResult());
    }

    @Test(dataProvider = "getDataToUpdateDevice", dataProviderClass = CustomerDataprovider.class)
    public void deleteSimilarDeviceTwiceTest(Device newDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Device responseDeleteDevice = Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
        Assert.assertFalse(responseDeleteDevice.getSuccess());
        Assert.assertEquals(responseDeleteDevice.getErrorCode(), -4.0);
        Assert.assertEquals(responseDeleteDevice.getErrorMessage(), "No devices matched the search criterias");
        Assert.assertNotNull(responseDeleteDevice.getTimestamp());
        Assert.assertNotNull(responseDeleteDevice.getTimestampStr());
        Assert.assertEquals(responseDeleteDevice.getResult().getMessage(), "Failed");
    }

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void updateDevice(Device newDevice, Device updateDevice) {
        Device createdDevice = Service.createDevice(newDevice);
        updateDevice.setSerialNumber(createdDevice.getResult().getDevice().getSerialNumber());
//
//        List<deviceUpdateProperty> deviceUpdateProperties = new ArrayList<deviceUpdateProperty>();
//        deviceUpdateProperties.add(deviceUpdateProperty
//                .builder()
//                .propertyName("SUSPEND")
//                .propertyValue("true")
//                .build());
//        deviceUpdateProperties.add(deviceUpdateProperty
//                .builder()
//                .propertyName("DEVICE_NAME")
//                .propertyValue("ExampleDevice")
//                .build());
//        deviceUpdateProperties.add(deviceUpdateProperty
//                .builder()
//                .propertyName("DEVICE_TYPE")
//                .propertyValue("0")
//                .build());
//        deviceUpdateProperties.add(deviceUpdateProperty
//                .builder()
//                .propertyName("ADDRESS")
//                .propertyValue("127.0.0.5")
//                .build());
//        deviceUpdateProperties.add(deviceUpdateProperty
//                .builder()
//                .propertyName("DO_NOT_RESOLVE_ADDRESS")
//                .propertyValue("false")
//                .build());
//
//        Device updateDevice = Device.builder()
//                .username(BasicService.USERNAME)
//                .password(BasicService.PASSWORD)
//                .serialNumber(createdDevice.getResult().getDevice().getSerialNumber())
//                .deviceUpdateProperties(deviceUpdateProperties)
//                .build();
//        System.out.println(updateDevice.toString());

        Device responseUpdateDevice = Service.updateDevice(updateDevice);
        assert responseUpdateDevice != null;
        System.out.println(responseUpdateDevice.toString());
        Assert.assertTrue(responseUpdateDevice.getSuccess());
        Assert.assertNull(responseUpdateDevice.getErrorCode());
        Assert.assertNull(responseUpdateDevice.getErrorMessage());
        Assert.assertNotNull(responseUpdateDevice.getTimestamp());
        Assert.assertNotNull(responseUpdateDevice.getTimestampStr());
        Assert.assertEquals(responseUpdateDevice.getResult().getMessage(), "Updated successfully");
        Service.deleteDevice(createdDevice.getResult().getDevice().getSerialNumber());
    }





}