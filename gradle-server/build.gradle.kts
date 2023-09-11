import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "2.5.1"
}
apply(plugin = "io.spring.dependency-management")

dependencies {

    // db
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core:8.5.13")

    implementation("com.sun.mail:javax.mail:1.6.2")

    implementation(project(":gradle-common"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.redisson:redisson-spring-boot-starter:3.19.0")

    implementation("com.alibaba:easyexcel:3.3.2")

    api("tech.tongyu.sdk:sdk-quick-starter:4.14.1")



    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootJar> {
    archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}
