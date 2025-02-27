package com.challenge.michelfreitas.challenge.module.zipCode.repository;

import com.challenge.michelfreitas.challenge.module.zipCode.model.ZipCodeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeLogRepository extends JpaRepository<ZipCodeLog, Integer> {
}
