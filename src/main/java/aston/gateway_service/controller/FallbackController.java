package aston.gateway_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    // Для UserController (пути начинаются с /user-fallback или приходят сюда из Gateway)
    @GetMapping("/user-fallback/**")
    public ResponseEntity<String> userServiceGetFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Извините, сервис пользователей (userService) недоступен (чтение).");
    }

    @RequestMapping(value = "/user-fallback/**", method = {
            RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE
    })
    public ResponseEntity<String> userServiceMutationFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Извините, сервис пользователей (userService) недоступен (изменение данных).");
    }

    @PostMapping("/notification-fallback")
    public String notificationServiceFallback() {
        // если Circuit Breaker зафиксирует сбой в notificationService
        return "Извините, сервис уведомлений (notificationService) сейчас недоступен. Мы уже чиним!";
    }
}

