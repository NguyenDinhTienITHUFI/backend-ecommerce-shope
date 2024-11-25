package com.tiennguyen.BackEndApi.Security;

import com.tiennguyen.BackEndApi.Repository.UserRepository;
import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users=userRepository.findByUsername(username);
        if(users==null)
        {
            throw new UsernameNotFoundException("User not exist!");
        }

        return new User(username,users.getPassword(),new ArrayList<>());
    }
}
