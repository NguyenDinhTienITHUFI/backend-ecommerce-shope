package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession,Integer> {
    UserSession findById(int id);
    UserSession findByUsersId(int id);
    //List<UserSession> findByUsersId(int id);

}
