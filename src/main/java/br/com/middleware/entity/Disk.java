package br.com.middleware.entity;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "disk")

@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class Disk{

	private BigInteger id;
	private String deviceName;
	private String deviceType;
	private String location;
	private String filename;
	private Integer hardwareId;
	private String mode;
	private String controllerType;
	private BigInteger size;
	private Integer sizeOnDisk;
	private Boolean present;
	private Boolean startConnected;
	private String createdOn;
	private String updatedOn;
	private String diskType;
	private Integer storageId;
	private Boolean bootable;

}