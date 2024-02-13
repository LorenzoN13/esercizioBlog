package it.epicode.esercizio.model;

import lombok.Data;



@Data
public class Blog {

    private int id;
    private Categoria categoria;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    private Autore autore;
}
