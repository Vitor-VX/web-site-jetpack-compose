package com.victor.app.web.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column

import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.victor.app.web.components.ContentApp
import com.victor.app.web.components.HeaderApp
import com.victor.app.web.components.TextApp.TextDescriptionProjectContentApp
import com.victor.app.web.components.TextApp.TextHeaderName
import com.victor.app.web.components.TextApp.TextPresentationContentApp
import com.victor.app.web.components.TextApp.TextProjectContentApp
import com.victor.app.web.components.TextApp.TextStyleContentApp
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

data class SocialMedia(
    val name: String,
    val url: String,
    val icon: @Composable () -> Unit
)

val blinkAnimation = Keyframes {
    from { Modifier.opacity(0f) }
    to { Modifier.opacity(1f) }
}


data class ProjectData(
    val icon: String,
    val title: String,
    val description: String,
    val url: String,
    val tags: List<String>,
    var isBuy: Boolean = false
)

@Composable
fun Copyrigth(modifier: Modifier) {
    Row(
        modifier = modifier.margin(top = 100.px),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FaCopyright(
            modifier = Modifier.color(Color.gray)
        )

        P(
            attrs = TextStyleContentApp
                .toModifier()
                .margin(0.px)
                .fontFamily("Roboto")
                .color(Color.gray)
                .fontSize(13.px)
                .toAttrs()
        ) {
            Text("Todos os direitos reservados")
        }
    }
}

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier
            .backgroundColor(color = Color("#000000"))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.px)
        ) {
            HeaderApp()
            ContentApp(modifier = Modifier.align(Alignment.CenterHorizontally).margin(top = 70.px))
            Copyrigth(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}