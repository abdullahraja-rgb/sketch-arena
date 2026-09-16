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
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
// finds all field in the class annotated by @Container calls their lifecycle method
@Testcontainers(disabledWithoutDocker = true)
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	// this container is declared as a static field so this container is shared by all test methods
	@Container
	static final PostgreSQLContainer POSTGRES = new PostgreSQLContainer("postgres:18-alpine").withDatabaseName("sketch_arena_test").withUsername("sketch_arena").withPassword("sketch_arena_test");

	// dynamic runtime configs
	@DynamicPropertySource
	static void databaseProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
		registry.add("spring.datasource.username", POSTGRES::getUsername);
		registry.add("spring.datasource.password", POSTGRES::getPassword);
	}

	// find a jdbcTemp object and assign to this field
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void createInitialSchema() {
		List<String> tables = jdbcTemplate.queryForList("""
			SELECT table_name
			FROM information_schema.tables
			WHERE table_schema = 'public'
			""", String.class);			
		
		assertThat(tables).contains(
			"app_user",
			"organisation",
			"organisation_membership",
			"invitation",
			"game_type",
			"game_match",
			"match_player",
			"match_round"
		);
	}

}
