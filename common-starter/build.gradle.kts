plugins {
    id("java")
    id("maven-publish")
}

group = "tech.tongyu.sdk"
version = "4.13.1"



dependencies {
    api("ma.glasnost.orika:orika-core:1.5.4")
    api("com.github.xiaoymin:knife4j-openapi3-spring-boot-starter:4.1.0")
    api("cn.hutool:hutool-all:5.8.18")
//    api("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.3")
    api("com.baomidou:mybatis-plus-boot-starter:3.5.2")
//    api("org.apache.commons:commons-lang3:3.12.0")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            // 指定group/artifact/version信息
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            // 打包类型 war: components.web jar: components.java
            from(components["java"])
            // 配置上传源码

        }
    }

}