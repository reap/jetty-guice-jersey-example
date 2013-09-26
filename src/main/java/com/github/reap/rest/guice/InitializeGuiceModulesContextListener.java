package com.github.reap.rest.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class InitializeGuiceModulesContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        Injector parentInjector = Guice.createInjector(new BindServicesModule());

        Injector childInjector = parentInjector.createChildInjector(new BindJerseyResourcesModule());
        
        return childInjector;
    }
}
