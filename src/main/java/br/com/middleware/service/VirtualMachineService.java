package br.com.middleware.service;

import java.math.BigInteger;
import java.util.List;

import br.com.middleware.entity.Resource;
import br.com.middleware.entity.VirtualMachine;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VirtualMachineService {

    Mono<VirtualMachine> createVM(VirtualMachine vm);
    
    Flux<VirtualMachine> findByTenantId(BigInteger tenantid);

    Mono<Resource> createResource(Resource resource);

	//Flux<VirtualMachine> createVM(List<VirtualMachine> vm);
}
