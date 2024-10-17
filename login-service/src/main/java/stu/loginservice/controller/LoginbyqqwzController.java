//package stu.loginservice.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//
//@RestController
//@RequestMapping("/auth")
//public class LoginbyqqwzController {
//    @GetMapping("/auth/success")
//    public String loginSuccess() {
//        return "Login Successful";
//    }
//
//    @GetMapping("/auth/failure")
//    public String loginFailure() {
//        return "Login Failed";
//    }
//
//
//    @GetMapping("/loginbyqqwz")
//    public String loginByQQOrWechat(@AuthenticationPrincipal OAuth2User principal) {
//        if (principal != null) {
//            // 从 principal 对象中获取用户信息
//            String username = principal.getAttribute("name");
//            return "Welcome " + username;
//        } else {
//            return "Please log in";
//        }
//    }
//}
