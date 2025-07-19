package com.salausmart.airguardian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DronesDto {

    @JsonProperty("owner_id")
    private String ownerId;
    private Double x;
    private Double y;
    private Double z;

}
