package it.epicode.esercizio.service;

import it.epicode.esercizio.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public List<Autore> cercaTuttiGliAutori(){
        return autori;
    }

    public Autore cercaAutorePerId(int id) throws NoSuchElementException{
        Optional<Autore> a = autori.stream().filter(autore -> autore.getId() == id).findAny();

        if (a.isPresent()){
            return a.get();
        } else {
            throw new NoSuchElementException("Autore non trovato.");
        }
    }

    public void salvaAutore(Autore autore){
        autori.add(autore);
    }

    public Autore aggiornaAutore(int id, Autore autore) throws NoSuchElementException{
        Autore a = cercaAutorePerId(id);

        a.setNome(autore.getNome());
        a.setCognome(autore.getCognome());
        a.setEmail(autore.getEmail());
        a.setDataNascita(autore.getDataNascita());
        a.setAvatar(autore.getAvatar());
        return a;
    }

    public void cancellaAutore(int id)  throws NoSuchElementException{
        Autore autore = cercaAutorePerId(id);
        autori.remove(autore);
    }
}
