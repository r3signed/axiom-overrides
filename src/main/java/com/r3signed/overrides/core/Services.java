package com.r3signed.overrides.core;

import com.r3signed.overrides.services.ArdaService;

public class Services {
    public static final ArdaService ARDA = register(new ArdaService());

    /**
     * Registers a service.
     *
     * @param service The service to register
     */
    private static <T> T register(T service) {
        if (service instanceof IRegisterable registerable) {
            registerable.register();
        }
        return service;
    }

    public static void init() {}
}
