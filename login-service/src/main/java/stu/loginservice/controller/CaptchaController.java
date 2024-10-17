package stu.loginservice.controller;

import com.google.code.kaptcha.Producer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class CaptchaController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码文本
        String captchaText = captchaProducer.createText();

        // 生成验证码图像
        BufferedImage captchaImage = captchaProducer.createImage(captchaText);

        // 将验证码文本存储在 session 中，方便后续验证
        request.getSession().setAttribute("captcha", captchaText);

        // 设置响应头
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");

        // 将验证码图像写入响应
        javax.imageio.ImageIO.write(captchaImage, "jpg", response.getOutputStream());
    }
}
