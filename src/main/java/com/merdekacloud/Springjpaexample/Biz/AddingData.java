package com.merdekacloud.Springjpaexample.Biz;

import com.merdekacloud.Springjpaexample.Dto.CategoryAddRequest;
import com.merdekacloud.Springjpaexample.Dto.CategoryAddResponse;
import com.merdekacloud.Springjpaexample.Dto.ProductAddRequest;
import com.merdekacloud.Springjpaexample.Dto.ProductAddResponse;
import com.merdekacloud.Springjpaexample.Entity.Category;
import com.merdekacloud.Springjpaexample.Entity.Product;
import com.merdekacloud.Springjpaexample.Repository.CategoryRepo;
import com.merdekacloud.Springjpaexample.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Component
public class AddingData {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

//    @Override
    public CategoryAddResponse addingDataCategory(CategoryAddRequest categoryAddRequest){
        CategoryAddResponse categoryAddResponse = new CategoryAddResponse();
        categoryAddResponse.setMessage("Success!");

        Product newProduct = new Product();
        newProduct.setProductName(categoryAddRequest.getItem());
        newProduct.setProductPrice(new BigDecimal(100));
//        newProduct.setCategory_id(1L);
        productRepo.save(newProduct);

        return categoryAddResponse;
    }

    public ProductAddResponse addingDataProduct(ProductAddRequest productAddRequest){
        ProductAddResponse productAddResponse = new ProductAddResponse();
        productAddResponse.setMessage("Success!");

        Category newCategory = new Category();
        newCategory.setCategory(productAddRequest.getItem());
//        newCategory.setProductPrice(new BigDecimal(100));
//        newProduct.setCategory_id(1L);
        categoryRepo.save(newCategory);

        return productAddResponse;
    }
}
