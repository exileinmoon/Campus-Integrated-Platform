package stu.friendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.friendservice.DTO.AddconmentDTO;
import stu.friendservice.DTO.CardDetailDTO;
import stu.friendservice.DTO.CommentDTO;
import stu.friendservice.DTO.LoveCardDTO;
import stu.friendservice.entity.Comments;
import stu.friendservice.entity.WallImages;
import stu.friendservice.entity.LoveCards; // 假设你已经有这个实体类
import stu.friendservice.service.CommentsService;
import stu.friendservice.service.WallImagesService;
import stu.friendservice.service.LoveCardsService; // 假设你已经有这个服务接口

import java.util.List;

@RestController
@RequestMapping("/api/friend/love")
public class LoveController {

    @Autowired
    private WallImagesService wallImagesService;

    @Autowired
    private LoveCardsService LoveCardsService;
    @Autowired
    private CommentsService commentsService; // 假设你已经有这个服务接口

    // 获取墙图片信息
    @GetMapping("/wall-images")
    public ResponseEntity<List<WallImages>> getWallImages() {
        List<WallImages> wallImages = wallImagesService.getAllImages();
        return ResponseEntity.ok(wallImages);
    }

    //     获取所有恋爱卡片信息（分页）
    @GetMapping("/love-cards")
    public ResponseEntity<List<LoveCardDTO>> getLoveCardss(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<LoveCardDTO> LoveCards = LoveCardsService.getLoveCards(page, size); // 需要实现分页逻辑
        return ResponseEntity.ok(LoveCards);
    }

    // 获取单个卡片详细信息
    @GetMapping("/love-card/{id}")
    public ResponseEntity<CardDetailDTO> getLoveCardsById(@PathVariable Integer id) {
        CardDetailDTO loveCards = LoveCardsService.getLoveCardById(id);
        return ResponseEntity.ok(loveCards);
    }
    @PostMapping("/addcomments")
    public ResponseEntity<Void> addComment ( @RequestBody AddconmentDTO comments){
        commentsService.addComment(comments);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable Integer id) {
        List<CommentDTO> commentDTO = commentsService.getComments(id);
        return ResponseEntity.ok(commentDTO);
    }
}