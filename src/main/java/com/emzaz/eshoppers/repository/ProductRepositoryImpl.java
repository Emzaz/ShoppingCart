package com.emzaz.eshoppers.repository;

import com.emzaz.eshoppers.dtos.ProductDTO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    private static final List<ProductDTO> ALL_PRODUCTS = Arrays.asList(
            new ProductDTO(
                    "Apple iPad",
                    "Apple iPad 10.2 32GB",
                    BigDecimal.valueOf(369.99)
            ),
            new ProductDTO(
                    "Headphones",
                    "Jabra Elite Bluetooth Headphones",
                    BigDecimal.valueOf(249.99)
            ),
            new ProductDTO(
                    "Microsoft Surface Pro",
                    "Microsoft Surface Pro 7 12.3",
                    BigDecimal.valueOf(799.99)
            ),
            new ProductDTO(
                    "Amazon Echo Dot",
                    "Amazon Echo Dot (3rd gen) with Alexa - charcol",
                    BigDecimal.valueOf(34.99)
            )
    );

    @Override
    public List<ProductDTO> findAllProducts() {
        return ALL_PRODUCTS;
    }
}
