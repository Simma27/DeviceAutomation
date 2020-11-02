package device.config;

/**
 * Enum class contains constant path for use when forming request.
 */
public enum ApiDeviceConfig {

    CREATE_DEVICE("/admin/device/create"),
    DELETE_DEVICE("/admin/device/delete"),
    UPDATE_DEVICE("/admin/device/update"),
    MOVE_DEVICE("/admin/device/move");

    String path;

    ApiDeviceConfig(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

