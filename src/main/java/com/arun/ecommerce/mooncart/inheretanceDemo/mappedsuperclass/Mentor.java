package com.arun.ecommerce.mooncart.inheretanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
public class Mentor extends User{
    private double averageRating;
}
