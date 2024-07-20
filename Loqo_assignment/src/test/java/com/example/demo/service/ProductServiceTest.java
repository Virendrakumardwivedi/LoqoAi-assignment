package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Sort;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

public class ProductServiceTest {

    @InjectMocks
    private ProductService proService;

    @Mock
    private ProductRepository proRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFilteredAndSortedProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Product1", "Category1", 100.0, true, 4.5, new Date()));
        products.add(new Product(2L, "Product2", "Category2", 150.0, false, 4.0, new Date()));

        when(proRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(products);

        List<Product> result = proService.getFilteredAndSortedProducts("Category1", 50.0, 200.0, true, "price", "asc");
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
