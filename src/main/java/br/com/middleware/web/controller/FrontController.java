package br.com.middleware.web.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.middleware.entity.Api;
import br.com.middleware.entity.VirtualMachine;
import br.com.middleware.service.VirtualMachineService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/controller")
public class FrontController {

    @Autowired
    private VirtualMachineService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<VirtualMachine> create(@RequestBody Api api) {
    	
    	return Flux.fromIterable(api.getResources()).flatMap(vm -> service.createVM(vm));   	
    }
/*   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Resource> create(@RequestBody Api api) {
    	api.resources.forEach(res -> {
    		service.createResource(res);
    	});
		return null;
        
    }
*/    
    @GetMapping("/tenantid/{tenantid}")
    public Flux<VirtualMachine> find(@PathVariable BigInteger tenantid){
    	return service.findByTenantId(tenantid);
    }

}
