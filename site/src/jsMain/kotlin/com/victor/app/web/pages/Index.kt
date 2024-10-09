package com.victor.app.web.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

val ButtonStyleApp = CssStyle {
    base {
        Modifier
            .backgroundColor(rgb(98, 0, 238))
            .fontFamily("Roboto")
            .color(Color.white)
            .padding(10.px, 18.px)
            .border(0.px)
            .borderRadius(8.px)
            .transition(Transition.of("background-color", 300.ms, AnimationTimingFunction.EaseInOut))
            .fontSize(16.px)
    }
    hover {
        Modifier
            .backgroundColor(rgb(55, 0, 179))
            .boxShadow(offsetX = 0.px, offsetY = 6.px, blurRadius = 12.px, color = rgba(0, 0, 0, 0.3))
    }
}

val ColumnStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(color = Color("#FFF"))
            .border(0.px)
            .padding(32.px)
            .borderRadius(12.px)
            .width(80.percent)
            .maxWidth(450.px)
            .minWidth(300.px)
    }
    hover {
        Modifier
            .padding(3.px)
            .transition(Transition.of("padding", 300.ms))
    }
}

val InputStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(rgb(245, 245, 245))
            .border(2.px, color = rgb(200, 200, 200))
            .padding(10.px)
            .borderRadius(6.px)
            .fontFamily("Roboto")
            .color(rgb(30, 30, 30))
            .fontSize(15.px)
            .width(100.percent)
            .maxWidth(600.px)
    }
    focus {
        Modifier.border(2.px, color = rgb(100, 100, 255), style = LineStyle.None)
    }
}

@Composable
fun LicenseDeveloper(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .fontFamily("Roboto")
                .fontSize(14.px)
                .color(Color.gray)
                .toAttrs()
        ) {
            Text("Licensed by Vitor VX")
        }

        FaGithub(
            modifier = Modifier,
            size = IconSize.LG
        )
    }
}

@Page
@Composable
fun HomePage() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Color("#f2f2f2"))
    ) {
        Column(
            modifier = ColumnStyle.toModifier()
                .align(Alignment.Center)
                .padding(16.px)
        ) {
            P(
                attrs = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fontSize(28.px)
                    .fontFamily("Poppins")
                    .color(Color("#333"))
                    .toAttrs()
            ) {
                Text("Login")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 12.px),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.px)
            ) {
                FaEnvelope(
                    size = IconSize.LG
                )

                Input(
                    type = InputType.Text,
                    attrs = InputStyle.toModifier()
                        .boxShadow(offsetX = 0.px, offsetY = 2.px, blurRadius = 5.px, color = rgba(0, 0, 0, 0.1))
                        .toAttrs {
                            this.placeholder("Email")
                            this.onInput { username = it.value }
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 12.px),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.px)
            ) {
                FaLock(
                    size = IconSize.LG
                )

                Input(
                    type = InputType.Password,
                    attrs = InputStyle.toModifier()
                        .boxShadow(offsetX = 0.px, offsetY = 2.px, blurRadius = 5.px, color = rgba(0, 0, 0, 0.1))
                        .toAttrs {
                            placeholder("Password")
                            onInput { password = it.value }
                        }
                )
            }

            Button(
                attrs = ButtonStyleApp.toModifier()
                    .fillMaxWidth()
                    .margin(top = 20.px, bottom = 20.px)
                    .toAttrs()
            ) {
                Text("Login")
            }
        }

        LicenseDeveloper(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
