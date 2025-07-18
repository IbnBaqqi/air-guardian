package com.salausmart.airguardian;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ViolationController {

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of("success", "ok"));
    }

    @GetMapping("/drones")
    public ResponseEntity<?> drones() {
        return null;
    }

    @GetMapping("/nfz")
    public ResponseEntity<?> nfz() {
//        This endpoint returns all drone violations detected within the last 24 hours
//        No query parameters are required. The endpoint will always return violations from the last 24 hours.
//        • GET /nfz: Returns violations from the last 24 hours
        return null;
    }
}
