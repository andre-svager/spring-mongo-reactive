package br.com.middleware.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.middleware.entity.Blog;
import br.com.middleware.service.BlogService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    private BlogService baseService;

    @GetMapping
    public Flux<Blog> findAll() {
        log.debug("findAll Blog");
        return baseService.findAll();
    }

    @GetMapping("/find")
    public Flux<Blog> findByTitle(@RequestParam String blogTitle) {
        log.debug("findByTitle Blog with blogTitle : {}", blogTitle);
        return baseService.findByTitle(blogTitle);
    }

    @GetMapping("/{id}")
    public Mono<Blog> findOne(@PathVariable String id) {
        log.debug("findOne Blog with id : {}", id);
        return baseService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Blog> create(@RequestBody Blog blog) {
        log.debug("create Blog with blog : {}", blog);
        return baseService.createBlog(blog);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable String id) {
        log.debug("delete Blog with id : {}", id);
        return baseService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<Blog> updateBlog(@RequestBody Blog blog, @PathVariable String id) {
        log.debug("updateBlog Blog with id : {} and blog : {}", id, blog);
        return baseService.updateBlog(blog, id);
    }
}
