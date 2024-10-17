package stu.loginservice.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class CaptchaUtil {

    // 验证验证码
    public boolean verifyCaptcha(HttpServletRequest request, String captcha) {
        // 从 session 中获取验证码
        String expectedCaptcha = (String) request.getSession().getAttribute("captcha");
        return captcha != null && captcha.equals(expectedCaptcha);
    }
}
