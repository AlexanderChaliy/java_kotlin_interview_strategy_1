import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class KotlinUsbDeviceIdParserTests {
    @ParameterizedTest
    @ValueSource(strings = ["invalid_input"])
    fun testGetUsbPortAndSerial_InvalidInputs(input: String?) {
        val parser = KotlinUsbDeviceIdParser()
        val result = parser.getUsbPortAndSerial(input!!)

        Assertions.assertNull(result)
    }

    @ParameterizedTest
    @MethodSource("provideValidInputs")
    fun testGetUsbPortAndSerial_ValidInputs(input: String?, expectedPort: String?, expectedSerial: String?) {
        val parser = UsbDeviceIdParser()
        val result = parser.getUsbPortAndSerial(input)

        Assertions.assertNotNull(result)
        Assertions.assertEquals(expectedPort, result.port)
        Assertions.assertEquals(expectedSerial, result.serialId)
    }

    companion object {
        private fun provideValidInputs(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("USBSTOR\\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\\8&B3FE53D&0", "8", "B3FE53D"),
                Arguments.of("USBSTOR\\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\\&B3FE53D", "", "B3FE53D")
            )
        }
    }
}