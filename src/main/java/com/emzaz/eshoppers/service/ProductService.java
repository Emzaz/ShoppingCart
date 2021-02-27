package com.emzaz.eshoppers.service;

import com.emzaz.eshoppers.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProductsSortedByName();
}
