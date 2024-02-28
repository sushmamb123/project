package com.xworkz.vendorManagement.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vendorManagement.entity.VendorEntity;

@Repository
public class VendorRepositoryImpl implements VendorRepository {
	@Autowired
	private EntityManagerFactory factory;

	public VendorRepositoryImpl() {
		System.out.println("created a VendorRepositoryImpl");
	}

	@Override
	public void saveRepo(VendorEntity entity) {
		System.out.println(entity + "\n");
		EntityManager entityManager = factory.createEntityManager();
		System.out.println("EntityManager created:" + entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("EntityTransaction created:" + entityTransaction);
		try {
			entityTransaction.begin();
			entityManager.persist(entity);
			entityTransaction.commit();
		} catch (PersistenceException e) {
			System.err.println("PersistenceException:" + e.getMessage());
			entityTransaction.rollback();
		} finally {
			entityManager.close();
			System.out.println("EM closed");
		}

	}

	@Override
	public VendorEntity isExistByNameOrMailOrSite(String vendorName, String email, String website) {
		EntityManager entityManager = factory.createEntityManager();
		System.out.println("EM created..");
		VendorEntity entity = null;
		try {
			Query query = entityManager.createNamedQuery("isExist");
			query.setParameter("vName", vendorName);
			query.setParameter("vEmail", email);
			query.setParameter("vWebsite", website);
			entity = (VendorEntity) query.getSingleResult();
		} catch (PersistenceException e) {
			if (entity == null) {
				return null;
			}
			System.err.println("PersistenceException in exist: " + e.getMessage());
		} finally {
			entityManager.close();
			System.out.println("EM closed");
		}
		return entity;
	}

	@Override
	public List<VendorEntity> findAll() {
		System.out.println("List of vendorEntity in findAll method..");
		EntityManager manager = factory.createEntityManager();
		System.out.println("created EntityManager.");
		List<VendorEntity> list = new ArrayList<VendorEntity>();
		try {
			Query query = manager.createNamedQuery("findAll");
			list = query.getResultList();
			System.out.println("List saved successfully...");
		} catch (PersistenceException e) {
			System.out.println("PersistenceException:" + e.getMessage());
		} finally {
			System.out.println("Closing the resources...");
			manager.close();
		}
		return list;
	}
}
