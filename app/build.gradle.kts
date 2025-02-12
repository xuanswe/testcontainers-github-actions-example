plugins {
  alias(libs.plugins.kotlin.jvm)
  application
}

repositories {
  mavenCentral()
}

// Main dependencies
dependencies {
  implementation(platform(libs.log4j.bom))
  implementation(libs.bundles.log4j)
  runtimeOnly(libs.bundles.log4j.runtime)
}

// Test dependencies
dependencies {
  testImplementation(platform(testLibs.junit.bom))
  testImplementation(testLibs.junit.jupiter)
  testRuntimeOnly(testLibs.junit.platformLauncher)

  testImplementation(testLibs.bundles.kotlinTest)

  testImplementation(platform(testLibs.testcontainers.bom))
  testImplementation(testLibs.bundles.testcontainers)
}

kotlin {
  jvmToolchain(21)
}

application {
  mainClass = "org.example.AppKt"
}

tasks.test {
  useJUnitPlatform()
}
