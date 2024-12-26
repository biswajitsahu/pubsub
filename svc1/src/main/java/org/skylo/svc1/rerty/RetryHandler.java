package org.skylo.svc1.rerty;

public interface RetryHandler {
    void executeWithRetry(Runnable task, int retryIntervalSeconds);
}

