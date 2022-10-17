package com.demo.graphqlsubscriptions.dto.event;

import com.demo.graphqlsubscriptions.dto.Action;
import com.fasterxml.jackson.databind.JsonNode;

public class WidgetEvent {
    private Long id;
    private JsonNode data;
    private Action action;

    public static WidgetEvent create(Long id, JsonNode data, Action action) {
        return new WidgetEvent(id, data, action);
    }

    public WidgetEvent(Long id, JsonNode data, Action action) {
        this.id = id;
        this.data = data;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
