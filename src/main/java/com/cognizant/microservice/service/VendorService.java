package com.cognizant.microservice.service;

import com.cognizant.microservice.model.Vendor;
///**
// * 
// * @author Swapnil,Rishav,Amit,Siddhi
// *
// */
public interface VendorService {
//	/**
//	 * 
//	 * @param vendorId
//	 * @return vendor
//	 */
	public Vendor findByVendorId(long vendorId);
}
