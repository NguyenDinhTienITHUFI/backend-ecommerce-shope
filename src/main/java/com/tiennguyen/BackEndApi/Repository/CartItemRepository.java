package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.CartItem;
import com.tiennguyen.BackEndApi.entity.UserSession;
import com.tiennguyen.BackEndApi.entity.keys.KeyCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    CartItem findCartItemByKeys(KeyCartItem keyCartItem);

    @Query("SELECT c.keys.productId FROM cart_item c WHERE c.keys.sessionId = :sessionId")
    Integer findProductIdsBySessionId(@Param("sessionId") int sessionId);


    @Query("SELECT c.quantity FROM cart_item c WHERE c.keys.sessionId = :sessionId")
    Integer findQuantityProductBySessionId(@Param("sessionId") int sessionId);
    List<CartItem> findCartItemByUserSession(UserSession userSession);

    @Query("SELECT COUNT(c) FROM cart_item c WHERE c.keys.sessionId = :sessionId")
    Integer countCartItemBySessionId(@Param("sessionId") int sessionId);

}
