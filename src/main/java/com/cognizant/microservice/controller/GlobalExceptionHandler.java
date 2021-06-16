package com.cognizant.microservice.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.microservice.dto.ErrorResponseDto;
import com.cognizant.microservice.exceptions.ProductIdNotFoundException;
import com.cognizant.microservice.exceptions.QuantityLimitExceededException;
import com.cognizant.microservice.exceptions.VendorNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ VendorNotFoundException.class })
	public ErrorResponseDto vendorNotFoundException(Exception exception, HttpServletRequest request) {
		log.info("VendorNotFoundException occured...");
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
				exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler({ QuantityLimitExceededException.class })
	public ErrorResponseDto quantityLimitExceedException(Exception exception, HttpServletRequest request) {
		log.info("QuantityLimitExceedException occured...");
		return new ErrorResponseDto(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(),
				exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ ProductIdNotFoundException.class })
	public ErrorResponseDto productNotFoundException(Exception exception, HttpServletRequest request) {
		log.info("ProductNotFoundException occured...");
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
				exception.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler({ Exception.class })
	public ErrorResponseDto exception(Exception exception, HttpServletRequest request) {
		log.info("Exception occured...");
		return new ErrorResponseDto(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(),
				exception.getMessage(), request.getRequestURI());
	}
}
