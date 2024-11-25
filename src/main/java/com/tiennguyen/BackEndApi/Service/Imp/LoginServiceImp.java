package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.UserDTO;
import com.tiennguyen.BackEndApi.Payload.Request.SignUpRequest;
import com.tiennguyen.BackEndApi.entity.Users;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);

}
