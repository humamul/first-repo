package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.model.Entry;
@Repository
public interface ProspectaRepo extends JpaRepository<Entry	, String>{
	
}
