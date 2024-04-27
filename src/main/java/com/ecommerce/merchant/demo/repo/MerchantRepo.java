package com.ecommerce.merchant.demo.repo;

import com.ecommerce.merchant.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Product, Integer> {
}
