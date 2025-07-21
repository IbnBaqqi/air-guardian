package com.salausmart.airguardian;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {

    List<Violation> findAllByTimestampBetween(OffsetDateTime after, OffsetDateTime before);
}