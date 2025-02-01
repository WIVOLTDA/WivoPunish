package com.vexpunish;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookSender {

    public static void sendWebhook(String content) {
        try {
            String webhookUrl = PunishmentWebhook.getInstance().getWebhookUrl();
            if (webhookUrl == null || webhookUrl.isEmpty()) {
                PunishmentWebhook.getInstance().getLogger().warning("Webhook URL não configurada!");
                return;
            }

            JSONObject json = new JSONObject();
            json.put("content", content);

            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(json.toString().getBytes());
                os.flush();
            }

            connection.getResponseCode(); // Executa a requisição HTTP

        } catch (Exception e) {
            PunishmentWebhook.getInstance().getLogger().severe("Erro ao enviar webhook: " + e.getMessage());
        }
    }
}
