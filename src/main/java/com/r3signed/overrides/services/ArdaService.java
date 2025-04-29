package com.r3signed.overrides.services;

import com.r3signed.overrides.core.IRegisterable;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class ArdaService implements IRegisterable {
    private boolean online = false;

    public void register() {
        // Register join event
        ClientPlayConnectionEvents.JOIN.register((client, handler, sender) -> {
            if (client.getConnection() == null) {
                online = false;
                return;
            }

            SocketAddress socketAddress = client.getConnection().getAddress();
            if (socketAddress instanceof InetSocketAddress address) {
                online = address.getHostString().equalsIgnoreCase("play.ardacraft.me");
            } else {
                online = false;
            }
        });

        // Register disconnect event
        ClientPlayConnectionEvents.DISCONNECT.register((client, handler) -> online = false);
    }

    /**
     * @return True if the client in on ArdaCraft, otherwise false
     */
    public boolean isOnline() {
        return online;
    }
}
