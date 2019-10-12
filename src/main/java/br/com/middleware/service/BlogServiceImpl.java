package br.com.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.middleware.entity.Blog;
import br.com.middleware.entity.VirtualMachine;
import br.com.middleware.repository.BlogRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository repository;

    @Override
    public Mono<Blog> createBlog(Blog blog) {
        return repository.insert(blog);
    }

    @Override
    public Flux<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Blog> updateBlog(Blog blog, String id) {
        return findOne(id).doOnSuccess(findBlog -> {
            findBlog.setContent(blog.getContent());
            findBlog.setTitle(blog.getTitle());
            findBlog.setAuthor(blog.getAuthor());
            repository.save(findBlog).subscribe();
        });
    }

    @Override
    public Mono<Blog> findOne(String id) {
        return repository.findByIdAndDeleteIsFalse(id).
                switchIfEmpty(Mono.error(new Exception("No Blog found with Id: " + id)));
    }

    @Override
    public Flux<Blog> findByTitle(String title) {
        return repository.findByAuthorAndDeleteIsFalse(title)
                .switchIfEmpty(Mono.error(new Exception("No Blog found with title Containing : " + title)));
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(blog -> {
            blog.setDelete(true);
            repository.save(blog).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }
}
