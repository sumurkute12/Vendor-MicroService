package com.cognizant.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservice.model.Vendor;
import com.cognizant.microservice.service.VendorService;
import com.cognizant.microservice.service.VendorStockService;

import lombok.extern.slf4j.Slf4j;
///**
// * 
// * @author Swapnil,Rishav,Amit,Siddhi
// *
// */


@RestController
@RequestMapping("/vendor")
@Slf4j
public class VendorController {

	@Autowired
	VendorStockService vendorStockService;
	@Autowired
	VendorService vendorService;
//	
//	/**
//	 * 
//	 * @param productId
//	 * @param quantity
//	 * @return Vendor
//	 */
	
	
	@GetMapping("/{productId}/{quantity}")
	public Vendor getBestVendor(@PathVariable int productId, @PathVariable int quantity) {
		log.info("GetBestVendor inside controller started");
		return vendorStockService.getVendor(productId, quantity);
	}

//	/**
//	 * 
//	 * @param vendorId
//	 * @return vendor
//	 */
	@GetMapping("/{vendorId}")
	public Vendor getVendor(@PathVariable long vendorId) {
		log.info("GetVendor inside controller started");
		return vendorService.findByVendorId(vendorId);
	}

}
