package com.emzaz.eshoppers.service;

import com.emzaz.eshoppers.dtos.ProductDTO;
import com.emzaz.eshoppers.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProductsSortedByName() {
        List<ProductDTO> productList = productRepository.findAllProducts();

        productList.sort((ProductDTO p1, ProductDTO p2) -> p1.getName().compareTo(p2.getName()));

        return productList;
    }
}
