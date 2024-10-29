internal interface IKotlinLogger {
    fun log(message: String?)
}

internal class KotlinFileLogger : IKotlinLogger {
    override fun log(message: String?) {
        println("File logger call. Message  => $message")
    }
}

internal class KotlinConsoleLogger : IKotlinLogger {
    override fun log(message: String?) {
        println("Console logger call. Message => $message")
    }
}

//ToDo: Implement Aggregate logger.
internal class KotlinAggregateLogger