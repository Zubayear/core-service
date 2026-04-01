package com.lucienvirecourt.coreservice.adapter.out.persistence.jpa;

import com.lucienvirecourt.coreservice.adapter.out.persistence.AbstractCartRepositoryTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test-with-postgresql")
class JpaCartRepositoryTest extends AbstractCartRepositoryTest {
}
