package com.xworkz.vmanage.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Data
@Table(name="vendor_details")
@RequiredArgsConstructor
@Getter
@Setter
@NamedQuery(name = "isExist",query = "SELECT vm FROM VendorEntity as vm WHERE vm.vendorName=:vName OR vm.email=:vEmail OR vm.website=:vWebsite")
@NamedQuery(name = "findAll",query = "SELECT vm FROM VendorEntity vm")
public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;
	
	@NotNull(message = "Vendor Name is not empty..")
	@Size(max = 10,min=3,message = "Please enter valid VendorName")
	@Column(name = "v_vendorname")
	private String vendorName;

	
	@NotNull(message = "Location is not empty..")
	@Size(max = 10,min=3,message = "Please enter valid Location")

	@Column(name = "v_location")
	private String location;
	
	@NotNull(message = "GSTNO is not empty..")
	@Size(max = 10,min=3,message = "Please enter valid gstNo")

	@Column(name = "v_gstNo")
	private String gstNo;
	
	@NotNull(message = "Company start date is not empty..")
	@Size(max = 10,min=3,message = "Please enter valid companyStartDate")

	@Column(name = "v_companyStartDate")
	private String companyStartDate;
	
	@NotNull(message = "Owner Name is not empty..")
	@Size(max = 10,min=3,message = "Please enter valid OwnerName")

	@Column(name = "v_ownerName")
	private String ownerName;
	
	@NotNull(message = "Service type is not empty..")
	@Column(name = "v_serviceType")
	private String serviceType;
	
	@NotNull(message = "ContactNo is not empty..")
	@Min(value = 10,message = "Please enter valid ContactNO")

	@Column(name = "v_contactNo")
	private Long contactNo;
	
	@NotNull(message = "AlternativeNO is not empty..")
	@Min(value = 10,message = "Please enter valid AlternativeNO")

	@Column(name = "v_alternativeNo")
	private Long alternativeNo;
	
	@NotNull(message = "Email is not empty..")
	@Size(max = 35,min=3,message = "Please enter valid Email")

	@Column(name = "v_email")
	private String email;
	
	@NotNull(message = "Website is not empty..")
	@Size(max = 35,min=3,message = "Please enter valid Website")

	@Column(name = "v_website")
	private String website;
	
	@Column(name = "v_createdBy")
	private String createdBy;
	
	@Column(name = "v_createdDate")
	private LocalDate createdDate;
	
	@Column(name = "v_updatedBy")
	private String updatedBy;
	
	@Column(name = "v_updatedDate")
	private LocalDate updatedDate;
	

}
