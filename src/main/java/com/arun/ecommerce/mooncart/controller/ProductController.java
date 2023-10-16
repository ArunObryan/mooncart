package com.arun.ecommerce.mooncart.controller;

import com.arun.ecommerce.mooncart.dataTransferObjects.GenericProductDto;
import com.arun.ecommerce.mooncart.exception.NotFoundException;
import com.arun.ecommerce.mooncart.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@ControllerAdvice
public class ProductController {

    //FieldInjection
    //If we @Autowire the Productservice it is called field injection.
    //@Autowire
    private IProductService productService;

    //Constructor Injection
    //Autowire is not mandatory in constructor injection
    //@Qualifier("fakeStoreProductService") - specify explicitly the bean to be used.
    public ProductController(IProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public String createProduct(@RequestBody GenericProductDto product){
        //System.out.println();
        return "Created a new product with Id :"+ product.getTitle();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }
}
