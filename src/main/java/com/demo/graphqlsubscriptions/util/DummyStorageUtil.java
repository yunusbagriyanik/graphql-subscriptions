package com.demo.graphqlsubscriptions.util;

import com.demo.graphqlsubscriptions.dto.widget.Widget;
import reactor.core.publisher.Flux;

import java.util.UUID;

public class DummyStorageUtil {
    public static final Flux<Widget> flux = Flux.just(
            Widget.create(0L, UUID.randomUUID().toString()),
            Widget.create(1L, UUID.randomUUID().toString()),
            Widget.create(2L, UUID.randomUUID().toString()),
            Widget.create(3L, UUID.randomUUID().toString()),
            Widget.create(4L, UUID.randomUUID().toString()),
            Widget.create(5L, UUID.randomUUID().toString()),
            Widget.create(6L, UUID.randomUUID().toString()),
            Widget.create(7L, UUID.randomUUID().toString())
    );
}
