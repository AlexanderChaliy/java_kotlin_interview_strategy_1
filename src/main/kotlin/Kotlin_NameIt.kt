object Kotlin_NameIt {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = intArrayOf(5, 7, 9, 11, 18, 34, 37, -7, 0, 2, 4)
        val result = nameMethod(input)

        if (result == -1) {
            println("Empty result")
        } else {
            val position = input[result]
            println("Result => $result. Position => $position")
        }
    }

    fun nameMethod(input: IntArray): Int {
        for (i in 0 until input.size - 1) {
            if (input[i] > input[i + 1]) {
                return i + 1
            }
        }
        return -1
    }

    //ToDo: Implement it. Improve nameMethod(...)
    fun nameMethod2(input: IntArray?): Int {
        throw UnsupportedOperationException("Not supported yet.")
    }
}