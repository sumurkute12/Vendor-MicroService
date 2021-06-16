package com.cognizant.microservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.microservice.model.VendorStock;

public interface VendorStockRepository extends JpaRepository<VendorStock, Long> {

	// @Query("select c.menuItemId from Cart c where c.userId=:userId")

	@Query("select v.vendorId from VendorStock v where v.productId=:productId and stockInHand>=:quantity ")
	public List<Long> getVendorIds(long productId, int quantity);

	@Query("from VendorStock v where v.productId=:productId and vendorId=:vendorId")
	public VendorStock getVendorStock(long productId, long vendorId);

	@Query("select max(v.stockInHand) from VendorStock v where v.productId=:productId")
	public long getMaxproductQuantity(long productId);

	@Query("select v.vendorId from VendorStock v where v.productId=:productId")
	public List<Long> isProductAvailable(long productId);
}
