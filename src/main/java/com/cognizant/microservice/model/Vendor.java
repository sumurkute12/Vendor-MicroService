package com.cognizant.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Vendor {
	@Id
	@Column(name = "vendor_id")
	private long vendorId;
	@Column(name = "vendor_name")
	private String vendorName;
	@Column(name = "delivery_charge")
	private double deliveryCharge;
	private double rating;
}
