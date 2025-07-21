package com.salausmart.airguardian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwnerDetail {

    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("social_security_number")
    private String socialSecurityNumber;

    @JsonProperty("purchased_at")
    private String purchasedAt;

}
