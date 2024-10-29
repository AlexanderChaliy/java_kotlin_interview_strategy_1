import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.NoSuchElementException

class KotlinCustomStackGetMaxTests {
    private var stack: KotlinCustomStack? = null

    @BeforeEach
    fun setUp() {
        stack = KotlinCustomStack()
    }

    @AfterEach
    fun tearDown() {
        stack = null
    }

    @Test
    fun testGetMaxEmptyStack() {
        Assertions.assertThrows(NoSuchElementException::class.java) {
            stack!!.getMax()
        }
    }

    @Test
    fun testGetMaxEmptyElementAfterChanges() {
        stack!!.push(10)
        stack!!.push(100)
        stack!!.push(1)
        stack!!.pop()
        stack!!.pop()
        stack!!.pop()
        val exception = Assertions.assertThrows(
            NoSuchElementException::class.java
        ) {
            stack!!.getMax()
        }
    }

    @Test
    fun testGetMaxMultipleElements() {
        stack!!.push(10)
        stack!!.push(20)
        stack!!.push(5)
        Assertions.assertEquals(20, stack!!.getMax())
    }

    @Test
    fun testGetMaxWithDuplicates() {
        stack!!.push(10)
        stack!!.push(20)
        stack!!.push(20)
        stack!!.push(5)
        stack!!.push(50)
        stack!!.push(-6)
        stack!!.pop() // -6
        stack!!.pop() // 50
        Assertions.assertEquals(20, stack!!.getMax())
    }
}