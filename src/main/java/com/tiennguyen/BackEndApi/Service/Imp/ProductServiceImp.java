package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.ProductsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServiceImp {
    boolean addNewProduct(String title,
                          int stock,
                          String brand,
                          String description,
                          MultipartFile file,
                          double price,
                          int cate_id);
    List<ProductsDTO> getAllProduct();
    List<ProductsDTO> searchByTitle(String title);
    List<ProductsDTO> getListProductByCategory(int id);
    List<ProductsDTO> filterASC();
    List<ProductsDTO> filterDESC();
    List<ProductsDTO> filterByRange(int firstValue,int secondValue);
}
