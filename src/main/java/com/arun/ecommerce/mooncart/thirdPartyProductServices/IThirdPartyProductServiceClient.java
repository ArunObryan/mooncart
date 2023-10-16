package com.arun.ecommerce.mooncart.thirdPartyProductServices;

import com.arun.ecommerce.mooncart.thirdPartyProductServices.fakeStore.FakeStoreProductDto;
import com.arun.ecommerce.mooncart.exception.NotFoundException;

import java.util.List;

public interface IThirdPartyProductServiceClient {
    FakeStoreProductDto getProductById(Long id);

    List<FakeStoreProductDto> getAllProducts();

    List<FakeStoreProductDto> getListOfAllProducts();

    FakeStoreProductDto deleteProductById(Long id) throws NotFoundException;

    FakeStoreProductDto updateProductById(Long id) throws NotFoundException;
}
