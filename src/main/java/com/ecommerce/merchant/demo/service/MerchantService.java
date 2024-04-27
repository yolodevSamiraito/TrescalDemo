package com.ecommerce.merchant.demo.service;

import com.ecommerce.merchant.demo.dto.ProductDTO;
import com.ecommerce.merchant.demo.entity.Product;
import com.ecommerce.merchant.demo.mapper.MerchantMapper;
import com.ecommerce.merchant.demo.repo.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MerchantService {

    @Autowired
    MerchantRepo merchantRepo;


    public List<ProductDTO> findAllProducts(){
        List<Product> products = merchantRepo.findAll();

        return products.stream().map(MerchantMapper.INSTANCE::mapProductToProductDTO).collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product savedProduct = merchantRepo.save(MerchantMapper.INSTANCE.mapProduactDTOtoProduct(productDTO));
        return MerchantMapper.INSTANCE.mapProductToProductDTO(savedProduct);
    }

    public ResponseEntity<ProductDTO> findProductById(Integer id) {
        Optional<Product> product = merchantRepo.findById(id);
        return product.map(value -> new ResponseEntity<>(MerchantMapper.INSTANCE.mapProductToProductDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product updatedProduct = merchantRepo.save(MerchantMapper.INSTANCE.mapProduactDTOtoProduct(productDTO));
        return MerchantMapper.INSTANCE.mapProductToProductDTO(updatedProduct);

    }

    public ResponseEntity<Void> deleteProduct(int id) {
        Optional<Product> product = merchantRepo.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        merchantRepo.delete(product.get());

        return ResponseEntity.ok().build();
    }
}
