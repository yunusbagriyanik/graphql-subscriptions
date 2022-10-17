package com.demo.graphqlsubscriptions.controller.widget;

import com.demo.graphqlsubscriptions.dto.widget.CreateWidget;
import com.demo.graphqlsubscriptions.dto.widget.Widget;
import com.demo.graphqlsubscriptions.service.widget.WidgetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class WidgetController {

    private final WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @QueryMapping
    public Flux<Widget> widgets() {
        return this.widgetService.findAllWidgets();
    }

    @QueryMapping
    public Mono<Widget> widgetById(@Argument Long id) {
        return this.widgetService.findById(id);
    }

    @MutationMapping
    public Mono<Widget> createWidget(@Argument CreateWidget request) {
        return this.widgetService.createWidget(request);
    }

    @MutationMapping
    public Mono<String> deleteWidget() {
        return this.widgetService.deleteWidget();
    }
}
