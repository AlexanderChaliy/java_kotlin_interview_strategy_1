import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KotlinCustomStackInsertTests {
    private var customStack: KotlinCustomStack? = null

    @BeforeEach
    fun setUp() {
        customStack = KotlinCustomStack()
    }

    @AfterEach
    fun tearDown() {
        customStack = null
    }

    @Test
    fun testInsertAtBeginning() {
        customStack!!.insert(0, 10)
        Assertions.assertEquals(10, customStack!!.pop())
    }

    @Test
    fun testInsertAtEnd() {
        customStack!!.push(10)
        customStack!!.push(20)
        customStack!!.insert(2, 30)
        Assertions.assertEquals(3, customStack!!.size())
        assertStackElements(customStack!!, intArrayOf(20, 10, 30))
    }

    @Test
    fun testInsertInMiddle() {
        customStack!!.push(10)
        customStack!!.push(30)
        customStack!!.insert(1, 20)
        Assertions.assertEquals(3, customStack!!.size())
        assertStackElements(customStack!!, intArrayOf(30, 20, 10))
    }

    @Test
    fun testInsertInvalidPosition() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            customStack!!.insert(-1, 10)
        }
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            customStack!!.insert(1, 10)
        }
    }

    @Test
    fun testGetMaxAfterInsertNewMax() {
        customStack!!.push(10)
        customStack!!.push(20)
        customStack!!.insert(2, 30)
        Assertions.assertEquals(30, customStack!!.getMax())
    }

    @Test
    fun testGetMaxAfterInsertNotMax() {
        customStack!!.push(10)
        customStack!!.push(30)
        customStack!!.insert(1, 20)
        Assertions.assertEquals(30, customStack!!.getMax())
    }

    @Test
    fun testGetMaxAfterInsertEqualMax() {
        customStack!!.push(10)
        customStack!!.push(30)
        customStack!!.insert(1, 30)
        Assertions.assertEquals(30, customStack!!.getMax())
    }

    private fun assertStackElements(stack: KotlinCustomStack, expectedElements: IntArray) {
        val tempStack = CustomStack()
        for (element in expectedElements) {
            tempStack.push(element)
        }

        for (element in expectedElements) {
            Assertions.assertEquals(element, stack.pop())
        }
    }
}