package com.arun.ecommerce.mooncart.thirdPartyProductServices.fakeStore;

import com.arun.ecommerce.mooncart.exception.NotFoundException;
import com.arun.ecommerce.mooncart.thirdPartyProductServices.IThirdPartyProductServiceClient;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class FakeStoreProductServiceClient implements IThirdPartyProductServiceClient, InitializingBean {
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.basepath}")
    private String fakestoreApiBaseURl;
    @Value("${fakestore.api.path.products}")
    private String fakestoreAPIProductsPath;
    private String fakestoreProductsURL = getFakestoreApiBaseURl()+getFakestoreAPIProductsPath();
    private String getProductRequestUrl = fakestoreApiBaseURl+fakestoreAPIProductsPath+"/{id}";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(buildProductRequestWithIdURL(), FakeStoreProductDto.class,id);
        response.getStatusCode();
        FakeStoreProductDto fakeStoreProduct = response.getBody();
        return fakeStoreProduct;
    }

    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(buildProductsRequestURL(), FakeStoreProductDto[].class);
        List<FakeStoreProductDto> products = new ArrayList<>();
        for(FakeStoreProductDto x: response.getBody()){
            products.add(x);
        }
        return products;
    }

    //This casting won't work. throws runtime error
    @Override
    public List<FakeStoreProductDto> getListOfAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ArrayList> response = restTemplate.getForEntity(buildProductsRequestURL(),ArrayList.class);
        List<FakeStoreProductDto> products = new ArrayList<>();
        for(Object x: response.getBody()){
            products.add((FakeStoreProductDto) x);
        }
        return products;
    }

    @Override
    public FakeStoreProductDto deleteProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(buildProductRequestWithIdURL(), HttpMethod.DELETE, requestCallback, responseExtractor, id);
        if(response.getBody()==null){
            throw new NotFoundException("Product with id "+id+" not found.");
        }
        FakeStoreProductDto fakeStoreProduct = response.getBody();
        return fakeStoreProduct;
    }

    @Override
    public FakeStoreProductDto updateProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    private String buildProductsRequestURL(){
        return fakestoreApiBaseURl+fakestoreAPIProductsPath;
    }

    private String buildProductRequestWithIdURL(){
        return buildProductsRequestURL()+"/{id}";
    }

//    private static GenericProductDto transformToGenericProduct(FakeStoreProducutDto fakeStoreProduct){
//        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProduct.getId());
//        product.setCategory(fakeStoreProduct.getCategory());
//        product.setDescription(fakeStoreProduct.getDescription());
//        product.setTitle(fakeStoreProduct.getTitle());
//        product.setPrice(fakeStoreProduct.getPrice());
//        return product;
//    }
}
