package LLD.loggingSystem.service;

import LLD.loggingSystem.model.LogMessage;

// ===================== Strategy Pattern (Appender) =====================
public interface Appender {
    void append(LogMessage message);
}
