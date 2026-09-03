package com.sketcharena.backend.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// mark the class as a rest controller
@RestController 
// shared url prefix for all endpoints in the class
@RequestMapping("/api")
public class HealthController {

    // maps to get reqs /api/health
    @GetMapping("/health") 
    public HealthResponse health() {
        return new HealthResponse("UP");
    }
}