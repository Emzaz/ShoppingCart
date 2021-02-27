package com.emzaz.eshoppers.web;


import com.emzaz.eshoppers.repository.ProductRepositoryImpl;
import com.emzaz.eshoppers.service.ProductService;
import com.emzaz.eshoppers.service.ProductServiceImpl;
import com.emzaz.eshoppers.dtos.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServlet.class);

    private ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Serving home page");

        List<ProductDTO> allProducts = productService.findAllProductsSortedByName();

        LOGGER.info("Total product found {}", allProducts.size());

        req.setAttribute("products", allProducts);

        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
