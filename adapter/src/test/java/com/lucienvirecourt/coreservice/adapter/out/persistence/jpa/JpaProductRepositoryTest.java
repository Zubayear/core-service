package com.lucienvirecourt.coreservice.adapter.out.persistence.jpa;

import com.lucienvirecourt.coreservice.adapter.out.persistence.AbstractProductRepositoryTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test-with-postgresql")
class JpaProductRepositoryTest extends AbstractProductRepositoryTest {
}
