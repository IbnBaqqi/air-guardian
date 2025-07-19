package com.salausmart.airguardian;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final RestClient restClient;

    @Value("${drone.base-uri}")
    private String baseUri;


    public List<DronesDto> getDrones() {

        List<DronesDto> drones;

        drones = restClient.get()
                .uri(baseUri + "/drones")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        return drones;
    }

}
