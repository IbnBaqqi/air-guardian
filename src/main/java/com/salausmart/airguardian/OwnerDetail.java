package com.salausmart.airguardian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwnerDetail {

    private Integer id;
    private String firstName; //yes
    private String lastName; //yes
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber; //yes
    @JsonProperty("social_security_number")
    private String socialSecurityNumber; //yes
    @JsonProperty("purchased_at")
    private String purchasedAt;

}
