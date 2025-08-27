plugins { `java-library` }

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":invfx-core"))

    // Paper/Adventure Versionen werden vom BOM vorgegeben
    compileOnly("io.papermc.paper:paper-api")

    api("net.kyori:adventure-api")
    api("net.kyori:adventure-text-minimessage")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.junit.jupiter:junit-jupiter")
}
tasks.test { useJUnitPlatform() }
java { withSourcesJar(); withJavadocJar() }
