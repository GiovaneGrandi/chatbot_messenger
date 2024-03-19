package com.mentoria.chatbot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chatbot {

    private String nome;
    private int idade;

    public String validaPergunta(String pergunta) {
        if(pergunta == "Qual o seu nome?") {
            return respondeNome();
        }
        if(pergunta == "Qual a sua idade?") {
            return respondeIdade();
        } else {
            return fallback();
        }
    }

    public String respondeNome() {
        return "Meu nome é " + this.nome;
    }

    public String respondeIdade() {
        return "Minha idade é " + this.idade;
    }

    public String fallback() {
        return "Não entendi a sua pergunta!";
    }

}
