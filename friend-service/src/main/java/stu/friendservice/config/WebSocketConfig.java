package stu.friendservice.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import stu.friendservice.service.ChatWebSocketHandler;
import stu.friendservice.listener.ChatMessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    private final ChatMessageConsumer chatMessageConsumer;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public WebSocketConfig(ChatMessageConsumer chatMessageConsumer, RabbitTemplate rabbitTemplate) {
        this.chatMessageConsumer = chatMessageConsumer;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 将 ChatMessageConsumer 和 RabbitTemplate 传递给 ChatWebSocketHandler
        registry.addHandler(new ChatWebSocketHandler(chatMessageConsumer, rabbitTemplate), "/chat")
                .setAllowedOrigins("*");
    }
}
