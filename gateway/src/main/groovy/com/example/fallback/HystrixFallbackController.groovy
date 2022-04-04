package com.example.fallback

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HystrixFallbackController {
    @GetMapping("/fallback")
    public Mono<String> getFallbackMsg() {
        return Mono.just("No response from service...trying again shortly!")
    }
}
