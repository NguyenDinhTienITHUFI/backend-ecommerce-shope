package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.OrderDTO;
import com.tiennguyen.BackEndApi.entity.Orders;

import java.util.List;

public interface OrderServiceImp {
    boolean createOrder(String address,int productId,int quantity);
    boolean createOrderFromCart(String address);
    List<OrderDTO>  getOrderByStatus(int status);
    OrderDTO getDetailOrderById(int idOrder);
}
