package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.UserSessionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class UserSessionController {
    @Autowired
    UserSessionServiceImp userSessionServiceImp;
    @PostMapping("/add-cart")
    public ResponseEntity<?> addCart(@RequestParam int idProduct, @RequestParam int quantity){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.insertToCart(idProduct,quantity));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/minus")
    public ResponseEntity<?>minusProduct(@RequestParam int idProduct){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.minusProduct(idProduct));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @PostMapping("/plus")
    public ResponseEntity<?>plusProduct(@RequestParam int idProduct){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.plusProduct(idProduct));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<?>deleteProduct(@RequestParam int idProduct){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.deleteCartProduct(idProduct));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?>getCart(){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.getCartByUser());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/count-cart")
    public ResponseEntity<?>getCount(){
        ResponseData responseData=new ResponseData();
        responseData.setData(userSessionServiceImp.countCartQuantity());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
