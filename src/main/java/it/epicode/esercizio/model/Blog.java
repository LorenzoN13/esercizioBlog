package it.epicode.esercizio.model;

import lombok.Data;

import java.util.Random;


@Data
public class Blog {

    private int id  = new Random().nextInt(1, Integer.MAX_VALUE);

    private Categoria categoria;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    private Autore autore;
}
