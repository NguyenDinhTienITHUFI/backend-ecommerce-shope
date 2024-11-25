package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @GetMapping()
    public ResponseEntity<?> getAllUser(){
        ResponseData responseData=new ResponseData();
        responseData.setData(userServiceImp.getAllUser());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
