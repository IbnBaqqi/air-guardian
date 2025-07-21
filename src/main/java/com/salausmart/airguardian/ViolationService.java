package com.salausmart.airguardian;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViolationService {

    private final ViolationRepository violationRepository;
    List<Violation> violations;

    public List<Violation> nfz() {

        OffsetDateTime currentTime = OffsetDateTime.now();

        OffsetDateTime last24 = currentTime.minusHours(24);

        violations = violationRepository.findAllByTimestampBetween(last24, currentTime);

        return violations;
    }
}
