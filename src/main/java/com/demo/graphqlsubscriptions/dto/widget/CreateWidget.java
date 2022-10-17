package com.demo.graphqlsubscriptions.dto.widget;

public class CreateWidget {
    private Long id;
    private String name;

    public CreateWidget(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CreateWidget create(Long id, String name) {
        return new CreateWidget(id, name);
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
}
