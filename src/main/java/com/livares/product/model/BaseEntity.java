package com.livares.product.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    
  

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdTime = LocalDateTime.now(); // Set default value to current time


}
