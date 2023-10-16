package com.arun.ecommerce.mooncart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private Long id;
    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
