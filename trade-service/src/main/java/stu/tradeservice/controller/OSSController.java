package stu.tradeservice.controller;

import stu.tradeservice.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/oss")
public class OSSController {

    @Autowired
    private OSSService ossService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String fileUrl = ossService.uploadFile(file);
        if (fileUrl != null) {
            return ResponseEntity.ok(fileUrl);
        } else {
            return ResponseEntity.status(500).body("上传失败");
        }
    }
}
