package com.tiennguyen.BackEndApi.Service.Imp;

public interface OrderItemServiceImp {
    boolean createOrderItem(int orderId,int productId,int quantity);
}
