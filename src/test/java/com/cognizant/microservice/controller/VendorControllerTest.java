package com.cognizant.microservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cognizant.microservice.exceptions.ProductIdNotFoundException;
import com.cognizant.microservice.exceptions.QuantityLimitExceededException;
import com.cognizant.microservice.exceptions.VendorNotFoundException;
import com.cognizant.microservice.model.Vendor;
import com.cognizant.microservice.service.VendorService;
import com.cognizant.microservice.service.VendorStockService;

@SpringBootTest
@AutoConfigureMockMvc
class VendorControllerTest {

	@Autowired
	private MockMvc mock;
	@MockBean
	private VendorStockService vendorStockService;
	@MockBean
	private VendorService vendorService;

	@Test
	void testGetBestVendor() throws Exception {
		Vendor vendor = new Vendor(1, "Amazon", 30.5, 5.0);
		int productId = 3;
		int quantity = 10;
		when(vendorStockService.getVendor(productId, quantity)).thenReturn(vendor);
		MvcResult mvcResult = mock.perform(get("/vendor/" + productId + "/" + quantity)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Amazon"));
	}

	@Test
	void testGetBestVendorProductIdNotFoundException() throws Exception {
		int productId = 101;
		int quantity = 10;
		when(vendorStockService.getVendor(productId, quantity)).thenThrow(new ProductIdNotFoundException(
				"Product with the id [" + productId + "] is not present in the vendors stock"));
		MvcResult mvcResult = mock.perform(get("/vendor/" + productId + "/" + quantity)).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString()
				.contains("Product with the id [" + productId + "] is not present in the vendors stock"));
	}

	@Test
	void testGetBestVendorQuantityLimitExceededException() throws Exception {
		int productId = 1;
		int quantity = 1000;
		when(vendorStockService.getVendor(productId, quantity)).thenThrow(new QuantityLimitExceededException(
				"The Quantity You wont is more then the available quantity!, Please enter quantity of the product below limit of 1000 units"));
		MvcResult mvcResult = mock.perform(get("/vendor/" + productId + "/" + quantity)).andReturn();
		assertEquals(409, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains(
				"The Quantity You wont is more then the available quantity!, Please enter quantity of the product below limit of 1000 units"));
	}

	@Test
	void testGetVendor() throws Exception {
		Vendor vendor = new Vendor(1, "Amazon", 30.5, 5.0);
		int vendorId = 1;
		when(vendorService.findByVendorId(vendorId)).thenReturn(vendor);
		MvcResult mvcResult = mock.perform(get("/vendor/" + vendorId)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Amazon"));
	}

	@Test
	void testGetVendorVendorNotFoundException() throws Exception {
		int vendorId = 50;
		when(vendorService.findByVendorId(vendorId))
				.thenThrow(new VendorNotFoundException("Vendore With id [" + vendorId + "] not found"));
		MvcResult mvcResult = mock.perform(get("/vendor/" + vendorId)).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true,
				mvcResult.getResponse().getContentAsString().contains("Vendore With id [" + vendorId + "] not found"));
	}

}
