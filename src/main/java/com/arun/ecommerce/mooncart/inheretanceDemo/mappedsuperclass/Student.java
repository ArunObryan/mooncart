package com.arun.ecommerce.mooncart.inheretanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends User{
    private double psp;
    private double attendence;
}
