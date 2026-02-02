package gateway_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/user-fallback")
    public String userServiceFallback() {
        // если Circuit Breaker зафиксирует сбой в user-service
        return "Извините, сервис пользователей (userService) сейчас недоступен. Мы уже чиним!";
    }

    @GetMapping("/notification-fallback")
    public String notificationServiceFallback() {
        // если Circuit Breaker зафиксирует сбой в user-service
        return "Извините, сервис уведомлений (notificationService) сейчас недоступен. Мы уже чиним!";
    }
}

