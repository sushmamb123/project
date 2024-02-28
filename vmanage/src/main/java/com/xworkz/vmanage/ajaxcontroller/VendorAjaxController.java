package com.xworkz.vmanage.ajaxcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.vmanage.service.VendorAjaxService;

@RestController
@RequestMapping("/")
public class VendorAjaxController {
	@Autowired
	private VendorAjaxService ajaxService;
	
	public VendorAjaxController() {
		System.out.println("Created a VendorAjaxController..");
	}
	
	@GetMapping(value = "/uniqueGst/{gstNo}")
	public String onGstNo(@PathVariable String gstNo) {
		String gstInfo=this.ajaxService.isExistByGstNo(gstNo);
		System.out.println("GstNo: "+gstNo);
		return gstInfo;
	}
	
	@GetMapping(value="/uniqueContact/{contactNo}")
	public String onContact(@PathVariable Long contactNo) {
		String contactInfo=this.ajaxService.isExistByContactNo(contactNo);
		System.out.println("ContactNO:"+contactNo);
		return contactInfo;
	}
	
	@GetMapping(value = "/uniqueEmail/{email:.+}")
	public String onEmail(@PathVariable String email) {
		String emailInfo=this.ajaxService.isExistByEmail(email);
		System.out.println("Email:"+email);
		return emailInfo;
	}
	
	@GetMapping(value = "/uniqueWebsite/{website:.+}")
	public String onWebsite(@PathVariable String website) {
		String websiteInfo=this.ajaxService.isExistByEmail(website);
		System.out.println("Website:"+website);
		return websiteInfo;
	}

}
