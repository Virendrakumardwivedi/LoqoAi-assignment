package com.example.demo.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductTestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
    }

    @Test
    void testGetProducts() throws Exception {

    	List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Product1", "Category1", 100.0, true, 4.5, new Date()));
        products.add(new Product(2L, "Product2", "Category2", 150.0, false, 4.0, new Date()));

        when(productService.getFilteredAndSortedProducts(anyString(), anyDouble(), anyDouble(), anyBoolean(), anyString(), anyString()))
                .thenReturn(products);

        mockMvc.perform(get("/products")
                .param("category", "Category1")
                .param("minPrice", "50")
                .param("maxPrice", "200")
                .param("inStock", "true")
                .param("sortField", "price")
                .param("sortOrder", "asc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Product1")))
                .andExpect(jsonPath("$[1].name", is("Product2")));
    }
}
