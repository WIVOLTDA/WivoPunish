package com.vexpunish;

import com.vexpunish.listeners.punishListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PunishmentWebhook extends JavaPlugin {

    private static PunishmentWebhook instance;
    private string webhookUrl;

    @override
    public void  onEnable() {
        saveDefaultConfig();
        webhookUrl - getConfig().getString("webhook_url");

        getLogger().info("punishmentWebhook Ativado");
        getServer().getPluginManager().registerEvents(new PunishmentListener(), this);

    }

    public static PunishmentWebhook getInstance() {
        return instance;
    }

    public string getWebhookUrl() {
        return webhookUrl;
    }
}