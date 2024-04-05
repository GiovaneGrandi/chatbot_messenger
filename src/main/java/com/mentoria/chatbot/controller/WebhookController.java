package com.mentoria.chatbot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class WebhookController {

    public void recebeWebhook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        reader.close();

        String body = requestBody.toString();

        System.out.println("\\u{1F7EA} Received webhook:");

        System.out.println(body);

        if (request.getParameter("object").equals("page")) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("EVENT_RECEIVED");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/webhooks")
    public String VerificaWebhook(HttpServletRequest request, HttpServletResponse response) {
        String mode = request.getParameter("hub.mode");
        String token = request.getParameter("hub.verify_token");
        String challenge = request.getParameter("hub.challenge");

        if (mode != null && token != null) {
            if (mode.equals("subscribe") && token.equals("meutoken")) {
                System.out.println("WEBHOOK_VERIFIED");
                return challenge;
            } else {
                return "403 Forbidden";
            }
        } else {
            return "400 Bad Request";
        }
    }

}
