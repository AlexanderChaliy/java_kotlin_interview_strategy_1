interface ILogger {
    void Log(String message);
}

class FileLogger implements ILogger {
    @Override
    public void Log(String message) {
        System.out.println("File logger call.");
    }
}

class ConsoleLogger implements ILogger {
    @Override
    public void Log(String message) {
        System.out.println("Console logger call.");
    }
}

class AggregateLogger {
    //ToDo: Implement Aggregate logger.
}