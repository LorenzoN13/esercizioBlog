package it.epicode.esercizio.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Autore {
    private int id  = new Random().nextInt(1, Integer.MAX_VALUE);

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;
}
