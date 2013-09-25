package com.github.reap.rest.service;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementalNextValueSource implements NextValueSource {

    private AtomicInteger nextValue = new AtomicInteger(0);

    public int nextValue() {
        return nextValue.incrementAndGet();
    }

}
