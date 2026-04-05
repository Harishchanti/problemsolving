package LLD.loggingSystem.service;

import LLD.loggingSystem.model.LogLevel;

public class DebugLogger extends Logger {
    public DebugLogger() { super(LogLevel.DEBUG); }
}