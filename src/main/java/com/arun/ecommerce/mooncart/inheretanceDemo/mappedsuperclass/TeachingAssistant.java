package com.arun.ecommerce.mooncart.inheretanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TeachingAssistant extends User {
    private double averageRating;
}
