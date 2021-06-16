package com.cognizant.microservice.service;

import com.cognizant.microservice.model.Vendor;
import com.cognizant.microservice.model.VendorStock;
///**
// * 
// * @author Swapnil,Rishav,Amit,Siddhi
// *
// */
public interface VendorStockService {
//	/**
//	 * 
//	 * @param vendorStock
//	 * @return vendorStock
//	 */
	public VendorStock save(VendorStock vendorStock);
//	/**
//	 * 
//	 * @param productId
//	 * @param quanity
//	 * @return Vendor
//	 */
	public Vendor getVendor(long productId, int quanity);
//	/**
//	 * 
//	 * @param productId
//	 * @return maxQuantity
//	 */
	public long getMaxQuantity(long productId);
}
