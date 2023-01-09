package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.exception.EntryException;
import com.prospecta.model.Data;
import com.prospecta.model.Entry;
import com.prospecta.payloads.EntryRequest;
import com.prospecta.payloads.EntryResponse;
import com.prospecta.repository.ProspectaRepo;
@Service
public class EntryServiceImpl implements EntryService{

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProspectaRepo entryRepo;
	@Override
	public List<EntryResponse> getAllEntriesByCategory(String category) {
		// TODO Auto-generated method stub
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> entries = data.getEntries();
		
		if(category.contains(" ")) {
			
			String[] arr = category.split(" ");
			category = arr[0];
		}
		System.out.println(category+"*****************************************************************");
		List<EntryResponse> list = new ArrayList<>();
		for(Entry i:entries) {
			String forCompare = i.getCategory();
			if(forCompare.contains(" ")) {
				String[] split = forCompare.split(" ");
				forCompare = split[0];
			}
			if(forCompare.equalsIgnoreCase(category)) {
				list.add(new EntryResponse(i.getApi(),i.getCategory()));
			}
		}
		return list;
	}

	@Override
	public EntryRequest registerEmployee(@Valid EntryRequest request) throws EntryException {
		Optional<Entry> optionalEntry = entryRepo.findById(request.getApi());
		if(optionalEntry.isPresent()) throw new EntryException("Api already exists with the name : "+request.getApi());
		Entry entry = new Entry(request.getApi(), request.getDescripttion(), request.getAuth(), request.getHttps(), request.getCors(), request.getLink(), request.getCategory());
		entryRepo.save(entry);
		
		return request;
	}

}
