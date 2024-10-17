package stu.loginservice.service;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    // 请确保将这些值替换为你的实际值
    private static final String SECRET_ID = System.getenv("TENCENTCLOUD_SECRET_ID");
    private static final String SECRET_KEY = System.getenv("TENCENTCLOUD_SECRET_KEY");
    private static final String SMS_SDK_APP_ID = "your-sms-sdk-app-id";
    private static final String SMS_SIGN_NAME = "your-sign-name";
    private static final String SMS_TEMPLATE_ID = "your-template-id";

    public void sendSms(String phoneNumber, String code) {
        try {
            // 实例化认证对象
            Credential cred = new Credential(SECRET_ID, SECRET_KEY);

            // 设置 HTTP 配置
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            // 实例化客户端配置
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            // 实例化短信客户端
            SmsClient client = new SmsClient(cred, "", clientProfile);

            // 实例化请求对象
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppId(SMS_SDK_APP_ID); // 确保大小写正确
            req.setSignName(SMS_SIGN_NAME); // 确保使用正确的方法名
            req.setTemplateId(SMS_TEMPLATE_ID); // 修正为 setTemplateId
            req.setTemplateParamSet(new String[]{code});
            req.setPhoneNumberSet(new String[]{phoneNumber});

            // 发送短信
            SendSmsResponse resp = client.SendSms(req);
            System.out.println(SendSmsResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send SMS", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send SMS", e);
        }
    }
}
