package com.tiennguyen.BackEndApi.DTO;

import java.util.List;

public class OrderDTO {
    private int idUser;
    private int idOrder;
    private List<ProductsDTO> productsDTO;
    private double total;
    private int quantity;
    private int status;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
