package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prRepository;
	
	  public List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
	        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);

	        Specification<Product> spec = (root, query, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();
	            if (category != null) {
	                predicates.add(criteriaBuilder.equal(root.get("category"), category));
	            }
	            if (minPrice != null && maxPrice != null) {
	                predicates.add(criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
	            }
	            if (inStock != null) {
	                predicates.add(criteriaBuilder.equal(root.get("inStock"), inStock));
	            }
	            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	        };

	        return prRepository.findAll(spec, sort);
	    }

	

}
