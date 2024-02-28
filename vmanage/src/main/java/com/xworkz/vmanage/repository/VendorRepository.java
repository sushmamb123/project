package com.xworkz.vmanage.repository;

import java.util.List;

import com.xworkz.vmanage.entity.VendorEntity;

public interface VendorRepository {
	void saveRepo(VendorEntity entity);
	VendorEntity isExistByNameOrMailOrSite(String vendorName,String email,String website);
	List<VendorEntity> findAll();

}
