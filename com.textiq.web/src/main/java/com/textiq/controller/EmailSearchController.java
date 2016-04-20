package com.textiq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.textiq.model.Email;
import com.textiq.model.EmailDAO;
import com.textiq.model.SearchQuery;

@Controller
public class EmailSearchController {
	@Autowired
	private EmailDAO emailDAO;

	public EmailDAO getEmailDAO() {
		return emailDAO;
	}

	public void setEmailDAO(EmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}

	@RequestMapping(value = "/email/sender", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEmailBySenderName(@RequestParam("sendername") String name) {
		List<Email> emailList = emailDAO.getEmailBySenderName(name);
		ModelAndView model = new ModelAndView();
		model.setViewName("emailDetails");
		model.addObject("emailList", emailList);
		return model;

	}
	
	@RequestMapping(value = "/email/recepient", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEmailByRecepientName(@RequestParam("recepient") String name) {
		List<Email> emailList = emailDAO.getEmailByRecepientName(name);
		ModelAndView model = new ModelAndView();
		model.setViewName("emailDetails");
		model.addObject("emailList", emailList);
		return model;

	}
	
	@RequestMapping(value = "/email/search", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEmailSearchResults(@ModelAttribute("searchQuery") SearchQuery query) {
		List<Email> emailList = new ArrayList<Email>();
		if(query.getSenderName() != null && !query.getSenderName().isEmpty()){
			emailList = emailDAO.getEmailBySenderName(query.getSenderName());
		}else if(query.getRecepientName() != null && !query.getRecepientName().isEmpty()){
			emailList = emailDAO.getEmailByRecepientName(query.getRecepientName());
		}else{
			emailList = emailDAO.getEmailWithDateRange(query.getDatefrom(), query.getDateto());
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("emailDetails");
		model.addObject("emailList", emailList);
		return model;
	}
	
	@RequestMapping(value = "/email/", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEmailHome(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("emailSearch");
		return modelView;
	}
}