package org.skylo.svc1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Event {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("data")
    private Object data;

    public Event(UUID id, String type, Object data){
        this.id = id;
        this.type = type;
        this.data = data;
    }
}
