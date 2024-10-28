import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UsbDeviceIdParserTests {

    @ParameterizedTest
    @ValueSource(strings = {"invalid_input"})
    public void testGetUsbPortAndSerial_InvalidInputs(String input) {
        UsbDeviceIdParser parser = new UsbDeviceIdParser();
        var result = parser.getUsbPortAndSerial(input);

        assertNull(result);
    }

    @ParameterizedTest
    @MethodSource("provideValidInputs")
    public void testGetUsbPortAndSerial_ValidInputs(String input, String expectedPort, String expectedSerial) {
        UsbDeviceIdParser parser = new UsbDeviceIdParser();
        UsbDeviceIdParser.UsbPortAndSerial result = parser.getUsbPortAndSerial(input);

        assertNotNull(result);
        assertEquals(expectedPort, result.port());
        assertEquals(expectedSerial, result.serialId());
    }

    private static Stream<Arguments> provideValidInputs() {
        return Stream.of(
                Arguments.of("USBSTOR\\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\\8&B3FE53D&0", "8", "B3FE53D"),
                Arguments.of("USBSTOR\\DISK&VEN_GENERIC&PROD_USB_FLASH_DISK&REV_0.00\\&B3FE53D", "", "B3FE53D")
        );
    }
}