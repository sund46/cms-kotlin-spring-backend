import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // spring boot를 사용하기 위한 플러그인
    id("org.springframework.boot")

    // spring 관련 dependency 버전 관리를 일괄적으로 해주는 플러그인
    id("io.spring.dependency-management")

    // 타겟 플랫폼: jvm
    kotlin("jvm")

    // spring boot를 사용
    kotlin("plugin.spring")

    // JPA (Java Persistence API)
    // Java 진영에서의 ORM 기술 표준으로 사용되는 인터페이스 모음
    kotlin("plugin.jpa")

    // Kotlin 에서 Annotation 처리를 위함
    kotlin("kapt")
}

val projectGroup : String by project
val applicationVersion : String by project

group = projectGroup
version = applicationVersion
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    // spring boot starter
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    // swagger ui
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.5.1.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.1.Final")

    //flyway
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql:9.21.0")
    runtimeOnly("com.mysql:mysql-connector-j")

    // spring security
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
    testImplementation("org.springframework.security:spring-security-test")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
