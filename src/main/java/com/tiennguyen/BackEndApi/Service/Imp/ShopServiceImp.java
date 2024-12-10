package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.ShopDTO;
import com.tiennguyen.BackEndApi.entity.Shop;

public interface ShopServiceImp {
    ShopDTO getDetailShop(int id);
    ShopDTO getShopById(int id);
}
