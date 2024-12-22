package org.skylo.svc1.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EventPayload {
    public UUID id;
    public String type;
    public Object data;
}
