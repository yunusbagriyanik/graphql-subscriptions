package com.demo.graphqlsubscriptions.controller.event;

import com.demo.graphqlsubscriptions.dto.event.WidgetEvent;
import com.demo.graphqlsubscriptions.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class WidgetEventController {

    @Autowired
    private EventService eventService;

    @SubscriptionMapping
    public Flux<WidgetEvent> widgetEvents() {
        return this.eventService.subscribe();
    }
}
