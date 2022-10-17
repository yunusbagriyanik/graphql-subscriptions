package com.demo.graphqlsubscriptions.service.widget;

import com.demo.graphqlsubscriptions.dto.Action;
import com.demo.graphqlsubscriptions.dto.event.WidgetEvent;
import com.demo.graphqlsubscriptions.dto.widget.CreateWidget;
import com.demo.graphqlsubscriptions.dto.widget.Widget;
import com.demo.graphqlsubscriptions.service.event.EventService;
import com.demo.graphqlsubscriptions.util.DummyStorageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class WidgetServiceImpl implements WidgetService {

    private final EventService eventService;
    private final ObjectMapper objectMapper;

    public WidgetServiceImpl(EventService eventService, ObjectMapper objectMapper) {
        this.eventService = eventService;
        this.objectMapper = objectMapper;
    }

    @Override
    public Flux<Widget> findAllWidgets() {
        return DummyStorageUtil.flux;
    }

    @Override
    public Mono<Widget> findById(Long id) {
        return DummyStorageUtil.flux.filter(c -> c.getId().equals(id)).next();
    }

    @Override
    public Mono<Widget> createWidget(CreateWidget request) {
        return Mono.just(Widget.create(request.getId(), request.getName()))
                .doOnNext(c -> this.eventService.emitEvent(WidgetEvent.create(c.getId(), this.objectMapper.valueToTree(c), Action.CREATED)))
                .onErrorResume(e -> Mono.just(Widget.failure(e.getMessage())));
    }

    @Override
    public Mono<String> deleteWidget() {
        return Mono.just("DELETE_TX")
                .doOnSuccess(x -> this.eventService.emitEvent(WidgetEvent.create(ThreadLocalRandom.current().nextLong(), this.objectMapper.valueToTree(x), Action.DELETED)))
                .thenReturn("SUCCESS")
                .onErrorReturn("ERROR");
    }
}
