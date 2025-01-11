import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.victor.app.web"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") { attributes["crossorigin"] = "" }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Roboto&display=swap",
                    rel = "stylesheet"
                )
                link(
                    href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap",
                    rel="stylesheet"
                )
                link(
                    href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400&display=swap",
                    rel="stylesheet"
                )
                link(
                    href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap",
                    rel="stylesheet"
                )
            }

            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("web")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            
        }
    }
}
