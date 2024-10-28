import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackInsertTests {
    private CustomStack __Stack;

    @BeforeEach
    public void setUp() {
        __Stack = new CustomStack();
    }

    @AfterEach
    public void tearDown() {
        __Stack = null;
    }

    @Test
    public void testInsertAtBeginning() {
        __Stack.insert(0, 10);
        assertEquals(10, __Stack.pop());
    }

    @Test
    public void testInsertAtEnd() {
        __Stack.push(10);
        __Stack.push(20);
        __Stack.insert(2, 30);
        assertEquals(3, __Stack.size());
        assertStackElements(__Stack, new int[]{20, 10, 30});
    }

    @Test
    public void testInsertInMiddle() {
        __Stack.push(10);
        __Stack.push(30);
        __Stack.insert(1, 20);
        assertEquals(3, __Stack.size());
        assertStackElements(__Stack, new int[]{30, 20, 10});
    }

    @Test
    public void testInsertInvalidPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            __Stack.insert(-1, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            __Stack.insert(1, 10);
        });
    }

    @Test
    public void testGetMaxAfterInsertNewMax() {
        __Stack.push(10);
        __Stack.push(20);
        __Stack.insert(2, 30);
        assertEquals(30, __Stack.getMax());
    }

    @Test
    public void testGetMaxAfterInsertNotMax() {
        __Stack.push(10);
        __Stack.push(30);
        __Stack.insert(1, 20);
        assertEquals(30, __Stack.getMax());
    }

    @Test
    public void testGetMaxAfterInsertEqualMax() {
        __Stack.push(10);
        __Stack.push(30);
        __Stack.insert(1, 30);
        assertEquals(30, __Stack.getMax());
    }

    private void assertStackElements(CustomStack stack, int[] expectedElements) {
        CustomStack tempStack = new CustomStack();
        for (int element : expectedElements) {
            tempStack.push(element);
        }

        for (int element : expectedElements) {
            assertEquals(element, stack.pop());
        }
    }
}
