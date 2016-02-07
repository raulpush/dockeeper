package com.muri.web.controller;

import com.muri.web.model.Paragraph;
import com.muri.web.model.Search;
import com.muri.web.model.User;
import com.muri.web.service.DocumentService;
import com.muri.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;


@Controller
public class SearchController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private UserService userService;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "queryForm", method = RequestMethod.GET)
    public String search(Model model) {
        Search srch = new Search();
        srch.setContent("Login");
        model.addAttribute("search", srch);
        return "queryForm";
    }

    @PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "queryForm", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("search") Search search,
            BindingResult result, Principal principal) {
		System.out.println("result has errors: " + result.hasErrors());
		System.out.println("Goal set: " + search.getContent());
        final String loggedInUserName = principal.getName();
        User us = userService.findByUsername(loggedInUserName);
		if(result.hasErrors()) {
            return "queryForm";
		}
        List<Paragraph> aux = documentService.queryDocuments(search, us);
        model.addAttribute("searchList", aux);
        return "queryForm";
	}


    @RequestMapping(value = "/paragraphs/{id}", method = RequestMethod.GET)
    public @ResponseBody Paragraph findAllActivities(@PathVariable("id") String id,Principal principal) {
        final String loggedInUserName = principal.getName();
        User us = userService.findByUsername(loggedInUserName);
        return documentService.getDocument(id,us);
    }


	
}
