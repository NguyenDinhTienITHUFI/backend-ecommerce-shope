package com.tiennguyen.BackEndApi.Controller;

import com.tiennguyen.BackEndApi.DTO.ShopDTO;
import com.tiennguyen.BackEndApi.Payload.ResponseData;
import com.tiennguyen.BackEndApi.Service.Imp.ShopServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopServiceImp shopServiceImp;

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailShop(@RequestParam int id) {
        ShopDTO shopDTO = shopServiceImp.getDetailShop(id);

        if (shopDTO == null) {

            ResponseData responseData = new ResponseData();
            responseData.setDesc("Shop không tồn tại");
            responseData.setData(null);
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }


        ResponseData responseData = new ResponseData();
        responseData.setDesc("Lấy thông tin shop thành công");
        responseData.setData(shopDTO);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }@GetMapping("/get-by-id")
    public ResponseEntity<?> getByID(@RequestParam int id) {
        System.out.println(id);
        ShopDTO shopDTO = shopServiceImp.getShopById(id);

        if (shopDTO == null) {

            ResponseData responseData = new ResponseData();
            responseData.setDesc("Shop không tồn tại");
            responseData.setData(null);
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }


        ResponseData responseData = new ResponseData();
        responseData.setDesc("Lấy thông tin shop thành công");
        responseData.setData(shopDTO);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
