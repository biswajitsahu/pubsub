package org.skylo.svc1.rerty;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class DefaultRetryHandler implements RetryHandler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void executeWithRetry(Runnable task, int retryIntervalSeconds) {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                task.run();
                scheduler.shutdown(); // Stop retries if the task succeeds
            } catch (Exception e) {
                System.err.println("Retry attempt failed. Retrying..,");
            }
        }, 0, retryIntervalSeconds, TimeUnit.SECONDS);
    }
}
