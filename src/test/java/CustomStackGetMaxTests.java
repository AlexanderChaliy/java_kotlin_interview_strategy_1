import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class CustomStackGetMaxTests {
    private CustomStack __Stack;

    @BeforeEach
    public void setUp() {
        __Stack = new CustomStack();
    }

    @AfterEach
    public void tearDown(){
        __Stack = null;
    }

    @Test
    public void testGetMaxEmptyStack() {
        assertThrows(EmptyStackException.class, () -> {
            __Stack.getMax();
        });
    }

    @Test
    public void testGetMaxEmptyElementAfterChanges() {
        __Stack.push(10);
        __Stack.push(100);
        __Stack.push(1);
        __Stack.pop();
        __Stack.pop();
        __Stack.pop();
        EmptyStackException exception = assertThrows(EmptyStackException.class, () -> {
            __Stack.getMax();
        });
    }

    @Test
    public void testGetMaxMultipleElements() {
        __Stack.push(10);
        __Stack.push(20);
        __Stack.push(5);
        assertEquals(20, __Stack.getMax());
    }

    @Test
    public void testGetMaxWithDuplicates() {
        __Stack.push(10);
        __Stack.push(20);
        __Stack.push(20);
        __Stack.push(5);
        __Stack.push(50);
        __Stack.push(-6);
        __Stack.pop(); // -6
        __Stack.pop(); // 50
        assertEquals(20, __Stack.getMax());
    }
}