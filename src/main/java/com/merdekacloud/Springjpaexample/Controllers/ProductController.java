package com.merdekacloud.Springjpaexample.Controllers;

import com.merdekacloud.Springjpaexample.Biz.AddingData;
import com.merdekacloud.Springjpaexample.Dto.AddingRequest;
import com.merdekacloud.Springjpaexample.Dto.ProductAddResponse;
import com.merdekacloud.Springjpaexample.Entity.Product;
import com.merdekacloud.Springjpaexample.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    AddingData addingData;

    @GetMapping("/")
    public List<Product> getAll(){ return productRepo.findAll();}

    @GetMapping("/price")
    public List<Product> findGreaterThanPrice(@RequestParam("price") BigDecimal price){
        return productRepo.findByProductPriceGreaterThan(price);
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product){ return productRepo.save(product);}

    @PostMapping("/tambah")
    public ProductAddResponse addingData(@RequestBody AddingRequest request){
        return addingData.addingDataProduct(request);
    }
}
