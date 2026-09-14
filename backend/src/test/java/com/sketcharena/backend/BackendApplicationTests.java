package com.sketcharena.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

// an extension on junit jupiter (doesnt support parallel test exec)
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.testcontainers.postgresql.PostgreSQLContainer;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Container
	static final PostgreSQLContainer POSTGRES = new PostGreSQLContainer("postgres:18-alpine").withDatabaseName("sketch_arena_test").withUsername("sketch_arena").withPassword("sketch_arena_test");

	@DynamicPropertySource
	static void databaseProperties(DynamicProperyRegistry registry) {
		registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
		registry.add("spring.datasource.username", POSTGRES::getUsername);
		registry.add("spring.datasource.password", POSTGRES::getPassword);
	}

}
