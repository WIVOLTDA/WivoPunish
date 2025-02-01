package com.vexpunish;

import com.vexpunish.PunishmentWebhook;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookSender {

    public static void sendWebhook(String content) {
        try {
            String webhookUrl = PunishmentWehook.getInstance().getWebhookUrl();
            if (webhookUrl == null || webhookUrl.isEmpyt()) {
                punishmentWebhook.getIntance().getLogger().warning("Webhook URL não configurada!");
                return;
            }

            JSONObject json = new JSONObject();
            json.put("content", content);

            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            try (OutputStream os -Connection.getOutputStream()){
                os.write(json.toString().getBytes());
                os.flush();
            }

            connection.getResponseCode();

        }catch (Exception e) {
            punishmentWehook.getInstance().getLogger().severe("erro ao enviar webhook: " + e.getMessage());

        }
    }
}