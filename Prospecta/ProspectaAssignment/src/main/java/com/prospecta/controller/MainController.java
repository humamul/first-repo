package com.prospecta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.exception.EntryException;
import com.prospecta.payloads.EntryRequest;
import com.prospecta.payloads.EntryResponse;
import com.prospecta.service.EntryService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class MainController {
	
	@Autowired
	private EntryService entryService;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryResponse>> getAllEntries(@PathVariable String category) {
		List<EntryResponse> list = entryService.getAllEntriesByCategory(category);

		return new ResponseEntity<List<EntryResponse>>(list,HttpStatus.OK);

	}
	
	@PostMapping("/entries/save")
	public ResponseEntity<EntryRequest> registerNewEntry(@Valid @RequestBody EntryRequest request) throws EntryException{
		EntryRequest registeredEmployee = entryService.registerEmployee(request);
		return new ResponseEntity<>(registeredEmployee,HttpStatus.OK);
	}
}
