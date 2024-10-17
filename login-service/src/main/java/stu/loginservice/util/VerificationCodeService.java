package stu.loginservice.util;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {
    private static final int CODE_LENGTH = 6;
    private static final Random RANDOM = new Random();
    // 存储验证码的 Map，key 是手机号，value 是验证码
    private final Map<String, String> verificationCodes = new HashMap<>();
    // 验证码有效期，单位是毫秒（这里设置为5分钟）
    private static final long CODE_EXPIRY_TIME = TimeUnit.MINUTES.toMillis(5);
    // 存储验证码生成时间的 Map
    private final Map<String, Long> codeGeneratedTime = new HashMap<>();

    // 生成验证码
    public String generateCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(RANDOM.nextInt(10));
        }
        return code.toString();
    }

    // 存储验证码
    public void storeCode(String phoneNumber, String code) {
        verificationCodes.put(phoneNumber, code);
        codeGeneratedTime.put(phoneNumber, System.currentTimeMillis());
    }

    // 验证验证码
    public boolean validateCode(String phoneNumber, String code) {
        String storedCode = verificationCodes.get(phoneNumber);
        Long generatedTime = codeGeneratedTime.get(phoneNumber);

        // 检查验证码是否存在且未过期
        if (storedCode != null && generatedTime != null) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - generatedTime <= CODE_EXPIRY_TIME && storedCode.equals(code)) {
                // 验证成功后可以删除验证码，防止重复使用
                verificationCodes.remove(phoneNumber);
                codeGeneratedTime.remove(phoneNumber);
                return true;
            }
        }
        return false;
    }
}
