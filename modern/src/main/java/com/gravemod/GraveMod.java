package com.gravemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraveMod implements ModInitializer {
    public static final String MOD_ID = "gravemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final float TARGET_TPS = 4.0f;

    @Override
    public void onInitialize() {
        LOGGER.info("[Grave.] Loaded.");

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            if (server.isSingleplayer()) {
                server.getTickManager().setTickRate(TARGET_TPS);
                LOGGER.info("[Grave.] Tick rate set to 4 TPS.");
            }
        });
    }
}
