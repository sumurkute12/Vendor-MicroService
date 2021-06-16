package com.cognizant.microservice.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
///**
// * 
// * @author Swapnil,Rishav,Amit,Siddhi
// *
// */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "vendor_id")
	private long vendorId;

	@Column(name = "stock_in_hand")
	private int stockInHand;
	@Column(name = "expected_stock_replinshment_date")
	private LocalDate expectedStockReplinshmentDate;

}
