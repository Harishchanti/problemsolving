package LLD.loggingSystem.service;

import LLD.loggingSystem.model.LogLevel;

public class ErrorLogger extends Logger {
    public ErrorLogger() { super(LogLevel.ERROR); }
}
