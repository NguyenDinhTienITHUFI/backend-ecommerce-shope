package com.tiennguyen.BackEndApi.Service.Imp;

import com.tiennguyen.BackEndApi.DTO.CategoryDTO;
import com.tiennguyen.BackEndApi.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryServiceImp {
    boolean addCategory(String nameCate);
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(int id);
}
