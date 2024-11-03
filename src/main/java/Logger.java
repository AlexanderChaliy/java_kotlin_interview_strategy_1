interface ILogger {
    void Log(String message);
}

class FileLogger implements ILogger {
    @Override
    public void Log(String message) {
        // write to the file
    }
}

class ConsoleLogger implements ILogger {
    @Override
    public void Log(String message) {
        // print to console
    }
}

class AggregateLogger {
    //ToDo: Implement Aggregate logger.
}