package com.salausmart.airguardian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class DronesDto {

    @JsonProperty("id")
    private UUID droneId;
    @JsonProperty("owner_id")
    private Integer ownerId;
    private Double x;
    private Double y;
    private Double z;

}
