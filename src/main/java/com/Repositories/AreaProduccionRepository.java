package com.Repositories;

import com.Entidades.AreaProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaProduccionRepository
    extends JpaRepository<AreaProduccion, Long> {}
