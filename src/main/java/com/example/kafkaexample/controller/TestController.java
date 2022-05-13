package com.example.kafkaexample.controller;

import com.example.kafkaexample.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/test/{message}")
    public String sendMessage(@PathVariable String message) {
        try {
            TestModel obj = new TestModel();
            obj.setMessage(message);
            kafkaTemplate.send("test", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Message sent successfully";
    }
}
