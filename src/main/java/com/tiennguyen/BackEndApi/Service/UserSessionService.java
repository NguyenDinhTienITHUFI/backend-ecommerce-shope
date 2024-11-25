package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.CartDTO;
import com.tiennguyen.BackEndApi.DTO.ProductsDTO;
import com.tiennguyen.BackEndApi.Repository.CartItemRepository;
import com.tiennguyen.BackEndApi.Repository.ProductRepository;
import com.tiennguyen.BackEndApi.Repository.UserRepository;
import com.tiennguyen.BackEndApi.Repository.UserSessionRepository;
import com.tiennguyen.BackEndApi.Service.Imp.UserSessionServiceImp;
import com.tiennguyen.BackEndApi.entity.CartItem;
import com.tiennguyen.BackEndApi.entity.Products;
import com.tiennguyen.BackEndApi.entity.UserSession;
import com.tiennguyen.BackEndApi.entity.Users;
import com.tiennguyen.BackEndApi.entity.keys.KeyCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSessionService implements UserSessionServiceImp {
    @Autowired
    UserSessionRepository userSessionRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public boolean insertToCart( int idProduct, int quantity) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users userss=userRepository.findByUsername(username);
        int userId=userss.getId();
        boolean isInsert = false;

        if (userId > 0 && idProduct > 0 && quantity > 0) {

            UserSession userSession = userSessionRepository.findByUsersId(userId);


            if (userSession == null) {

                userSession = new UserSession();
                Users users = new Users();
                users.setId(userId);
                userSession.setUsers(users);
                userSessionRepository.save(userSession);
            }



            CartItem cartItem = new CartItem();
            KeyCartItem keyCartItem = new KeyCartItem();
            keyCartItem.setSessionId(userSession.getId());
            keyCartItem.setProductId(idProduct);

            cartItem.setKeys(keyCartItem);

            CartItem existingCartItem = cartItemRepository.findCartItemByKeys(keyCartItem);
            if (existingCartItem != null) {
                existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
                cartItemRepository.save(existingCartItem);
            } else {
                cartItem.setQuantity(quantity);
                cartItemRepository.save(cartItem);
            }


            userSession.setTotal(userSession.getTotal() + calc(quantity, idProduct));
            userSessionRepository.save(userSession);

            isInsert = true;
        } else {
            return isInsert;
        }

        return isInsert;
    }


    @Override
    public boolean minusProduct(int product_id) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        int userId=users.getId();
        UserSession userSession = userSessionRepository.findByUsersId(userId);
        int sessionId=userSession.getId();

        boolean isSuccess=false;
        KeyCartItem keyCartItem=new KeyCartItem();
        keyCartItem.setProductId(product_id);
        keyCartItem.setSessionId(sessionId);

        CartItem cartItem=new CartItem();
        cartItem=cartItemRepository.findCartItemByKeys(keyCartItem);
        cartItem.setQuantity(cartItem.getQuantity()-1);

        if(cartItem.getQuantity()<=0)
        {
            return deleteCartProduct(product_id);
        }
        else {
            cartItemRepository.save(cartItem);
            userSession=userSessionRepository.findById(sessionId);
            userSession.setTotal(calc(cartItem.getQuantity(),product_id));
            userSessionRepository.save(userSession);
            isSuccess=true;
            return isSuccess;
        }

    }

    @Override
    public boolean plusProduct(int product_id) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        int userId=users.getId();
        UserSession userSession = userSessionRepository.findByUsersId(userId);
        int sessionId=userSession.getId();

        boolean isSuccess=false;
        KeyCartItem keyCartItem=new KeyCartItem();
        keyCartItem.setProductId(product_id);
        keyCartItem.setSessionId(sessionId);

        CartItem cartItem=new CartItem();
        cartItem=cartItemRepository.findCartItemByKeys(keyCartItem);
        cartItem.setQuantity(cartItem.getQuantity()+1);

        if(cartItem.getQuantity()<=0)
        {
            return deleteCartProduct(product_id);
        }
        else {
            cartItemRepository.save(cartItem);
            userSession=userSessionRepository.findById(sessionId);
            userSession.setTotal(calc(cartItem.getQuantity(),product_id));
            userSessionRepository.save(userSession);
            isSuccess=true;
            return isSuccess;
        }
    }

    @Override
    public boolean deleteCartProduct( int productId) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        int userId=users.getId();
        boolean isDelete=false;
        UserSession userSession=userSessionRepository.findByUsersId(userId);
        KeyCartItem keyCartItem=new KeyCartItem();
        keyCartItem.setSessionId(userSession.getId());
        keyCartItem.setProductId(productId);
        CartItem cartItem=cartItemRepository.findCartItemByKeys(keyCartItem);
        if(cartItem==null||userSession==null){
            return isDelete;
        }
        else {
            cartItemRepository.delete(cartItem);
            CartItem checkNull=cartItemRepository.findCartItemByKeys(keyCartItem);
            Integer checkNotEmpty=cartItemRepository.findProductIdsBySessionId(userSession.getId());
            if(checkNull ==null && checkNotEmpty ==null){
                userSession.setTotal(0);
                userSessionRepository.save(userSession);
            }else {
                System.out.println(calc(cartItem.getQuantity(),productId));
                userSession.setTotal(calc(cartItem.getQuantity(),productId));
                userSessionRepository.save(userSession);
            }



            isDelete=true;
            return isDelete;
        }

    }

    public double calc(int quatity,int idProduct){
        Products products=new Products();
        products=productRepository.findById(idProduct);

        return quatity*products.getPrice();
    }

    public CartDTO getCartByUser(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        int userId=users.getId();
        UserSession userSession=userSessionRepository.findByUsersId(users.getId());
        List<CartItem> cartItems=cartItemRepository.findCartItemByUserSession(userSession);
        List<ProductsDTO> productsList=new ArrayList<>();
        CartDTO cartDTO=new CartDTO();
        for(CartItem cartItem:cartItems){
            ProductsDTO productsDTO=new ProductsDTO();
            Products productCart= cartItem.getProducts();

            Products products=productRepository.findById(productCart.getId());
            productsDTO.setId(products.getId());
            productsDTO.setTitle(products.getTitle());
            productsDTO.setImage(products.getImage());
            productsDTO.setPrice(products.getPrice());
            productsDTO.setStock(products.getStock());
            productsDTO.setQuantity(cartItem.getQuantity());

            productsList.add(productsDTO);
        }
        cartDTO.setProductsDTO(productsList);
        cartDTO.setTotal(userSession.getTotal());
        return cartDTO;

    }

    @Override
    public Integer countCartQuantity() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Users users=userRepository.findByUsername(username);
        int userId=users.getId();
        int count=0;
        UserSession userSession= userSessionRepository.findByUsersId(userId);
        count=cartItemRepository.countCartItemBySessionId(userSession.getId());
        return count;
    }
}
