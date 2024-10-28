import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsbDeviceIdParser {
    // Regex to match the part after the last backslash
    private static final Pattern SerialPattern = Pattern.compile("^(?:[^\\\\]+\\\\){2,}([^\\\\]+)$");
    // Regex to match the port and serial ID if they are separated by an ampersand
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