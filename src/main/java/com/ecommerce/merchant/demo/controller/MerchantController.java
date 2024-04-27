package com.ecommerce.merchant.demo.controller;

import com.ecommerce.merchant.demo.dto.ProductDTO;
import com.ecommerce.merchant.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @GetMapping("/fetchAllProducts")
    public ResponseEntity<List<ProductDTO>> fetchAllProducts(){
        List<ProductDTO> products = merchantService.findAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
