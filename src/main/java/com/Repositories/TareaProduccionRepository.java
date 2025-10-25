package com.Repositories;

import com.Entidades.TareaProduccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaProduccionRepository
    extends JpaRepository<TareaProduccion, Long> {
    List<TareaProduccion> findByAreaProduccionId(Long areaId);
}
