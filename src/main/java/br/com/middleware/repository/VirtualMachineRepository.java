package br.com.middleware.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.middleware.entity.VirtualMachine;
import reactor.core.publisher.Flux;

@Repository
public interface VirtualMachineRepository extends ReactiveMongoRepository<VirtualMachine, String> {

	Flux<VirtualMachine> findByTenantId(BigInteger tenant_id);

}
