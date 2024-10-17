package stu.friendservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import stu.friendservice.entity.ChatMessage;
import stu.friendservice.listener.ChatMessageConsumer;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final ChatMessageConsumer chatMessageConsumer; // 注入 ChatMessageConsumer
    private final RabbitTemplate rabbitTemplate; // 注入 RabbitTemplate
    @Autowired
    public ChatWebSocketHandler(ChatMessageConsumer chatMessageConsumer, RabbitTemplate rabbitTemplate) {
        this.chatMessageConsumer = chatMessageConsumer;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = getUserIdFromSession(session);
        sessions.put(userId, session);
        chatMessageConsumer.addSession(userId, session); // 将会话添加到消费者中
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 使用 ObjectMapper 解析 JSON 消息
        System.out.println("Received message: " + message.getPayload()); // 日志输出
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message.getPayload());

        String senderId = jsonNode.get("sender_id").asText();
        String receiverId = jsonNode.get("receiver_id").asText();
        String msgContent = jsonNode.get("content").asText();
        String messageType = jsonNode.get("message_type").asText();

        // 创建 ChatMessage 对象
        ChatMessage chatMessage = new ChatMessage(senderId, receiverId,messageType, msgContent);

        // 将 ChatMessage 对象序列化为 JSON 字符串
        String chatMessageJson = objectMapper.writeValueAsString(chatMessage);

        // 将消息发送到 RabbitMQ
        rabbitTemplate.convertAndSend("chat.exchange", "chat.routingKey", chatMessageJson);
        System.out.println("Sent message: " + chatMessageJson); // 日志输出
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String userId = getUserIdFromSession(session);
        sessions.remove(userId);
        chatMessageConsumer.removeSession(userId); // 从消费者中移除会话
    }

    private String getUserIdFromSession(WebSocketSession session) {
        // 根据session获取用户ID的方法
        return session.getId(); // 这里可以根据实际需求获取用户ID
    }
}
