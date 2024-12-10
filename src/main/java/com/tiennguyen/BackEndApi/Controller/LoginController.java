package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.Request.SignUpRequest;
import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.LoginServiceImp;
import com.tiennguyen.BackEndApi.Utils.JwtUtilsHelper;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
@CrossOrigin()
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @PostMapping("/signin")
    public ResponseEntity<?>signin(@RequestParam String username,@RequestParam String password)
    {
        ResponseData responseData=new ResponseData();
        if(loginServiceImp.checkLogin(username,password)){
            String token=jwtUtilsHelper.generateToken(username);
            responseData.setData(token);
            responseData.setSuccess(true);
        }
        else {
            responseData.setData("Wrong password");
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser(){
        ResponseData responseData=new ResponseData();
        responseData.setData(loginServiceImp.getAllUser());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData=new ResponseData();
        responseData.setData(loginServiceImp.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
