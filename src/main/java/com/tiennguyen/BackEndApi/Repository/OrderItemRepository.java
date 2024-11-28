package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.OrderItems;
import com.tiennguyen.BackEndApi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,Integer> {
    List<OrderItems> findOrderItemsByOrders(Orders orders);
}
