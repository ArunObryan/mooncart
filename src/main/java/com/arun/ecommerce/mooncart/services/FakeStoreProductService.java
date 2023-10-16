package com.arun.ecommerce.mooncart.services;

import com.arun.ecommerce.mooncart.thirdPartyProductServices.fakeStore.FakeStoreProductDto;
import com.arun.ecommerce.mooncart.dataTransferObjects.GenericProductDto;
import com.arun.ecommerce.mooncart.exception.NotFoundException;
import com.arun.ecommerce.mooncart.thirdPartyProductServices.fakeStore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        return transformToGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return fakeStoreProductServiceClient.getAllProducts().stream().map(FakeStoreProductService::transformToGenericProduct).collect(Collectors.toList());
    }

    //This casting won't work. throws runtime error
    @Override
    public List<GenericProductDto> getListOfAllProducts() {
        return fakeStoreProductServiceClient.getListOfAllProducts().stream().map(FakeStoreProductService::transformToGenericProduct).collect(Collectors.toList());
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws NotFoundException {
        return transformToGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) throws NotFoundException {
        return transformToGenericProduct(fakeStoreProductServiceClient.updateProductById(id,genericProductDto));
    }

    private static GenericProductDto transformToGenericProduct(FakeStoreProductDto fakeStoreProduct){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProduct.getId());
        product.setCategory(fakeStoreProduct.getCategory());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setTitle(fakeStoreProduct.getTitle());
        product.setPrice(fakeStoreProduct.getPrice());
        return product;
    }
}
