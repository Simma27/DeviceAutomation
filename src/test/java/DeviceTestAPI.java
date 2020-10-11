import models.api.Device;
import models.api.Device;
import org.testng.Assert;
import org.testng.annotations.Test;
import Impl.Service;

public class DeviceTestAPI {

    @Test(dataProvider = "getCreatedDevice", dataProviderClass = CustomerDataprovider.class)
    public void createDeviceTest(Device device){

        Device createdDevice = Service.createDevice(device);
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

}