package com.lucienvirecourt.coreservice.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for {@link CartJpaEntity}.
 *
 * @author Syed Ibna Zubaeyar
 */
@Repository
public interface JpaCartSpringDataRepository extends JpaRepository<CartJpaEntity, Integer> {}
