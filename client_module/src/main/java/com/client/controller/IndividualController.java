/**
 * 
 */
package com.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.client.form.CaseCategory;
import com.client.form.Country;
import com.client.form.IndividualDTO;
import com.client.form.InvolvedParty;
import com.client.form.State;
import com.service.IndividualService;

/**
 * @author haho
 *
 */
@Controller
@RequestMapping("/indiv")
public class IndividualController {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@Autowired
	private IndividualService individualService;

	@RequestMapping(value = "/getIndivList", method = RequestMethod.GET)
	@ResponseBody
	public List<IndividualDTO> getIndivList() {
		try {
			List<IndividualDTO> individuals = individualService.getIndividualList();
			return individuals;
		} catch (Exception ex) {
			this.LOGGER.error(ex.getMessage());
			return null;
		}
	}

	@RequestMapping(value = "/displayIndivList", method = RequestMethod.GET)
	public ModelAndView displayTCPIPList(HttpServletRequest request) {
		return new ModelAndView("indivList");
	}

	@RequestMapping(value = "/displayIndiv", method = RequestMethod.GET)
	public ModelAndView displayTCPIP(HttpServletRequest request) {
		return new ModelAndView("indiv");
	}

	@RequestMapping(value = "/getCaseCategories", method = RequestMethod.GET)
	@ResponseBody
	public List<CaseCategory> getCaseCategories() {
		return individualService.getCaseCategories();
	}

	@RequestMapping(value = "/getInvolvedParties", method = RequestMethod.GET)
	@ResponseBody
	public List<InvolvedParty> getInvolvedParties() {
		return individualService.getInvolvedParties();
	}

	@RequestMapping(value = "/getCountries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> getCountries() {
		return individualService.getCountries();
	}

	@RequestMapping(value = "/getStates", method = RequestMethod.GET)
	@ResponseBody
	public List<State> getStates() {
		return individualService.getStates();
	}
}