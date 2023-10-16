package com.arun.ecommerce.mooncart.services;

import com.arun.ecommerce.mooncart.dataTransferObjects.GenericProductDto;
import com.arun.ecommerce.mooncart.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements IProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public List<GenericProductDto> getListOfAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) throws NotFoundException {
        return null;
    }
}
