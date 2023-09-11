plugins {
    java
    id("java-library")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
}




subprojects{

    dependencies{
        // lombok
        compileOnly("org.projectlombok:lombok:1.18.20")
        annotationProcessor("org.projectlombok:lombok:1.18.20")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}


val pkgDir = "${rootDir}/${project.name}"
tasks.named("clean") {
    doLast {
        delete(pkgDir)
    }
}


tasks.register("hello") {
    dependsOn("build")
    println ("hello world")
}

tasks.register("hello2"){
    group = "build"
    println ("hello world2")
}



tasks.register("pkg") {
    group = "build"
    dependsOn("build")

    doLast {
        delete(pkgDir)
        mkdir(pkgDir)

        copy {
            from("${rootDir}/scripts")
            include("ds.config.js")
            into(pkgDir)
        }
        copy {
            from("${rootDir}/scripts")
            into("${pkgDir}/scripts")
        }
        copy {
            from("${rootDir}/README.md")
            into(pkgDir)
        }
        copy {
            from("${buildDir}/libs")
            exclude("*-plain.jar")
            into("${pkgDir}/bin")
        }

        copy {
            from("${buildDir}/resources/main/META-INF/build-info.properties")
            into(pkgDir)
        }

        copy {
            from("$rootDir")
            include("doc/*")
            into(pkgDir)
        }
    }
}