package com.xworkz.vendorManagement.repository;

import java.util.List;

import com.xworkz.vendorManagement.entity.VendorEntity;

public interface VendorRepository {
	void saveRepo(VendorEntity entity);

	VendorEntity isExistByNameOrMailOrSite(String vendorName, String email, String website);

	List<VendorEntity> findAll();

}
