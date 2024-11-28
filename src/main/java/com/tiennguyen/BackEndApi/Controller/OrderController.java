package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;
    @PostMapping("/add-order")
    public ResponseEntity<?> addOrder(@RequestParam String address, @RequestParam int productId,@RequestParam int quantity){
        ResponseData responseData=new ResponseData();
        responseData.setData(orderServiceImp.createOrder(address,productId,quantity));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/add-order-from-cart")
    public ResponseEntity<?> addOrderFromCart(@RequestParam String address){
        ResponseData responseData=new ResponseData();
        responseData.setData(orderServiceImp.createOrderFromCart(address));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-order-by-status")
    public ResponseEntity<?> getListOrderByStatus(@RequestParam int status){
        ResponseData responseData=new ResponseData();
        responseData.setData(orderServiceImp.getOrderByStatus(status));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-order-by-id")
    public ResponseEntity<?> getOrderById(@RequestParam int orderId){
        ResponseData responseData=new ResponseData();
        responseData.setData(orderServiceImp.getDetailOrderById(orderId));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
