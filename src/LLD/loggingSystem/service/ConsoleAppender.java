package LLD.loggingSystem.service;

import LLD.loggingSystem.model.LogMessage;

public class ConsoleAppender implements Appender {
    @Override
    public void append(LogMessage message) {
        System.out.println(message.format());
    }
}