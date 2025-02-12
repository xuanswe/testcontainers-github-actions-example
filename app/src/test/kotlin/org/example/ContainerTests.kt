package org.example

import org.junit.jupiter.api.Test
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.assertTrue

@Testcontainers
class ContainerTests {
  // will be started before and stopped after each test method
  @Container
  private val postgresqlContainer =
    PostgreSQLContainer("postgres:16.0-alpine3.18")
      .withDatabaseName("foo1")
      .withUsername("foo1")
      .withPassword("secret1")

  @Test
  fun test() {
    assertTrue(sharedPostgresqlContainer.isRunning())
    assertTrue(postgresqlContainer.isRunning())
  }

  companion object {
    // will be shared between test methods
    @Container
    private val sharedPostgresqlContainer =
      PostgreSQLContainer("postgres:16.0-alpine3.18")
        .withDatabaseName("foo2")
        .withUsername("foo2")
        .withPassword("secret2")
  }
}
