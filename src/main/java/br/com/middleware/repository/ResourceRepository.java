package br.com.middleware.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.middleware.entity.Resource;

@Repository
public interface ResourceRepository extends ReactiveMongoRepository<Resource, String> {

}
