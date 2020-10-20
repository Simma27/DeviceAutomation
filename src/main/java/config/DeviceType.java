package config;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Enum class contains all device type number and name.
 * Version: 9.5.831-GA-2020-09-04 08:14
 */
public enum DeviceType {
    
        WINDOWS_SERVER(0,"Windows Server"),
        LINUX_OTHER_UNIX(1, "Linux/Other Unix"),
        NETWORK_SWITCH(2, "Network Switch"),
        IP_ROUTER(3, "IP Router"),
        FIREWALL_APPLIANCE(4, "Firewall Appliance"),
        LOAD_BALANCER_SLB(5,"Load Balancer/SLB"),
        PROXY_SERVER(6, "Proxy Server"),
        VPN_CONCENTRATOR(7, "VPN Concentrator"),
        PRINTER_PRINT_SERVER(8, "Printer/Print Server"),
        WIRELESS_ACCESS_POINT(9, "Wireless Access Point"),
        OTHER_GENERIC_DEVICE(10,"Other/Generic Device"),
        STORAGE_ARRAY(11, "Storage Array"),
        VMWARE_XEN_HYPER_V(12, "Vmware/Xen/Hyper-V"),
        VIRTUALIZED_INSTANCE(13, "Virtualized Instance");

        int deviceType;

        String deviceName;


    DeviceType(int deviceType, String deviceName) {
        this.deviceType = deviceType;
        this.deviceName = deviceName;
    }

    public static String find(int type) {
        return Arrays.stream(DeviceType.values())
                .filter(dt -> dt.deviceType == type)
                .map(dt -> dt.deviceName)
                .collect(Collectors.joining());
    }
}
