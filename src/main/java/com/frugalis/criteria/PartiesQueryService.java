package com.frugalis.criteria;

import com.frugalis.domain.Parties_;
import com.frugalis.repository.PartiesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frugalis.domain.Parties;
import com.frugalis.jpa.service.QueryService;



@Service
@Transactional(readOnly = true)
public class PartiesQueryService extends QueryService<Parties>  {


	private final PartiesRepository partiesRepository;

	public PartiesQueryService(PartiesRepository partiesRepository) {
		this.partiesRepository = partiesRepository;
	}
	@Transactional(readOnly = true)
	public Page<Parties> findByCriteria(PartiesCriteria criteria, Pageable page) {

		final Specification<Parties> specification = createSpecification(criteria);

		return partiesRepository.findAll(specification, page);
	}
	protected Specification<Parties> createSpecification(PartiesCriteria criteria) {
	        Specification<Parties> specification = Specification.where(null);
	        if (criteria != null) {
	            // This has to be called first, because the distinct method returns null
	        	 if (criteria.getPartyName() != null) {
					 specification = specification.and(buildStringSpecification(criteria.getPartyName(), Parties_.partyName));
	             }
	            
	        }
	        return specification;
	    }
	
}

