package br.com.middleware.entity;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class Api {

	@Builder.Default
	public List<VirtualMachine> resources = new ArrayList<VirtualMachine>();
}
