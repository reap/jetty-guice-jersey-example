package com.github.reap.rest.guice;

import java.util.Set;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class BindJerseyResourcesModule extends ServletModule {

    @Override
    protected void configureServlets() {
        explictlyBindGuiceContainer();
        bindResources();
        serveBoundResources();
    }

    private void explictlyBindGuiceContainer() {
        bind(GuiceContainer.class);
    }

    private void bindResources() {
        for (Class<?> resource : lookupResources()) {
            bind(resource);
        }
    }

    private Set<Class<?>> lookupResources() {
        PackagesResourceConfig resourceConfig = new PackagesResourceConfig("com.github.reap.rest.resource");
        return resourceConfig.getClasses();
    }

    private void serveBoundResources() {
        serve("/*").with(GuiceContainer.class);
    }
}