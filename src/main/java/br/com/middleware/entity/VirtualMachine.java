package br.com.middleware.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "vm")

@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class VirtualMachine extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String href;
	public BigInteger tenant_id;
	public BigInteger ems_id;
	public String tenantId;
	public String emsId;
	public String name;
	public String vendor;
	public String rawPowerState;
	public String allocatedDiskStorage;
	public Hardware hardware;
	@Builder.Default
	public List<Tag> tags = new ArrayList<Tag>();
	@Builder.Default
	public List<Disk> disks = new ArrayList<Disk>();
	public OperatingSystem operatingSystem;
	
	public void buildVM(){
		this.setTenantId(tenant_id.toString());
		this.setEmsId(ems_id.toString());
	}

}