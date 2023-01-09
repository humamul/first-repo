package com.prospecta.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
	@JsonProperty("count")
	private Integer count;
	@JsonProperty("entries")
	private List<Entry> entries = new ArrayList<>(); 
}
