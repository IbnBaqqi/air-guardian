package com.salausmart.airguardian;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ViolationController {
    private final DroneService droneService;

    //    All of your API endpoints must be defined using Pydantic models—both for request parameters and response schemas.
//    This ensures that:
//      • Incoming data is validated and structured.
//      • Outgoing responses are consistent and predictable.

    @GetMapping("/health")
    public ResponseEntity<?> health() {
//        A basic health check endpoint used to confirm that the backend service is running and responsive.
//        When called, this endpoint should respond with an HTTP 200 OK status code and a simple JSON payload indicating success: {"success": "ok"}
        return ResponseEntity.ok(Map.of("success", "ok"));
    }

    @GetMapping("/drones")
    public ResponseEntity<List<DronesDto>> drones() {
//        This endpoint acts as a proxy to the external drone tracking API. Its main purpose is to abstract the external service
//        and prevent direct exposure of the upstream URL to clients.
//        Note: Since this endpoint acts as a gateway to an external system, you should ensure basic error handling and logging to make the proxy reliable.
        var drones = droneService.getDrones();
        return ResponseEntity.ok(drones);
    }

    @GetMapping("/nfz")
    public ResponseEntity<?> nfz() {
//        This endpoint returns all drone violations detected within the last 24 hours
//        No query parameters are required. The endpoint will always return violations from the last 24 hours.
//        • GET /nfz: Returns violations from the last 24 hours
        return null;
    }
}
