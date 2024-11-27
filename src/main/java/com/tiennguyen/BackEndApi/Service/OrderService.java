package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.Repository.OrderItemRepository;
import com.tiennguyen.BackEndApi.Repository.OrderRepository;
import com.tiennguyen.BackEndApi.Repository.ProductRepository;
import com.tiennguyen.BackEndApi.Repository.UserRepository;
import com.tiennguyen.BackEndApi.Service.Imp.OrderServiceImp;
import com.tiennguyen.BackEndApi.entity.OrderItems;
import com.tiennguyen.BackEndApi.entity.Orders;
import com.tiennguyen.BackEndApi.entity.Products;
import com.tiennguyen.BackEndApi.entity.Users;
import com.tiennguyen.BackEndApi.entity.keys.KeyOrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean createOrder(String address, int productId, int quantity) {
        boolean isInsertSuccess=false;
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        Products products=productRepository.findById(productId);
        if(quantity>products.getStock()){
            return false;
        }
        else {
            Orders orders=new Orders();
            orders.setUsers(users);
            orders.setAddress(address);
            orderRepository.save(orders);
            OrderItems orderItems=new OrderItems();
            KeyOrderItems keyOrderItems=new KeyOrderItems();
            keyOrderItems.setOrderId(orders.getId());
            keyOrderItems.setProductId(productId);
            orderItems.setKeys(keyOrderItems);


            orderItems.setQuantity(quantity);
            orderItemRepository.save(orderItems);
            orders.setTotalPrice(quantity*products.getPrice());
            orders.setStatus(1);
            orderRepository.save(orders);
            products.setStock(products.getStock()-quantity);
            productRepository.save(products);
            isInsertSuccess=true;
            return isInsertSuccess;
        }

    }

}
