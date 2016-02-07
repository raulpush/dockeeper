package com.muri.web.controller;

import com.muri.web.model.Document;
import com.muri.web.model.Paragraph;
import com.muri.web.model.Search;
import com.muri.web.model.User;
import com.muri.web.service.DocumentService;
import com.muri.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class TreeController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private UserService userService;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "treeForm", method = RequestMethod.GET)
    public String search(Model model, Principal principal) {
        final String loggedInUserName = principal.getName();
        User us = userService.findByUsername(loggedInUserName);
        List<Document> aux = documentService.getDocuments(us);
        model.addAttribute("documents", aux);
        return "treeForm";
    }

    @PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "treeForm", method = RequestMethod.POST)
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
        return "treeForm";
	}
}
