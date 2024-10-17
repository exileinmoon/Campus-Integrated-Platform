package stu.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.loginservice.service.SmsService;
import stu.loginservice.util.VerificationCodeService;

@RestController
@RequestMapping("api/auth")
public class RegistrationController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private VerificationCodeService verificationCodeService;

    // 发送验证码
    @PostMapping("/send-captcha")
    public ResponseEntity<String> sendCaptcha(@RequestParam String phoneNumber) {
        String code = verificationCodeService.generateCode();
        try {
            smsService.sendSms(phoneNumber, code);
            // 将验证码存储在缓存或数据库中以供验证
            verificationCodeService.storeCode(phoneNumber, code);
            return ResponseEntity.ok("验证码已发送");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("验证码发送失败");
        }
    }

    // 验证验证码
    @PostMapping("/validate-captcha")
    public ResponseEntity<String> validateCaptcha(@RequestParam String phoneNumber, @RequestParam String captcha) {
        boolean isValid = verificationCodeService.validateCode(phoneNumber, captcha);
        if (isValid) {
            return ResponseEntity.ok("验证码验证成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码验证失败");
        }
    }

    // 注册用户
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String phoneNumber,
                                           @RequestParam String captcha, @RequestParam String password) {
        // 验证验证码
        boolean isValid = verificationCodeService.validateCode(phoneNumber, captcha);
        if (!isValid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码不正确");
        }

        // 注册逻辑，例如保存用户到数据库
        // UserService.save(username, phoneNumber, password);

        return ResponseEntity.ok("用户注册成功");
    }
}
