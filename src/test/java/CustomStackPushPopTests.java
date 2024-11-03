import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackPushPopTests {
    private CustomStack customStack;

    @BeforeEach
    public void setUp() {
        customStack = new CustomStack();
    }

    @AfterEach
    public void tearDown(){
        customStack = null;
    }

    @Test
    public void testPush() {
        customStack.push(10);
        customStack.push(20);
        customStack.push(30);

        assertEquals(30, customStack.pop());
        assertEquals(20, customStack.pop());
        assertEquals(10, customStack.pop());
    }

    @Test
    public void testPop() {
        customStack.push(10);
        customStack.push(20);
        customStack.push(30);

        assertEquals(30, customStack.pop());
        assertEquals(20, customStack.pop());
        assertEquals(10, customStack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(EmptyStackException.class, customStack::pop);
    }
}
