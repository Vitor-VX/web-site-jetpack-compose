package com.victor.app.web.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BackgroundClip
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.victor.app.web.components.TextApp.TextHeaderName
import com.victor.app.web.components.TextApp.TextPresentationContentApp
import com.victor.app.web.components.TextApp.TextProjectContentApp
import com.victor.app.web.components.TextApp.TextStyleContentApp
import com.victor.app.web.pages.ProjectData
import com.victor.app.web.pages.SocialMedia
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContentApp(modifier: Modifier = Modifier) {
    val projectList = listOf(
        ProjectData(
            icon = "ic_project_casino_site.png",
            title = "Casino Layout",
            description = "Um layout de casino profissional",
            url = "",
            tags = listOf("Android Native", "Kotlin", "Jetpack Compose"),
            isBuy = true
        ),
        ProjectData(
            icon = "ic_project_ecommerce_site.png",
            title = "Ecommerce Layout",
            description = "Um layout de Ecommerce de Tênis",
            url = "https://github.com/Vitor-VX/app-ecormeerce",
            tags = listOf("Android Native", "Kotlin", "Jetpack Compose")
        ),
        ProjectData(
            icon = "ic_project_frdguard_site.png",
            title = "FridaGuard App",
            description = "Um app para assegurar o script Frida ser executado",
            url = "https://github.com/Vitor-VX/fridaguard-mobile",
            tags = listOf("Frida", "TCP", "Kotlin", "Jetpack Compose", "Javascript")
        ),
        ProjectData(
            icon = "ic_project_codecheck_site.png",
            title = "Login Check",
            description = "Uma tela de login, com foco na parte do backend",
            url = "https://github.com/Vitor-VX/Code-Verify-Auth",
            tags = listOf("Javascript", "Html", "Css", "SendGrid", "Nodejs")
        ),
    )

    Column(
        modifier = modifier
            .padding(8.px)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(110.px)
    ) {
        GreetingSection(modifier = Modifier.align(Alignment.CenterHorizontally))
        ProjectHighlightsSection(projectList)
    }
}

@Composable
fun GreetingSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(Width.FitContent)
            .padding(10.px)
    ) {
        P(attrs = TextStyleContentApp.toModifier().toAttrs()) {
            Text("Olá, eu sou")
        }

        P(attrs = TextHeaderName.toModifier()
            .backgroundImage(linearGradient(LinearGradient.Direction.ToRight) {
                add(Color("#9845E8"))
                add(Color("#33D2FF"), 55.percent)
                add(Color("#DD5789"), 100.percent)
            })
            .backgroundClip(BackgroundClip.Text)
            .color(Color.transparent)
            .toAttrs()
        ) {
            Text("João Victor R.")
        }

        P(attrs = TextPresentationContentApp.toModifier()
            .widthIn(min = 300.px, max = 500.px)
            .letterSpacing(2.px)
            .styleModifier {
                property("word-wrap", "break-word")
                property("white-space", "normal")
            }
            .toAttrs()
        ) {
            Text(
                value = "Sou desenvolvedor especializado em Android nativo, com mais de dois anos de experiência em diversas linguagens. Durante essa trajetória, trabalhei desde a criação de APIs até o desenvolvimento de interfaces frontend de alta qualidade, sempre buscando unir um bom conhecimento de backend a um design intuitivo."
            )
        }

        SocialMediaSection()
    }
}

@Composable
fun SocialMediaSection() {
    Row(
        modifier = Modifier.margin(top = 50.px),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.px)
    ) {
        val listSocialMedia = listOf(
            SocialMedia("Github", "https://github.com/Vitor-VX") { FaGithub(modifier = Modifier.color(Color.white).margin(left = 8.px)) },
            SocialMedia("Linkedin", "https://www.linkedin.com/in/joao-victor-rocha-neto") { FaLinkedin(modifier = Modifier.color(Color.white).margin(left = 8.px)) },
            SocialMedia("Telegram", "https://t.me/if_vitor/") { FaTelegram(modifier = Modifier.color(Color.white).margin(left = 8.px)) },
        )

        listSocialMedia.forEach {
            SocialMediaButton(it)
        }
    }
}

@Composable
fun SocialMediaButton(socialMedia: SocialMedia) {
    Row(
        modifier = SocialMediaStyle.toModifier()
            .cursor(Cursor.Pointer)
            .onClick {
                document.open(url = socialMedia.url, name = "", features = "")
            }
            .width(Width.FitContent)
            .height(35.px)
            .styleModifier {
                property("border", "1px solid #833ab4")
                property("border-radius", "6px")
                property("border", "double 1px transparent")
                property("background-image", "linear-gradient(black, black), linear-gradient(90deg, #833ab4, #fd1d1d, #9845E8)")
                property("background-origin", "border-box")
                property("background-clip", "content-box, border-box")
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        socialMedia.icon()

        P(attrs = TextStyleContentApp.toModifier().color(Color.white).fontSize(13.px).toAttrs()) {
            Text(socialMedia.name)
        }
    }
}

@Composable
fun ProjectHighlightsSection(projectList: List<ProjectData>) {
    Column(
        modifier = Modifier
            .margin(top = 40.px)
            .fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .id("page-projects")
                .border(0.01.px, LineStyle.Solid, Color.gray)
                .fillMaxWidth(80.percent)
                .align(Alignment.CenterHorizontally)
                .margin(top = 30.px, bottom = 30.px)
        )

        P(attrs = TextProjectContentApp.toModifier()
            .fontSize(1.2.cssRem)
            .align(Alignment.CenterHorizontally)
            .fontFamily("Poppins")
            .toAttrs()
        ) {
            Text(value = "Projetos Destaques")
        }

        SimpleGrid(
            numColumns(1, sm = 2, md = 2),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            projectList.forEach { project ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    ProjectCard(
                        icon = project.icon,
                        title = project.title,
                        description = project.description,
                        url = project.url,
                        tags = project.tags,
                        isBuy = project.isBuy
                    )
                }
            }
        }
    }
}