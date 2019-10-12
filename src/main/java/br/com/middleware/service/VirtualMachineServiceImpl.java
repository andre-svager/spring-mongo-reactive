package br.com.middleware.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.middleware.entity.Resource;
import br.com.middleware.entity.VirtualMachine;
import br.com.middleware.repository.ResourceRepository;
import br.com.middleware.repository.VirtualMachineRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {

	@Autowired
	private VirtualMachineRepository repository;

	@Autowired
	private ResourceRepository repo;

	@Override
	public Mono<VirtualMachine> createVM(VirtualMachine vm) {
		return repository.insert(vm);
	}
	/*
	 * @Override public Flux<VirtualMachine> createVM(Flux<VirtualMachine> vms) {
	 * return repository.saveAll(vms); }
	 */

	public Flux<VirtualMachine> findByTenantId(BigInteger tenant_id) {
		return repository.findByTenantId(tenant_id);
	}

	@Override
	public Mono<Resource> createResource(Resource resource) {
		return repo.insert(resource);
	}
}
