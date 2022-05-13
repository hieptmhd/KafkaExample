package com.example.kafkaexample.consumer;

import com.example.kafkaexample.model.TestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListen {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListen.class);

    @KafkaListener(groupId = "group-id", topics = "test", containerFactory = "kafkaListenerContainerTestModelFactory")
    public void receivedMessage(TestModel message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Message received using Kafka listener: " + message.getMessage());
    }
}
