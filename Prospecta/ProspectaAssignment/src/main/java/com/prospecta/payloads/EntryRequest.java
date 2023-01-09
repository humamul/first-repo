package com.prospecta.payloads;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntryRequest {
	@NotNull(message = "Unique id can not be null")
	private String api;
	@Size(min = 10,message = "Size of the description should be greater than 10 alphabet spaces")
	private String descripttion;
	private String auth;
	private String https;
	private String cors;
	private String link;
	@NotNull(message = "Category can not be null")
	private String category;
}
