package com.studiosheepdog.dognapper.location.domain.repository;

import com.studiosheepdog.dognapper.location.domain.aggregate.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
