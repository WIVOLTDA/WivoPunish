package com.vexpunish;

import com.vexpunish.listeners.PunishmentListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PunishmentWebhook extends JavaPlugin {

    private static PunishmentWebhook instance;
    private String webhookUrl;

    @Override
    public void onEnable() {
        instance = this;  // Define a instância do plugin
        saveDefaultConfig();
        webhookUrl = getConfig().getString("webhook_url");

        getLogger().info("PunishmentWebhook Ativado!");
        getServer().getPluginManager().registerEvents(new PunishmentListener(), this);
    }

    public static PunishmentWebhook getInstance() {
        return instance;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }
}
