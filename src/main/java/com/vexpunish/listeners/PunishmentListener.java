package com.vexpunish.listeners;

import com.vexpunish.utils.WebhookSender;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event;EventHandler;
import org.bukkit.event.Listener;
import space.arim.libertybans.api.event.PunishmentEvent;
import space.arim.libertybans.api.event.PunishmentListener;


public class PunishmentListener implements Listener, PunishmentListener {

    @EventHandler
    public void punishmentApplied(PunishmentEvent event) {
        String playername = event.getPunishment().getTarget().getName();
        String staffName = event.getPunishment().getTarget().getname();
        String reason = event.getPunishment().getReason().orElse("Sem Motivo");
        String Type = event.getPunishment().getType().name();
        String durantion = event.getPunishment().getDurantion().isPresent() ? event.getPunishment().getDurantion().get().toString() : "Permanente";

        String message = "**Nova punição aplicada!**\n" +
                "**Jogador:** " + playerName + "\n" +
                "**Staff:** " + staffName + "\n" +
                "**Motivo:** " + reason + "\n" +
                "**Tipo:** " + type + "\n" +
                "**Duração:** " + duration;

        WebhookSender.sendWebhook(message);

    }
}