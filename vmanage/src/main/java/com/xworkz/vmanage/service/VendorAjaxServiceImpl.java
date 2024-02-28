package com.xworkz.vmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanage.entity.VendorEntity;
import com.xworkz.vmanage.repository.VendorRepository;
@Service
public class VendorAjaxServiceImpl implements VendorAjaxService {
	@Autowired
	private VendorRepository vrepo;
	public VendorAjaxServiceImpl() {
		System.out.println("created a VendorAjaxServiceImpl..");
	}

	@Override
	public String isExistByGstNo(String gstNo) {
		List<VendorEntity> list=this.vrepo.findAll();
		for (VendorEntity vendorEntity : list) {
			if(vendorEntity.getGstNo().equals(gstNo)) {
				return "GstNo already exist";
			}
			else {
				System.out.println("GstNo is not exist...");
			}
			
		}
		return null;
	}

	@Override
	public String isExistByContactNo(Long number) {
		List<VendorEntity> list=this.vrepo.findAll();
		for (VendorEntity vendorEntity : list) {
			if(vendorEntity.getContactNo().equals(number)) {
				return "ContactNo is already exist";
			}
			else {
				 System.out.println("ContactNo is not exist.");
			}
		}
		return null;
	}

	@Override
	public String isExistByEmail(String email) {
		List<VendorEntity> list=this.vrepo.findAll();
		for (VendorEntity vendorEntity : list) {
			if(vendorEntity.getEmail().equals(email)) {
				return "Email is already exist";
			}
			else {
				System.out.println("Email is not exist"); 
			}
		}
		return null;
	}

	@Override
	public String isExistByWebsite(String website) {
		List<VendorEntity> list=this.vrepo.findAll();
		for (VendorEntity vendorEntity : list) {
			if(vendorEntity.getWebsite().equals(website)) {
				return "Website is already exist";
			}
			else {
				System.out.println("Website is not exist..");
			}
		}
		return null;
	}

}
