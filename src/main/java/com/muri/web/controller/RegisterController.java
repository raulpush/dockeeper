package com.muri.web.controller;

import com.muri.web.model.User;
import com.muri.web.service.UserService;
import com.muri.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	UserValidator userValidator;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);
		
		List<String> professionList = new ArrayList<String>();
		professionList.add("CEO");
		professionList.add("PM");
		professionList.add("LM");
		professionList.add("NPP");
		model.put("professionList", professionList);
		
		return "Registration";
	}


	@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRegistration(@ModelAttribute("userForm") User user,
			Map<String, Object> model, BindingResult result) {

		User us = userService.findByUsername(user.getUsername());
		if(us!=null)
		{
			result.rejectValue("username", "already exist",
					"Please set an unique username!");
			return new ModelAndView("Registration");
		}
		us = userService.findByEmail(user.getEmailAddress());
		if(us!=null)
		{
			result.rejectValue("email", "already exist",
					"Please set an unique email!");
			return new ModelAndView("Registration");
		}
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("Registration");
		}
		if(user.getGenerate_publicKey())
		{
			//TODO generate key
		}
		userService.save(us);
		
		return new ModelAndView("RegistrationSuccess");
	}
}
