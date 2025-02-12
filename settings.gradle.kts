// https://docs.gradle.org/current/userguide/multi_project_builds.html

dependencyResolutionManagement {
  versionCatalogs {
    create("testLibs") {
      from(files("gradle/test-libs.versions.toml"))
    }
  }
}

rootProject.name = "testcontainers-github-actions-example"
include("app")
