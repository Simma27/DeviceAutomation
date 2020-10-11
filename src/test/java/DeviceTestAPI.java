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
        Assert.assertTrue();



    }

}
