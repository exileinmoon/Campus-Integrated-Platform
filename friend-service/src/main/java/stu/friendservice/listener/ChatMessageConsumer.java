package stu.friendservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import stu.friendservice.config.RabbitConfig;
import stu.friendservice.entity.ChatMessage;
import stu.friendservice.entity.Messages;
import stu.friendservice.mapper.MessagesMapper;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.time.LocalDate.now;

@Component
public class ChatMessageConsumer {
    @Autowired
    MessagesMapper messagesMapper;


    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>(); // 存储会话

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void consumeMessage(String messageJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        ChatMessage chatMessage = null;
        try {
            chatMessage = objectMapper.readValue(messageJson, ChatMessage.class);
            // 继续处理 chatMessage 对象
        } catch (JsonMappingException e) {
            // 处理 JSON 到对象映射的异常
            System.err.println("Mapping error: " + e.getMessage());
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // 处理 JSON 处理的异常
            System.err.println("Processing error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // 处理其他 IO 异常
            System.err.println("IO error: " + e.getMessage());
            e.printStackTrace();
        }

        // 创建 Messages 对象并存入数据库
        Messages messages = new Messages();
        messages.setReceiver_id(Integer.valueOf(chatMessage.getReceiverId()));
        messages.setSender_id(Integer.valueOf(chatMessage.getSenderId()));
        messages.setContent(chatMessage.getContent());
        messages.setMessage_type("文本"); // ����������
        messages.setCreated_at(Instant.now());
        messagesMapper.addMessage(
                messages.getSender_id(),
                messages.getReceiver_id(),
                messages.getMessage_type(),
                messages.getContent(),
                messages.getCreated_at()
        ); // 将消息存入数据库


        // 将消息发送给目标好友
        String receiverId = chatMessage.getReceiverId();
        WebSocketSession receiverSession = sessions.get(receiverId);
        if (receiverSession != null && receiverSession.isOpen()) {
            try {
                receiverSession.sendMessage(new TextMessage(chatMessage.getSenderId() + ": " + chatMessage.getContent()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addSession(String userId, WebSocketSession session) {
        sessions.put(userId, session);
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }
}
