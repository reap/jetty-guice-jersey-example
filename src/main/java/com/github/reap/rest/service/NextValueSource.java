package com.github.reap.rest.service;

public interface NextValueSource {
    
    /**
     * Returns next value based on some logic
     * 
     * @return
     *      next value
     */
    int nextValue();
}
