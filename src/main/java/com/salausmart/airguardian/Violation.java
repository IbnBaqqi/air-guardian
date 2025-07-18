package com.salausmart.airguardian;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "violations")
public class Violation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "drone_id")
    private UUID droneId;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "timestamp")
    private OffsetDateTime timestamp;

    @Column(name = "position_x")
    private Double positionX;

    @Column(name = "position_y")
    private Double positionY;

    @Column(name = "position_z")
    private Double positionZ;

    @Column(name = "owner_first_name")
    private String ownerFirstName;

    @Column(name = "owner_last_name")
    private String ownerLastName;

    @Column(name = "owner_ssn")
    private String ownerSsn;

    @Column(name = "owner_phone_number")
    private String ownerPhoneNumber;
}