package com.frugalis.criteria;

import com.frugalis.jpa.service.Criteria;
import com.frugalis.jpa.service.filter.StringFilter;

import org.springdoc.api.annotations.ParameterObject;

import java.io.Serializable;

@ParameterObject
public class PartiesCriteria implements Serializable ,Criteria
{
	StringFilter partyName;
	
    private Boolean distinct;

	public Boolean getDistinct() {
		return distinct;
	}

	public PartiesCriteria(){}

	public void setDistinct(Boolean distinct) {
		this.distinct = distinct;
	}



	public PartiesCriteria(PartiesCriteria partiesCriteria) {
		this.partyName = partiesCriteria.partyName == null ? null : partiesCriteria.partyName.copy();
		this.partyName = partiesCriteria.partyName;
	}



	public StringFilter getPartyName() {
		return partyName;
	}



	public void setPartyName(StringFilter partyName) {
		this.partyName = partyName;
	}

	public StringFilter partyName() {
		if (partyName == null) {
			partyName = new StringFilter();
		}
		return partyName;
	}

	@Override
	public Criteria copy() {
		return new PartiesCriteria(this);
	}

}
