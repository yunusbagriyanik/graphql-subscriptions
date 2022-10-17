package com.demo.graphqlsubscriptions.dto.widget;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Widget {
    private Long id;
    private String name;
    private String error;

    public Widget(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Widget create(Long id, String name) {
        return new Widget(id, name);
    }

    public static Widget failure(String error) {
        Widget widget = new Widget(null, null);
        widget.setError(error);
        return widget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
