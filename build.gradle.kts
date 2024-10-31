plugins {
    id("java")
    id("org.springframework.boot") version "3.3.5"
    id ("io.spring.dependency-management") version "1.1.6"
}

group = "ru.vagapov.spring"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.thymeleaf:thymeleaf-spring5:3.0.14.RELEASE")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.5")
    implementation("org.springframework.boot:spring-boot-starter-security")

    compileOnly("javax.servlet:javax.servlet-api:4.0.1")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework:spring-test:5.3.14")
    testImplementation(platform("org.junit:junit-bom:5.11.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}