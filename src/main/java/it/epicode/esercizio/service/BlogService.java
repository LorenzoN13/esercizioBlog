package it.epicode.esercizio.service;

import it.epicode.esercizio.model.Autore;
import it.epicode.esercizio.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();

    @Autowired
    private AutoreService autoreService;

    public List<Blog> cercaTuttiIBlog() {
        return blogs;
    }

    public Blog cercaBlogPerId(int id) throws NoSuchElementException{
        Optional<Blog> blog = blogs.stream().filter(auto -> auto.getId() == id).findAny();

        if (blog.isPresent()){
            return blog.get();
        } else {
            throw new NoSuchElementException("Blog non trovato.");
        }

    }

    public void salvaBlog(Blog blog){
        blogs.add(blog);
    }

    public Blog aggiornaBlog(int id, Blog blog) throws NoSuchElementException{
        Blog b = cercaBlogPerId(id);

        Autore autore = autoreService.cercaAutorePerId(blog.getAutore().getId());

        b.setAutore(autore);

        b.setCategoria(blog.getCategoria());
        b.setContenuto(blog.getContenuto());
        b.setCover(blog.getCover());
        b.setTempoDiLettura(blog.getTempoDiLettura());

        return b;
    }


    public void cancellaBlog(int id)  throws NoSuchElementException{
        Blog b = cercaBlogPerId(id);
        blogs.remove(b);
    }
}
