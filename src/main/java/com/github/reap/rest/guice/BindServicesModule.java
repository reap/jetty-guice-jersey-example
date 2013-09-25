package com.github.reap.rest.guice;

import com.github.reap.rest.service.IncrementalNextValueSource;
import com.github.reap.rest.service.NextValueSource;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class BindServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NextValueSource.class).to(IncrementalNextValueSource.class).in(Singleton.class);
    }

}
