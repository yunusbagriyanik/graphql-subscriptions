package com.demo.graphqlsubscriptions.service.widget;

import com.demo.graphqlsubscriptions.dto.widget.CreateWidget;
import com.demo.graphqlsubscriptions.dto.widget.Widget;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WidgetService {
    Flux<Widget> findAllWidgets();

    Mono<Widget> findById(Long id);

    Mono<Widget> createWidget(CreateWidget request);

    Mono<String> deleteWidget();
}
