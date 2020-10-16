package models;

import java.util.HashMap;
import java.util.Map;

public class DeviceType {

    public static String getDeviceTypeStr(int devicetype) {
        Map<Integer, String> deviceTypes = new HashMap<>();
        deviceTypes.put(0,"Windows Server");
        deviceTypes.put(1, "Linux/Other Unix");
        deviceTypes.put(2, "Network Switch");
        deviceTypes.put(3, "IP Router");
        deviceTypes.put(4, "Firewall Appliance");
        deviceTypes.put(5,"Load Balancer/SLB");
        deviceTypes.put(6, "Proxy Server");
        deviceTypes.put(7, "VPN Concentrator");
        deviceTypes.put(8, "Printer/Print Server");
        deviceTypes.put(9, "Wireless Access Point");
        deviceTypes.put(10,"Other/Generic Device");
        deviceTypes.put(11, "Storage Array");
        deviceTypes.put(12, "Vmware/Xen/Hyper-V");
        deviceTypes.put(13, "Virtualized Instance");

        return deviceTypes.get(devicetype);
    }
}
