package br.com.middleware.entity;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "hardware")

@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class Hardware {

	public BigInteger id;
	public String guestOs;
	public Integer cpuSockets;
	public String annotation;
	public Integer vmOrTemplateId;
	public Integer memoryMb;
	public String manufacturer;
	public String model;
	public Integer cpuCoresPerSocket;
	public Integer cpuTotalCores;

}