package com.ecommerce.merchant.demo.controller;

import com.ecommerce.merchant.demo.dto.ProductDTO;
import com.ecommerce.merchant.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productCreated = merchantService.addProduct(productDTO);

        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Integer id){

        return merchantService.findProductById(id);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productUpdated = merchantService.updateProduct(productDTO);

        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {

        return merchantService.deleteProduct(id);
    }
}
