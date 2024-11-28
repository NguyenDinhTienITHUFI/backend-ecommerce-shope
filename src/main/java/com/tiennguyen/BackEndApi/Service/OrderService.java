package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.OrderDTO;
import com.tiennguyen.BackEndApi.DTO.ProductsDTO;
import com.tiennguyen.BackEndApi.Repository.*;
import com.tiennguyen.BackEndApi.Service.Imp.OrderServiceImp;
import com.tiennguyen.BackEndApi.Service.Imp.UserSessionServiceImp;
import com.tiennguyen.BackEndApi.entity.*;
import com.tiennguyen.BackEndApi.entity.keys.KeyOrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    @Autowired
    UserSessionServiceImp userSessionServiceImp;
    @Autowired
    UserSessionRepository userSessionRepository;
    @Autowired
    CartItemRepository cartItemRepository;

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

    @Override
    public boolean createOrderFromCart(String address) {
        boolean isCreateSuccess=false;
        Orders orders=new Orders();
        orders.setAddress(address);

        double total=0;

        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        UserSession userSession=userSessionRepository.findByUsersId(users.getId());
        List<CartItem> cartItemList=cartItemRepository.findCartItemByUserSession(userSession);
        if(cartItemList !=null){
            orders.setUsers(users);
            orderRepository.save(orders);
            for(CartItem cartItem:cartItemList){
                Products products=cartItem.getProducts();
                KeyOrderItems key = new KeyOrderItems();
                key.setProductId(products.getId());
                key.setOrderId(orders.getId());
                OrderItems orderItems=new OrderItems();
                orderItems.setKeys(key);
                orderItems.setQuantity(cartItem.getQuantity());

                orderItemRepository.save(orderItems);
                if (orderItems.getQuantity()>products.getStock()) {
                    isCreateSuccess=false;
                    return isCreateSuccess;
                }
                products.setStock(products.getStock()-orderItems.getQuantity());
                productRepository.save(products);
                total += orderItems.getQuantity()*products.getPrice();
                isCreateSuccess=userSessionServiceImp.deleteCartProduct(products.getId());
            }
            orders.setStatus(1);
            orders.setTotalPrice(total);
            orderRepository.save(orders);


            return isCreateSuccess;
        }
        else {
            isCreateSuccess=false;
            return isCreateSuccess;
        }

    }

    @Override
    public List<OrderDTO> getOrderByStatus(int status) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        List<Orders> listOrders=orderRepository.findOrdersByStatusAndUsers(status,users);
        List<OrderDTO> orderDTOS=new ArrayList<>();
        for(Orders orders:listOrders){
            OrderDTO orderDTO=new OrderDTO();
            orderDTO.setIdOrder(orders.getId());
            orderDTO.setTotal(orders.getTotalPrice());
            orderDTO.setStatus(orders.getStatus());

            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO getDetailOrderById(int idOrder) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        OrderDTO orderDTO=new OrderDTO();
        Orders orders=orderRepository.findOrdersById(idOrder);
        orderDTO.setStatus(orders.getStatus());
        orderDTO.setTotal(orders.getTotalPrice());
        orderDTO.setIdUser(users.getId());
        List<ProductsDTO> productsDTOS=new ArrayList<>();
        List<OrderItems> orderItemsList=orderItemRepository.findOrderItemsByOrders(orders);
        for(OrderItems orderItems:orderItemsList){
            ProductsDTO productsDTO=new ProductsDTO();
            Products products=orderItems.getProducts();
            productsDTO.setQuantity(orderItems.getQuantity());
            productsDTO.setTitle(products.getTitle());
            productsDTO.setImage(products.getImage());
            productsDTO.setPrice(products.getPrice());
            productsDTO.setId(products.getId());

            productsDTOS.add(productsDTO);
        }
        orderDTO.setProductsDTO(productsDTOS);
        return orderDTO;
    }

}
