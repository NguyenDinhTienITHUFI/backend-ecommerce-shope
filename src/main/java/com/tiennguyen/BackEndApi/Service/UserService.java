package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.UserDTO;
import com.tiennguyen.BackEndApi.Repository.UserRepository;
import com.tiennguyen.BackEndApi.Service.Imp.UserServiceImp;
import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUser() {
        List<Users> listUser=userRepository.findAll();
        List<UserDTO>userDTOS=new ArrayList<>();

        for(Users users:listUser){
            UserDTO userDTO=new UserDTO();

            userDTO.setId(users.getId());
            userDTO.setUserName(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullname(users.getFullname());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO getUserById() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        UserDTO userDTO=new UserDTO();
        userDTO.setId(users.getId());
        userDTO.setUserName(users.getUsername());
        userDTO.setFullname(users.getFullname());

        return userDTO;
    }
}
