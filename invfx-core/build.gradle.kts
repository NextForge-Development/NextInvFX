plugins { `java-library` }

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

repositories {
    mavenCentral()
}

dependencies {
    // Empfehlungen: Adventure kommt aus BOM – KEINE Version hier!
    api("net.kyori:adventure-api")
    api("net.kyori:adventure-text-minimessage")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test { useJUnitPlatform() }
java { withSourcesJar(); withJavadocJar() }
