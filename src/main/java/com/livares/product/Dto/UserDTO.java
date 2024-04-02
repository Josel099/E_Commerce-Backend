package com.livares.product.Dto;

import com.livares.product.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

        private String firstName;
        private String lastName;
        private String  username;
        private String  password;
}
