package com.tiennguyen.BackEndApi.Repository;

import com.tiennguyen.BackEndApi.entity.Category;
import com.tiennguyen.BackEndApi.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findById(int id);
    @Query("SELECT p FROM products p WHERE p.title LIKE CONCAT('%', :title, '%')")
    List<Products> searchProductByTitle(@Param("title") String title);
    List<Products> getProductsByCategory(Category category);

    @Query("select p from products  p order by p.price asc ")
    List<Products> sortASC();
    @Query("select p from products  p order by p.price DESC")
    List<Products> sortDESC();
    @Query("SELECT p from products  p where p.price between :firstvalue and :secondvalue order by p.price asc ")
    List<Products> filterProductByRange(@Param("firstvalue") int firstvalue,@Param("secondvalue") int secondvalue);
}
