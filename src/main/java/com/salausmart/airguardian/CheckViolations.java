package com.salausmart.airguardian;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CheckViolations {

    @Value("${drone.base-uri}")
    private String baseUri;

    @Autowired
    private DroneService droneService;
    @Autowired
    private RestClient restClient;
    @Autowired
    private ViolationRepository violationRepository;

    @Scheduled(fixedRate = 10000)
    public void saveViolation() {

        var drones = checkDrones();

        if (drones != null) {
            drones.forEach(drone -> {

                var owner = getOwner(drone.getOwnerId());
                var violation = new Violation();
                violation.setDroneId(drone.getDroneId());
                violation.setTimestamp(drone.getTimestamp());
                violation.setPositionX(drone.getX());
                violation.setPositionY(drone.getY());
                violation.setPositionZ(drone.getZ());
                violation.setOwnerFirstName(owner.getFirstName());
                violation.setOwnerLastName(owner.getLastName());
                violation.setOwnerSsn(owner.getSocialSecurityNumber());
                violation.setOwnerPhoneNumber(owner.getPhoneNumber());

                violationRepository.save(violation);
            });
        }
    }

    public OwnerDetail getOwner(Integer id) {

        return restClient.get()
                .uri(baseUri + "/users/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public List<DroneViolatedDto> checkDrones() {
        List<DronesDto> drones = droneService.getDrones();

        //check drones with formula
        //get owner details (in a new method maybe)
        return drones.stream()
                .filter(drone -> {
                    var x = drone.getX();
                    var y = drone.getY();
                    return checkPoint(x, y);
                }).map(drone -> {
                    var timestamp = OffsetDateTime.now();
                    return new DroneViolatedDto(drone.getDroneId(), drone.getOwnerId(), drone.getX(), drone.getY(), drone.getZ(), timestamp);
                }).collect(Collectors.toCollection(ArrayList::new));
    }

    public static boolean checkPoint(double x, double y) {

        var radius = Math.sqrt(x*x + y*y);
        return radius <= 1000;
    }
}
