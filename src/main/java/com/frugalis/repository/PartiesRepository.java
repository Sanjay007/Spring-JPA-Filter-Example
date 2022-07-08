package com.frugalis.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frugalis.domain.Parties;

@Repository
public interface PartiesRepository  extends CrudRepository<Parties, Long> , JpaSpecificationExecutor<Parties> {

}
