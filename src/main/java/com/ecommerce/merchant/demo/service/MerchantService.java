package com.ecommerce.merchant.demo.service;

import com.ecommerce.merchant.demo.dto.ProductDTO;
import com.ecommerce.merchant.demo.entity.Product;
import com.ecommerce.merchant.demo.mapper.MerchantMapper;
import com.ecommerce.merchant.demo.repo.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
