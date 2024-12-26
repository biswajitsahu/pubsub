package org.skylo.svc2.controller;

import org.skylo.svc1.entity.EventPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/svc2/processEvent")
    public void printEventPayload(@RequestBody EventPayload eventPayload) {
        System.out.println("svc2 Received event: " + eventPayload);
    }
}
