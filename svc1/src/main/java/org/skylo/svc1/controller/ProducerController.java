package org.skylo.svc1.controller;

import org.skylo.svc1.entity.Event;
import org.skylo.svc1.entity.EventPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/produce/topic/{topicName}")
    public void produceMessage(@PathVariable String topicName, @RequestBody EventPayload eventPayload) {
        Event event = new Event(UUID.randomUUID(), eventPayload.type, eventPayload.data);
        kafkaTemplate.send(topicName, event);
    }
}
