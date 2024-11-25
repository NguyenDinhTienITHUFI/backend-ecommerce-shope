package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.UserDTO;
import com.tiennguyen.BackEndApi.Payload.Request.SignUpRequest;
import com.tiennguyen.BackEndApi.Repository.UserRepository;
import com.tiennguyen.BackEndApi.Service.Imp.LoginServiceImp;
import com.tiennguyen.BackEndApi.entity.Roles;
import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
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
    public boolean checkLogin(String username, String password) {
      Users user= userRepository.findByUsername(username);
     return passwordEncoder.matches(password,user.getPassword());


    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Roles roles=new Roles();
        roles.setId(signUpRequest.getRoleId());
        Users users=new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUsername(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);
        try {
            userRepository.save(users);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }


    }
}
