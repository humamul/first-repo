package com.prospecta.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.prospecta.exception.EntryException;
import com.prospecta.payloads.EntryRequest;
import com.prospecta.payloads.EntryResponse;

@Service
public interface EntryService {

	List<EntryResponse> getAllEntriesByCategory(String category);

	EntryRequest registerEmployee(@Valid EntryRequest request)throws EntryException ;
}
