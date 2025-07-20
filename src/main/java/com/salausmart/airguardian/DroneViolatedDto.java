package com.salausmart.airguardian;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DroneViolatedDto {
    private UUID droneId;
    private Integer ownerId;
    private Double x;
    private Double y;
    private Double z;
    private OffsetDateTime timestamp;
}
