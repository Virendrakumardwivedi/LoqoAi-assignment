package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService prService;
	
	@GetMapping("/products")
	public List<Product> getProducts(@RequestParam(required = false) String category,
	                                     @RequestParam(required = false) Double minPrice,
	                                     @RequestParam(required = false) Double maxPrice,
	                                     @RequestParam(required = false) Boolean inStock,
	                                     @RequestParam(required = false, defaultValue = "price") String sortField,
	                                     @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
	        return prService.getFilteredAndSortedProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
	}

}
