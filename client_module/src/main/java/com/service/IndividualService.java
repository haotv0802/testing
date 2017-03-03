/**
 * 
 */
package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.client.form.CaseCategory;
import com.client.form.Country;
import com.client.form.IndividualDTO;
import com.client.form.InvolvedParty;
import com.client.form.State;

/**
 * @author haho
 *
 */
@Service
public class IndividualService {

	public List<State> getStates() {
		List<State> countries = new ArrayList<State>();
		State country = new State();
		country.setId(1);
		country.setName("State 1");
		countries.add(country);

		country = new State();
		country.setId(2);
		country.setName("State 2");
		countries.add(country);

		return countries;
	}

	public List<Country> getCountries() {
		List<Country> countries = new ArrayList<Country>();
		Country country = new Country();
		country.setId(1);
		country.setName("Country 1");
		countries.add(country);

		country = new Country();
		country.setId(2);
		country.setName("Country 2");
		countries.add(country);

		return countries;
	}

	public List<InvolvedParty> getInvolvedParties() {
		List<InvolvedParty> involvedParties = new ArrayList<InvolvedParty>();
		InvolvedParty involvedParty = new InvolvedParty();
		involvedParty.setId(1);
		involvedParty.setName("Party 1");
		involvedParties.add(involvedParty);

		involvedParty = new InvolvedParty();
		involvedParty.setId(2);
		involvedParty.setName("Party 2");
		involvedParties.add(involvedParty);

		return involvedParties;
	}

	public List<CaseCategory> getCaseCategories() {
		List<CaseCategory> caseCategories = new ArrayList<CaseCategory>();
		CaseCategory caseCategory = new CaseCategory();
		caseCategory.setId(1);
		caseCategory.setName("Category 1");
		caseCategories.add(caseCategory);

		caseCategory = new CaseCategory();
		caseCategory.setId(2);
		caseCategory.setName("Category 2");
		caseCategories.add(caseCategory);

		return caseCategories;
	}

	public List<IndividualDTO> getIndividualList() {
		List<IndividualDTO> individuals = new ArrayList<IndividualDTO>();
		IndividualDTO individual = new IndividualDTO();
		individual.setImxRef("1508100003");
		individual.setCaseRef("US12620");
		individual.setSubRef("1508100002");
		individual.setCaseCategory("Contract");
		individual.setCurrency("USD");
		individual.setClient("SGT CLI1");
		individual.setDebtor("SOCIETE");
		individuals.add(individual);

		individual = new IndividualDTO();
		individual.setImxRef("1508100004");
		individual.setCaseRef("ER23423");
		individual.setSubRef("1508100003");
		individual.setCaseCategory("Contract");
		individual.setCurrency("USD");
		individual.setClient("SGT CLI1");
		individual.setDebtor("SOCIETE");
		individuals.add(individual);

		individual = new IndividualDTO();
		individual.setImxRef("1508100007");
		individual.setCaseRef("ER23423");
		individual.setSubRef("1508100003");
		individual.setCaseCategory("Contract");
		individual.setCurrency("USD");
		individual.setClient("SGT CLI1");
		individual.setDebtor("SOCIETE");
		individuals.add(individual);

		individual = new IndividualDTO();
		individual.setImxRef("1508100008");
		individual.setCaseRef("ER23423");
		individual.setSubRef("1508100003");
		individual.setCaseCategory("Contract");
		individual.setCurrency("USD");
		individual.setClient("SGT CLI1");
		individual.setDebtor("SOCIETE");
		individuals.add(individual);

		individual = new IndividualDTO();
		individual.setImxRef("1508100009");
		individual.setCaseRef("ER23423");
		individual.setSubRef("1508100003");
		individual.setCaseCategory("Contract");
		individual.setCurrency("USD");
		individual.setClient("SGT CLI1");
		individual.setDebtor("SOCIETE");
		individuals.add(individual);

		return individuals;
	}

}
