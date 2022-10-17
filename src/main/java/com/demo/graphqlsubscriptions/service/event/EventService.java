package com.demo.graphqlsubscriptions.service.event;

import com.demo.graphqlsubscriptions.dto.event.WidgetEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class EventService {

    private final Sinks.Many<WidgetEvent> sink = Sinks.many().multicast().onBackpressureBuffer();
    private final Flux<WidgetEvent> flux = sink.asFlux().cache(0);

    public void emitEvent(WidgetEvent event) {
        this.sink.tryEmitNext(event);
    }

    public Flux<WidgetEvent> subscribe() {
        return this.flux;
    }
}
