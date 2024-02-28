package com.xworkz.vendorManagement.service;

public interface VendorAjaxService {
	String isExistByGstNo(String gstNo);

	String isExistByContactNo(Long number);

	String isExistByEmail(String email);

	String isExistByWebsite(String website);

}
