package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
