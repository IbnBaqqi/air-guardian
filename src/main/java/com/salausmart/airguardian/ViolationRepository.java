package com.salausmart.airguardian;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {
}