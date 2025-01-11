package com.victor.app.web.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import org.w3c.dom.ScrollBehavior
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaCode
import com.varabyte.kobweb.silk.components.icons.fa.FaHouse
import com.varabyte.kobweb.silk.components.icons.fa.FaPaperPlane
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.victor.app.web.components.TextApp.TextStyleHeaderApp
import com.victor.app.web.pages.SocialMedia
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

val styleHeader = CssStyle {
    hover {
        Modifier
            .cursor(Cursor.Pointer)
            .margin(5.px)
            .transition(Transition.of("margin", 300.ms))
    }
}

@Composable
fun SocialMediaButton(text: String, icon: @Composable () -> Unit) {
    Column(
        modifier = styleHeader.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = TextStyleHeaderApp
                .toModifier()
                .onClick {
                    when(text) {
                        "Projetos" -> {
                            document.getElementById("page-projects")?.scrollIntoView()
                        }
                        "Contato" -> {
                            document.open(url = "https://t.me/if_vitor/", name = "", features = "")
                        }
                    }
                }
                .toAttrs()
        ) {
            Text(value = text)
        }
        icon()
    }
}

@Composable
fun HeaderApp() {
    val buttonsData = listOf(
        SocialMedia("Home", "") { FaHouse(modifier = Modifier.color(color = Color.white)) },
        SocialMedia("Projetos", "") { FaCode(modifier = Modifier.color(color = Color.white)) },
        SocialMedia("Contato", "") { FaPaperPlane(modifier = Modifier.color(color = Color.white)) },
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.px)
            .borderBottom(1.px, LineStyle.Solid, Color.gray)
            .backgroundColor(Color.black),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        buttonsData.forEach { (text, _, icon) ->
            SocialMediaButton(text, icon)
        }
    }
}