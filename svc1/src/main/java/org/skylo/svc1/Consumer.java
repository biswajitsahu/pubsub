package org.skylo.svc1;


import org.skylo.svc1.entity.Event;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Consumer {

    private final ObjectMapper objectMapper;

    public Consumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "satellite", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        try {
            // Deserialize JSON string into Message object
            Event deserializedMessage = objectMapper.readValue(message, Event.class);
            System.out.println("Received message: " + deserializedMessage);
        } catch (Exception e) {
            System.err.println("Error while deserializing message: " + e.getMessage());
        }
    }
}
