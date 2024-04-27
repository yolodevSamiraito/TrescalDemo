package com.ecommerce.merchant.demo.mapper;

import com.ecommerce.merchant.demo.dto.ProductDTO;
import com.ecommerce.merchant.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantMapper {

    MerchantMapper INSTANCE = Mappers.getMapper(MerchantMapper.class);

    Product mapProduactDTOtoProduct (ProductDTO productDTO);
    ProductDTO mapProductToProductDTO (Product product);
}
