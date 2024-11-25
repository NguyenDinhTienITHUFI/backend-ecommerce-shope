package com.tiennguyen.BackEndApi.DTO;

import java.util.List;

public class CategoryDTO {
    private int id;
    private String cateName;
    private List<ProductsDTO> productsDTOS;

    public List<ProductsDTO> getProductsDTOS() {
        return productsDTOS;
    }

    public void setProductsDTOS(List<ProductsDTO> productsDTOS) {
        this.productsDTOS = productsDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
