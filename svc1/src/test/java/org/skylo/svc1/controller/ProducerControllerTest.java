package org.skylo.svc1.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockitoAnnotations;
import org.skylo.svc1.entity.Event;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProducerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private ProducerController producerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(producerController).build();
    }

    @Test
    void produceMessage_validPayload_sendsToKafka() throws Exception {
        String topicName = "test-topic";
        String payload = "{\"type\":\"testType\",\"data\":\"testData\"}";

        mockMvc.perform(post("/produce/topic/" + topicName)
                        .contentType("application/json")
                        .content(payload))
                .andExpect(status().isOk());
        verify(kafkaTemplate).send(eq(topicName), any(Event.class));;
    }
}
