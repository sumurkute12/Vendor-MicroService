package com.cognizant.microservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microservice.exceptions.VendorNotFoundException;
import com.cognizant.microservice.model.Vendor;
import com.cognizant.microservice.repo.VendorRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class VendorServiceImpl implements VendorService {
    @Autowired
    VendorRepository vendorRepository;

    @Override
    public Vendor findByVendorId(long vendorId) {
        log.info("FindByVendorId inside VendorServiceImpl started...");
    	Vendor vendor = vendorRepository.findById(vendorId);
        if (vendor == null) {
            throw new VendorNotFoundException("Vendore With id [" + vendorId + "] not found");
        }
        return vendorRepository.findById(vendorId);
    }
    
}