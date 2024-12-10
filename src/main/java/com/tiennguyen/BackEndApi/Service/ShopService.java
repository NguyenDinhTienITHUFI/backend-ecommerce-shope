package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.CategoryDTO;
import com.tiennguyen.BackEndApi.DTO.ProductsDTO;
import com.tiennguyen.BackEndApi.DTO.ShopDTO;
import com.tiennguyen.BackEndApi.Repository.ShopRepository;
import com.tiennguyen.BackEndApi.Service.Imp.ShopServiceImp;
import com.tiennguyen.BackEndApi.entity.CategoryShop;
import com.tiennguyen.BackEndApi.entity.Products;
import com.tiennguyen.BackEndApi.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements ShopServiceImp {
    @Autowired
    ShopRepository shopRepository;
    @Override
    public ShopDTO getDetailShop(int id) {
        Optional<Shop> shop = shopRepository.findById(id);

        if (shop.isEmpty()) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        Shop shopData = shop.get();

        shopDTO.setId(shopData.getId());
        shopDTO.setTitle(shopData.getTitle());
        shopDTO.setAddress(shopData.getAddress());
        shopDTO.setImage(shopData.getImage());
        shopDTO.setDescription(shopData.getDescription());
        shopDTO.setCreateDate(shopData.getCreateDate());

        for (CategoryShop categoryShop : shopData.getListCategoryShop()) {
            List<ProductsDTO> productsDTOS = new ArrayList<>();
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(categoryShop.getCategory().getId());
            categoryDTO.setCateName(categoryShop.getCategory().getNameCate());

            for (Products products : categoryShop.getCategory().getListProduct()) {
                ProductsDTO productsDTO = new ProductsDTO();
                productsDTO.setTitle(products.getTitle());
                productsDTO.setPrice(products.getPrice());
                productsDTO.setStock(products.getStock());
                productsDTO.setBrand(products.getBrand());
                productsDTO.setCreateDate(products.getCreateDate());
                productsDTO.setDescription(products.getDescription());
                productsDTO.setImage(products.getImage());
                productsDTO.setId(products.getId());
                productsDTOS.add(productsDTO);
            }
            categoryDTO.setProductsDTOS(productsDTOS);
            categoryDTOList.add(categoryDTO);
        }
        shopDTO.setCategoryDTOList(categoryDTOList);
        return shopDTO;
    }

    @Override
    public ShopDTO getShopById(int id) {
        Shop shop=shopRepository.getShopById(id);

        ShopDTO shopDTO=new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setTitle(shop.getTitle());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setImage(shop.getImage());
        return shopDTO;
    }

}
