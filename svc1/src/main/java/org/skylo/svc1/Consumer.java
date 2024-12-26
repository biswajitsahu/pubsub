package org.skylo.svc1;


import org.skylo.svc1.client.svc2.Svc2Client;
import org.skylo.svc1.entity.Event;
import org.skylo.svc1.rerty.RetryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Consumer {

    private final ObjectMapper objectMapper;

    @Autowired
    private final Svc2Client svc2Client;

    @Autowired
    RetryHandler retryHandler;

    public Consumer(ObjectMapper objectMapper, Svc2Client svc2Client) {
        this.objectMapper = objectMapper;
        this.svc2Client = svc2Client;
    }

    @KafkaListener(topics = "satellite", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        try {
            // Deserialize JSON string into Message object
            Event deserializedMessage = objectMapper.readValue(message, Event.class);
            System.out.println("Received message: " + deserializedMessage);
            retryHandler.executeWithRetry(
                    () -> svc2Client.printEventPayload(deserializedMessage),
                    10
            );
        } catch (Exception e) {
            System.err.println("Error while deserializing message: " + e.getMessage());
        }
    }
}
