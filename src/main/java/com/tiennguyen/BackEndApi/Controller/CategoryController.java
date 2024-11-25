package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?>addNewCategory(@RequestParam String nameCate)
    {
        ResponseData responseData=new ResponseData();
        boolean isSuccess=categoryService.addCategory(nameCate);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-all-category")
    public ResponseEntity<?>getAllCategory()
    {
        ResponseData responseData=new ResponseData();

        responseData.setData(categoryService.getAllCategory());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
