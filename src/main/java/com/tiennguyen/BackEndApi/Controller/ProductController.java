package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.FileServiceImp;
import com.tiennguyen.BackEndApi.Service.Imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin()
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    ProductServiceImp productServiceImp;
    @PostMapping("/add-new-product")
    public ResponseEntity<?> addNewProduct(@RequestParam String title,
                                           @RequestParam int stock,
                                           @RequestParam String brand,
                                           @RequestParam String description,
                                           @RequestParam MultipartFile file,
                                           @RequestParam double price,
                                           @RequestParam int cate_id){
        ResponseData responseData=new ResponseData();
        boolean isSuccess= productServiceImp.addNewProduct(title,stock,brand,description,file,price,cate_id);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-all-product")
    public ResponseEntity<?>getAllProduct(){
        ResponseData responseData=new ResponseData();
        responseData.setData(productServiceImp.getAllProduct());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?>getFileProduct(@PathVariable String filename){
        Resource resource=fileServiceImp.loadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
    @GetMapping("/search-by-title")
    public ResponseEntity<?>searchProductByTitle(@RequestParam String title){
        ResponseData responseData=new ResponseData();
        responseData.setData(productServiceImp.searchByTitle(title));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/get-product-by-idcate")
    public ResponseEntity<?>getProductByCateId(@RequestParam int cateId){
        ResponseData responseData=new ResponseData();
        responseData.setData(productServiceImp.getListProductByCategory(cateId));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/sort-asc")
    public ResponseEntity<?>sortASC(){
        ResponseData responseData=new ResponseData();
        responseData.setData(productServiceImp.filterASC());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/sort-desc")
    public ResponseEntity<?>sortDESC(){
        ResponseData responseData=new ResponseData();
        responseData.setData(productServiceImp.filterDESC());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
