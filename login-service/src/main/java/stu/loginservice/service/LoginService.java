package stu.loginservice.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import stu.loginservice.DTO.LoginRequest;
import stu.loginservice.entity.Users;
import stu.loginservice.exception.InvalidCredentialsException;
import stu.loginservice.util.JwtTokenUtil;
import stu.loginservice.util.CaptchaUtil;

import java.util.Objects;


@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CaptchaUtil captchaUtil;

    public String login(String username, String password, String captcha, HttpServletRequest request) throws InvalidCredentialsException {
        // 验证验证码
       String expectedCaptcha = (String) request.getSession().getAttribute("captcha");

        if (Objects.equals(captcha, "")){
            throw new InvalidCredentialsException("Invalid captcha");
        }

        try {
            // 进行身份认证
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // 获取用户信息
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // 生成并返回 JWT token
            return jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            // 身份验证失败
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}
