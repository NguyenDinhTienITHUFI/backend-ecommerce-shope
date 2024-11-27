package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,Integer> {
}