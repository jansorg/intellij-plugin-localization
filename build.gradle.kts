plugins {
    id("org.jetbrains.intellij") version "1.3.0"
}

allprojects {
    apply {
        plugin("org.jetbrains.intellij")
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    intellij {
        version.set("IC-2021.3.1")
        updateSinceUntilBuild.set(true)
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    tasks {
        named("runIde") {
            // let "runIde" only launch the sandbox IDE for the root project and not for the lang-zh_CN subproject
            onlyIf { project == rootProject }
        }
    }
}

project(":") {
    dependencies {
        implementation(project(":lang-zh_CN"))
    }

    intellij {
        // enable the next line to let "runIde" launch the IDE with the Chinese language pack installed
        plugins.add("com.intellij.zh:213.241")
    }
}