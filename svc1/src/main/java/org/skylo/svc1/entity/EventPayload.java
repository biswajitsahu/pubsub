package org.skylo.svc1.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class EventPayload {
    public UUID id;
    public String type;
    public Object data;
}
