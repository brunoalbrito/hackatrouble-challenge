package com.br.hackatrouble.challenge.enums;

public enum Status {

    CHEIO("cheio"),
    MODERADO("moderado"),
    VAZIO("vazio");

    private String label;

    Status(String label){
        this.label = label;
    }

    public static Status valueOfLabel(String label) {
        for (Status e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
