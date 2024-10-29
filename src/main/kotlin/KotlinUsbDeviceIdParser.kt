import java.util.regex.Pattern

class KotlinUsbDeviceIdParser {
    @JvmRecord
    data class KotlinUsbPortAndSerial(val port: String, val serialId: String)
    companion object {
        // Matches the part after the last backslash
        // Find a last part in string "USBSTOR\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\8&B3FE53D&0" => `8&B3FE53D&0`
        private val SerialPattern: Pattern = Pattern.compile("^(?:[^\\\\]+\\\\){2,}([^\\\\]+)$")

        // Matches the port and serial ID if they are separated by an ampersand
        // Retrieve the values between '&'. 8&B3FE53D&0 parsed as `8` and `B3FE53D`
        private val PortSerialPattern: Pattern = Pattern.compile("^([^&]*)&([^&]+)")
    }

    fun getUsbPortAndSerial(input: String): KotlinUsbPortAndSerial? {
        val serialMatcher = SerialPattern.matcher(input)
        if (!serialMatcher.find()) {
            return null
        }

        val serialNumber = serialMatcher.group(1)
        if (!serialNumber.contains("&")) {
            return KotlinUsbPortAndSerial("", serialNumber)
        }

        val portSerialMatcher = PortSerialPattern.matcher(serialNumber)
        if (!portSerialMatcher.find()) {
            return null
        }

        val port = portSerialMatcher.group(1)
        val serialId = portSerialMatcher.group(2)
        return KotlinUsbPortAndSerial(port, serialId)
    }
}