package com.cognizant.microservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.microservice.exceptions.ProductIdNotFoundException;
import com.cognizant.microservice.exceptions.QuantityLimitExceededException;
import com.cognizant.microservice.model.Vendor;
import com.cognizant.microservice.model.VendorStock;
import com.cognizant.microservice.repo.VendorStockRepository;

@SpringBootTest
class VendorStockServiceImplTest {

	@MockBean
	private VendorStockRepository vendorStockRepository;

	@MockBean
	private VendorService vendorService;

	@Autowired
	private VendorStockService vendorStockService;

	@Test
	void testSave() {
		VendorStock vendorStock = new VendorStock(10, 3, 3, 144, LocalDate.of(2021, 12, 11));
		when(vendorStockRepository.save(vendorStock)).thenReturn(vendorStock);
		vendorStockRepository.save(vendorStock);
		verify(vendorStockRepository).save(vendorStock);
	}

	@Test
	void testGetMaxQuantity() {
		long productId = 1;
		when(vendorStockRepository.getMaxproductQuantity(productId)).thenReturn(100l);
		assertEquals(100, vendorStockService.getMaxQuantity(productId));
	}

	@Test
	void testGetVendor() {
		Vendor vendor = new Vendor(1l, "Amazon", 30.5, 5.0);
		VendorStock vendorStock = new VendorStock(10, 3, 3, 144, LocalDate.of(2021, 12, 11));
		List<Long> vendorIdList = Arrays.asList(1l);
		long productId = 1;
		int quantity = 2;
		when(vendorStockRepository.getVendorIds(productId, quantity)).thenReturn(vendorIdList);
		when(vendorStockRepository.isProductAvailable(productId)).thenReturn(vendorIdList);
		when(vendorStockService.getMaxQuantity(productId)).thenReturn(10l);
		when(vendorService.findByVendorId(1l)).thenReturn(vendor);
		when(vendorStockRepository.getVendorStock(productId, 1l)).thenReturn(vendorStock);
		assertEquals(1l, vendorStockService.getVendor(productId, quantity).getVendorId());
	}

	@Test
	void testGetVendorProductIdNotFoundException() {
		List<Long> vendorIdList = Arrays.asList();
		long productId = 10;
		int quantity = 2;
		when(vendorStockRepository.isProductAvailable(productId)).thenReturn(vendorIdList);
		Exception exception = assertThrows(ProductIdNotFoundException.class,
				() -> vendorStockService.getVendor(productId, quantity));
		assertEquals("Product with the id [" + productId + "] is not present in the vendors stock",
				exception.getMessage());
	}

	@Test
	void testGetVendorQuantityLimitExceededException() {
		List<Long> vendorIdList = Arrays.asList(1l);
		long productId = 1;
		int quantity = 200;
		when(vendorStockRepository.getVendorIds(productId, quantity)).thenReturn(vendorIdList);
		when(vendorStockRepository.isProductAvailable(productId)).thenReturn(vendorIdList);
		when(vendorStockService.getMaxQuantity(productId)).thenReturn(10l);
		Exception exception = assertThrows(QuantityLimitExceededException.class,
				() -> vendorStockService.getVendor(productId, quantity));
		assertEquals(
				"The Quantity You wont is more then the available quantity!, Please enter quantity of the product below limit of [10] units",
				exception.getMessage());

	}

}
