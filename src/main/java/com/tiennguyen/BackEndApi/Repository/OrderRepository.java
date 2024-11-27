package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
