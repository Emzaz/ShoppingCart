package com.emzaz.eshoppers.repository;

import com.emzaz.eshoppers.dtos.ProductDTO;

import java.util.List;

public interface ProductRepository {
    List<ProductDTO> findAllProducts();
}
