import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsbDeviceIdParser {
    // Matches the part after the last backslash
    // Find a last part in string "USBSTOR\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\8&B3FE53D&0" => `8&B3FE53D&0`
    private static final Pattern SerialPattern = Pattern.compile("^(?:[^\\\\]+\\\\){2,}([^\\\\]+)$");

    // Matches the port and serial ID if they are separated by an ampersand
    // Retrieve the values between '&'. 8&B3FE53D&0 parsed as `8` and `B3FE53D`
    private static final Pattern PortSerialPattern = Pattern.compile("^([^&]*)&([^&]+)");

    public UsbPortAndSerial getUsbPortAndSerial(String input) {
        Matcher serialMatcher = SerialPattern.matcher(input);
        if (!serialMatcher.find()) {
            return null;
        }

        String serialNumber = serialMatcher.group(1);
        if (!serialNumber.contains("&")) {
            return new UsbPortAndSerial("", serialNumber);
        }

        Matcher portSerialMatcher = PortSerialPattern.matcher(serialNumber);
        if (!portSerialMatcher.find()) {
            return null;
        }

        String port = portSerialMatcher.group(1);
        String serialId = portSerialMatcher.group(2);
        return new UsbPortAndSerial(port, serialId);
    }

    public record UsbPortAndSerial(String port, String serialId) {
    }
}