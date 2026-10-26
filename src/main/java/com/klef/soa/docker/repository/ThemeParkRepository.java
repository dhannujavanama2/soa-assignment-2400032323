package com.klef.soa.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klef.soa.docker.entity.ThemePark;

@Repository
public interface ThemeParkRepository extends JpaRepository<ThemePark, Long> {

    ThemePark findTopByOrderByIdDesc();
}