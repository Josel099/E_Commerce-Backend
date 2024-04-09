package com.livares.product.controller;
import com.livares.product.model.User;
import com.livares.product.response.CustomResponse;
import com.livares.product.response.ResponseHandler;
import com.livares.product.service.impl.JwtService;
import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.LoginResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatBot.demo.dto.LoginResponse;
import com.chatBot.demo.dto.UserLoginDTO;
import com.chatBot.demo.entity.User;
import com.chatBot.demo.response.CustomResponse;
import com.chatBot.demo.response.CustomResponseHandler;
import com.chatBot.demo.service.AuthenticationService;
import com.chatBot.demo.service.JwtService;
import com.livares.product.service.impl.AuthenticationService;
public class LoginController {

    @Autowired
    JwtService jwtService;

    @Autowired
   AuthenticationService authenticationService;

    @PostMapping("/login")
    public CustomResponse<LoginResponse> findById(@RequestBody LoginDTO userDto) {
        com.livares.product.model.User authenticatedUser = authenticationService.authenticate(userDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseHandler.createResponse(new CustomResponse<List<LoginResponse>>(),
                loginResponse, "Success", "");

    }
}
