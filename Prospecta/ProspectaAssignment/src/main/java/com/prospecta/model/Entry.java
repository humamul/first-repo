package com.prospecta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Entry_Table")
public class Entry {
	@Id
	@JsonProperty("API")
	private String api;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Auth")
	private String auth;
	@JsonProperty("HTTPS")
	private String https;
	@JsonProperty("Cors")
	private String cors;
	@JsonProperty("Link")
	private String link;
	@JsonProperty("Category")
	private String category;
}
