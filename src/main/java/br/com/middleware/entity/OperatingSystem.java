package br.com.middleware.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "tag")

@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class OperatingSystem {

	public Integer id;
	public String productName;
	public Integer vmOrTemplateId;
	public String systemType;

}