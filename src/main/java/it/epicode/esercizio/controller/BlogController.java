package it.epicode.esercizio.controller;

import it.epicode.esercizio.model.Autore;
import it.epicode.esercizio.model.Blog;
import it.epicode.esercizio.service.AutoreService;
import it.epicode.esercizio.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/autori")
    public List<Blog> getALL(){
        return blogService.cercaTuttiIBlog();
    }

    @GetMapping("/autori/id")
    public Blog getBlogById(@RequestParam int id){
        return blogService.cercaBlogPerId(id);
    }

    @PostMapping("/autori")
    public void SaveBlog(@RequestBody Blog blog){
        blogService.salvaBlog(blog);
    }
    @PutMapping("/autori/{id}")
    public Blog updateBlog(@PathVariable int id,@RequestBody Blog blog){
        return blogService.aggiornaBlog(id, blog);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteBlog(@PathVariable int id){
        blogService.cancellaBlog(id);
    }
}