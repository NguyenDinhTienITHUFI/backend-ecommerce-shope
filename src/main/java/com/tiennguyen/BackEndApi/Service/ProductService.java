package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.ProductsDTO;
import com.tiennguyen.BackEndApi.Repository.ProductRepository;
import com.tiennguyen.BackEndApi.Service.Imp.FileServiceImp;
import com.tiennguyen.BackEndApi.Service.Imp.ProductServiceImp;
import com.tiennguyen.BackEndApi.entity.Category;
import com.tiennguyen.BackEndApi.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    FileServiceImp fileServiceImp;
    @Override
    public boolean addNewProduct(String title, int stock, String brand, String description, MultipartFile file, double price, int cate_id) {
        boolean isInsertSuccess=false;
        try {
            boolean isSaveFileSuccess=fileServiceImp.saveFile(file);
            if(isSaveFileSuccess){
                Products products=new Products();
                products.setTitle(title);
                products.setStock(stock);
                products.setBrand(brand);
                products.setDescription(description);
                products.setImage(file.getOriginalFilename());
                products.setPrice(price);
                Category category=new Category();
                category.setId(cate_id);
                products.setCategory(category);

                productRepository.save(products);
                isInsertSuccess=true;
            }
        }catch (Exception e){
            System.out.println("Error addNewProducts "+e.getMessage());

        }
        return isInsertSuccess;
    }

    @Override
    public List<ProductsDTO> getAllProduct() {
        List<ProductsDTO> listDTO=new ArrayList<>();
        PageRequest pageRequest=PageRequest.of(0,6);
        Page<Products> listData=productRepository.findAll(pageRequest);
        for(Products data:listData){
            ProductsDTO productsDTO=new ProductsDTO();
            productsDTO.setId(data.getId());
            productsDTO.setTitle(data.getTitle());

            productsDTO.setImage(data.getImage());

            productsDTO.setStock(data.getStock());
            productsDTO.setPrice(data.getPrice());
            productsDTO.setCreateDate(data.getCreateDate());
            listDTO.add(productsDTO);
        }
        return listDTO;
    }
}
