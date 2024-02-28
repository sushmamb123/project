package com.xworkz.vendorManagement.service;

import com.xworkz.vendorManagement.entity.VendorEntity;

public interface VendorService {
	VendorEntity save(VendorEntity entity);

	String isExistByNameOrMailOrSite(String vendorName, String email, String website);

	boolean sendMail(String email);

}
