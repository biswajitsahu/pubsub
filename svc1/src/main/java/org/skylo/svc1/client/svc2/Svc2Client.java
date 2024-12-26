package org.skylo.svc1.client.svc2;

import org.skylo.svc1.entity.Event;
import org.skylo.svc1.entity.EventPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="svc2Client", url="http://localhost:8081")
public interface Svc2Client {
    @PostMapping("/svc2/processEvent")
    void printEventPayload(Event event);
}
