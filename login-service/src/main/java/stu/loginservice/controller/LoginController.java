package stu.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import stu.loginservice.DTO.LoginRequest;
import stu.loginservice.DTO.LoginResponse;
import stu.loginservice.entity.Users;
import stu.loginservice.service.LoginService;
import stu.loginservice.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest,  HttpServletRequest request) {
        String token = loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getCaptcha(),request);
        Users users = usersService.getUserByUsername(loginRequest.getUsername());
        LoginResponse loginResponse = new LoginResponse(token, users);
        return ResponseEntity.ok(loginResponse);
    }
}