package stu.friendservice.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatMessage {
    private String senderId;
    private String receiverId;
    private String messageType;
    private String content;

}
