package com.xworkz.vmanage.service;

import com.xworkz.vmanage.entity.VendorEntity;

public interface VendorService {
	VendorEntity save(VendorEntity entity);
	String isExistByNameOrMailOrSite(String vendorName,String email,String website);
	boolean sendMail(String email);

}
