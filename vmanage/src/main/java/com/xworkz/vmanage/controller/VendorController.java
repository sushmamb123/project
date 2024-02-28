package com.xworkz.vmanage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.vmanage.entity.VendorEntity;
import com.xworkz.vmanage.service.VendorService;
@Controller
@RequestMapping("/")
@EnableWebMvc
 public class VendorController {
	@Autowired
	private VendorService service;
	public VendorController() {
		System.out.println("Created a VendorController");
	}
	@PostMapping("/vendor")
	public String save(@Valid VendorEntity entity,BindingResult bindingResult,Model model) {
		System.out.println("Details of the vendor:"+entity);
		System.out.println("Vendor DTO has errors:"+bindingResult.hasErrors());
		model.addAttribute("entity", entity);
		if(bindingResult.hasErrors()) {
			List<ObjectError> objectErrors=bindingResult.getAllErrors();
			objectErrors.forEach(a->System.err.println(a.getObjectName()+" "+a.getDefaultMessage()));
			model.addAttribute("error", objectErrors);
			
			return "Registration.jsp";
		}
		else {
			model.addAttribute("noErrors", "Details saved");
			
			 String uniqueError=service.isExistByNameOrMailOrSite(entity.getVendorName(),entity.
			 getEmail(),entity.getWebsite()); 
			 if(uniqueError!=null) {
				 
			 model.addAttribute("uniqueError", uniqueError);
			 return "Registration.jsp";
			 }
			
		}
		this.service.save(entity);
		this.service.sendMail(entity.getEmail());
		return "RegistrationSuccess.jsp";
		
	}


}
