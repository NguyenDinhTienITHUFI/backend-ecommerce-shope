package com.tiennguyen.BackEndApi.Service.Imp;

public interface OrderServiceImp {
    boolean createOrder(String address,int productId,int quantity);
}
