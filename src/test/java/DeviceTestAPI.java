import models.api.BodyRequestToCreateDevice;
import models.api.BodyResponseCreatedDevice;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Service;

public class DeviceTestAPI {

    @Test(dataProvider = "getCreatedDevice")
    void createDeviceTest(BodyRequestToCreateDevice createdDevice){
        BodyResponseCreatedDevice bodyResponseCreatedDevice = Service.createDevice(createdDevice);
        Assert.assertNotNull(bodyResponseCreatedDevice, "");
        Assert.assertTrue(bodyResponseCreatedDevice.getSuccess());
        Assert.assertNull(bodyResponseCreatedDevice.getErrorCode());
        Assert.assertNull(bodyResponseCreatedDevice.getErrorMessage());
        Assert.assertNotNull(bodyResponseCreatedDevice.getTimestamp());
        Assert.assertNotNull(bodyResponseCreatedDevice.getTimestampStr());
        Assert.assertEquals(bodyResponseCreatedDevice.getResult().getMessage(), "New NetworkDevice has been created with Serial Number : " + bodyResponseCreatedDevice.getResult().getDevice().getAccountSerialNumber());
    }

}