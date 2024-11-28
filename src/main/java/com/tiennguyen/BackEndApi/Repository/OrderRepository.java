package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Orders;
import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findOrdersByStatusAndUsers(int status, Users users);
    Orders findOrdersById(int id);
}
