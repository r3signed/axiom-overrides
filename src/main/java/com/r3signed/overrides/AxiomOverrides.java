package com.r3signed.overrides;

import com.r3signed.overrides.core.Services;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AxiomOverrides implements ClientModInitializer {
    public static final String MOD_ID = "axiom-overrides";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        Services.init();

    }
}
