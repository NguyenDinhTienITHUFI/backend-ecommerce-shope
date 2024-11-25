package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.CartDTO;

public interface UserSessionServiceImp {
    boolean insertToCart(int idProduct,int quantity);
    boolean minusProduct(int product_id);
    boolean plusProduct(int product_id);
    boolean deleteCartProduct(int productId);
    CartDTO getCartByUser();
    Integer countCartQuantity();
}
