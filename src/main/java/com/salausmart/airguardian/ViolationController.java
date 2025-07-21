package com.salausmart.airguardian;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ViolationController {

    @Value("${secret}")
    private String secret;
    private final DroneService droneService;
    private final ViolationService violationService;


    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of("success", "ok"));
    }

    @GetMapping("/drones")
    public ResponseEntity<List<DronesDto>> drones() {
        var drones = droneService.getDrones();
        return ResponseEntity.ok(drones);
    }

    @GetMapping("/nfz")
    public ResponseEntity<?> nfz(@RequestHeader("X-Secret") String headerSecret) {
        if (secret.equals(headerSecret)) {
            List<Violation> violations;
            violations = violationService.nfz();
            return ResponseEntity.ok(violations);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized to access this endpoint");
    }
}
