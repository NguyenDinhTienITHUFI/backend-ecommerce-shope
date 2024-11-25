package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.UserDTO;
import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServiceImp  {
    List<UserDTO> getAllUser();
}
