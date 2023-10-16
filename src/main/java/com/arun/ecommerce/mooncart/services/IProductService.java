package com.arun.ecommerce.mooncart.services;

import com.arun.ecommerce.mooncart.dataTransferObjects.GenericProductDto;
import com.arun.ecommerce.mooncart.exception.NotFoundException;

import java.util.List;

public interface IProductService {
    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    List<GenericProductDto> getListOfAllProducts();

    GenericProductDto deleteProductById(Long id) throws NotFoundException;

    GenericProductDto updateProductById(Long id) throws NotFoundException;
}
