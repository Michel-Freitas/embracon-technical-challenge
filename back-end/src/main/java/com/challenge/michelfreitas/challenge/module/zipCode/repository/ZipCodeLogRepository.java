package com.challenge.michelfreitas.challenge.module.zipCode.repository;

import com.challenge.michelfreitas.challenge.module.zipCode.model.ZipCodeLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeLogRepository extends JpaRepository<ZipCodeLog, Integer> {

    @Query(value = "SELECT zcl FROM ZipCodeLog zcl WHERE LOWER(zcl.uf) = LOWER(:uf) ORDER BY zcl.dateTimeConsultation DESC")
    List<ZipCodeLog> findAllByUf(String uf, Pageable pageable);
}
