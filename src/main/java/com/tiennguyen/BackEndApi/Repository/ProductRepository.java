package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findById(int id);
}
