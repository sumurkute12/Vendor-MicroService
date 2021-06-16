package com.cognizant.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.microservice.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	public Vendor findById(long vendorId);
}
