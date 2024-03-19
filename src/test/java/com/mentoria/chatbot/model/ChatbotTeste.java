package com.mentoria.chatbot.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatbotTeste {

    @Test
    public void testRespondeNome() {
        Chatbot chatbot = new Chatbot("Chatbot", 3);
        assertEquals("Meu nome é Chatbot", chatbot.respondeNome());
    }

    @Test
    public void testRespondeIdade() {
        Chatbot chatbot = new Chatbot("Chatbot", 3);
        assertEquals("Minha idade é 3", chatbot.respondeIdade());
    }

    @Test
    public void testValidaPerguntaNome() {
        Chatbot chatbot = new Chatbot("Chatbot", 3);
        assertEquals("Meu nome é Chatbot", chatbot.validaPergunta("Qual o seu nome?"));
    }

    @Test
    public void testValidaPerguntaIdade() {
        Chatbot chatbot = new Chatbot("Chatbot", 3);
        assertEquals("Minha idade é 3", chatbot.validaPergunta("Qual a sua idade?"));
    }

    @Test
    public void testFallback() {
        Chatbot chatbot = new Chatbot("Chatbot", 3);
        assertEquals("Não entendi a sua pergunta!", chatbot.validaPergunta("Qual é o seu nome?"));
    }

}
