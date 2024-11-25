package com.tiennguyen.BackEndApi.DTO;

import java.util.List;

public class CartDTO {
    private int idUser;
    private List<ProductsDTO> productsDTO;
    private double total;
    private int quantity;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<ProductsDTO> getProductsDTO() {
        return productsDTO;
    }

    public void setProductsDTO(List<ProductsDTO> productsDTO) {
        this.productsDTO = productsDTO;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
