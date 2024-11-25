package com.tiennguyen.BackEndApi.Service;

import com.tiennguyen.BackEndApi.DTO.CategoryDTO;
import com.tiennguyen.BackEndApi.Repository.CategoryRepository;
import com.tiennguyen.BackEndApi.Service.Imp.CategoryServiceImp;
import com.tiennguyen.BackEndApi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public boolean addCategory(String nameCate) {
        boolean isAddSuccess=false;
        try {
            Category category=new Category();
            category.setNameCate(nameCate);
            categoryRepository.save(category);
            isAddSuccess=true;
        }catch (Exception e){
            System.out.println("Error add Category"+ e.getMessage());
        }
        return isAddSuccess;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList=categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS=new ArrayList<>();
        for(Category data:categoryList)
        {
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setId(data.getId());
            categoryDTO.setCateName(data.getNameCate());

            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }
}
