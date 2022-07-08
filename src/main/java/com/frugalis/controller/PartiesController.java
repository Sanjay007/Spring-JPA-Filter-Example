package com.frugalis.controller;

import com.frugalis.criteria.PartiesCriteria;
import com.frugalis.criteria.PartiesQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frugalis.domain.Parties;
import com.frugalis.repository.PartiesRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PartiesController {

	@Autowired
	PartiesQueryService partiesQueryService;

	@Autowired
	PartiesRepository partiesRepository;
	
	@PostMapping("/parties")
	ResponseEntity<String> saveParty(@RequestBody Parties party){
		
		
		return new ResponseEntity<>(new String("Test"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/parties/search")
	ResponseEntity<Object> search(  PartiesCriteria criteria, @org.springdoc.api.annotations.ParameterObject Pageable pageable){
		Page<Parties> pageD= partiesQueryService.findByCriteria(criteria,pageable);
		List<Parties> alld=pageD.getContent();

		return ResponseEntity.ok().body(alld);

	}
	
}
