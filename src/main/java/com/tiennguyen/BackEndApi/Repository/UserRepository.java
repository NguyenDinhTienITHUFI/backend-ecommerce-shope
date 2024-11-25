package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    List<Users> findByUsernameAndPassword(String username, String password);
    Users findByUsername(String username);

}
