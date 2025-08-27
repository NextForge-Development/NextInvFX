plugins {
    `java-platform`
    `maven-publish`
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

javaPlatform {
    allowDependencies() // erlaubt Import anderer BOMs (z.B. Adventure BOM)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Importiere Kyori Adventure BOM (empfohlen) – hält adventure.* Komponenten synchron
    api(platform("net.kyori:adventure-bom:4.17.0"))

    constraints {
        // ---- InvFX-Module (.alignen automatisch auf dieselbe Version wie das BOM)
        api(project(":invfx-core"))
        api(project(":invfx-binding-bukkit"))

        // ---- explizite Versionen für häufige direkte Abhängigkeiten (nur wirksam falls genutzt)
        api("net.kyori:adventure-api:4.17.0")
        api("net.kyori:adventure-text-minimessage:4.17.0")

        // CompileOnly/Provided–Kandidaten (werden nur wirksam, wenn im Consumer deklariert)
        api("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT") // Beispiel für Bukkit/Spigot/Paper

        // Dev/Build-Time (nur falls jemand sie explizit einbindet)
        api("org.projectlombok:lombok:1.18.38")
        api("org.junit.jupiter:junit-jupiter:5.10.2")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenBom") {
            from(components["javaPlatform"])
            artifactId = "invfx-bom"
            pom {
                name.set("InvFX BOM")
                description.set("Bill of Materials for InvFX modules and aligned dependencies")
                url.set("https://example.invalid/invfx") // später ersetzen
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/license/mit")
                        distribution.set("repo")
                    }
                }
            }
        }
    }
    repositories {
        // für lokale Tests
        mavenLocal()
        // später: echter Maven-Host (Sonatype o.ä.)
    }
}
