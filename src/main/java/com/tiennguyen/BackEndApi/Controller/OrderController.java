package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
