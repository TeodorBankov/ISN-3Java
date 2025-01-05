plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
	//kotlin("plugin.jpa") version "1.8.10"
}

group = "com.ISN3Java"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.modelmapper:modelmapper:2.4.4")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Add Lombok dependency
	implementation("org.projectlombok:lombok:1.18.24") // Use the latest Lombok version
	compileOnly("org.projectlombok:lombok:1.18.24") // Needed for compilation only
	annotationProcessor("org.projectlombok:lombok:1.18.24") // Required for annotation processing
	//implementation("jakarta.persistence:jakarta.persistence-api:3.1.0") // JPA API
	//implementation("org.hibernate:hibernate-core:6.0.0.Final")  // Hibernate ORM (or any other JPA provider you prefer)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
