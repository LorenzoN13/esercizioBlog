package it.epicode.esercizio.controller;

import it.epicode.esercizio.model.Autore;
import it.epicode.esercizio.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping("/autori")
    public List<Autore> getALL(){
        return autoreService.cercaTuttiGliAutori();
    }

    @GetMapping("/autori/{id}")
    public Autore getAutoreById(@PathVariable int id){
        return autoreService.cercaAutorePerId(id);
    }

    @PostMapping("/autori")
    public void SaveAutore(@RequestBody Autore autore){
        autoreService.salvaAutore(autore);
    }
    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody Autore autore){
        return autoreService.aggiornaAutore(id, autore);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id){
        autoreService.cancellaAutore(id);
    }
}
