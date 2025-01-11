package com.victor.app.web.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaCartShopping
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.victor.app.web.components.TextApp.TextDescriptionProjectContentApp
import com.victor.app.web.components.TextApp.TextProjectContentApp
import com.victor.app.web.components.TextApp.TextTitleProjectContentApp
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val SocialMediaStyle = CssStyle {
    base {
        Modifier
            .transform {
                scale(1.0)
            }
            .transition(
                Transition.Companion.of("transform", 300.ms)
            )
    }
    hover {
        Modifier
            .transform {
                scale(1.1)
            }
            .transition(
                Transition.Companion.of("transform", 300.ms)
            )
    }
}

@Composable
fun ProjectCard(
    icon: String,
    title: String,
    description: String,
    url: String,
    tags: List<String>,
    isBuy: Boolean = false
) {
    Column(
        modifier = Modifier
            .padding(10.px)
            .margin(top = 8.px)
            .fillMaxWidth(50.percent)
    ) {
        Image(
            src = icon,
            modifier = Modifier
                .height(175.px)
                .fillMaxWidth(100.percent)
                .borderRadius(10.px)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.px)
        ) {
            P(
                attrs = TextTitleProjectContentApp
                    .toModifier()
                    .align(Alignment.Start)
                    .toAttrs()
            ) {
                Text(
                    value = title
                )
            }

            P(
                attrs = TextDescriptionProjectContentApp
                    .toModifier()
                    .align(Alignment.Start)
                    .toAttrs()
            ) {
                Text(
                    value = description
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(3.px)
            ) {
                tags.forEachIndexed { index, tag ->
                    P(
                        attrs = TextProjectContentApp
                            .toModifier()
                            .color(Color("#6CACE4"))
                            .toAttrs()
                    ) {
                        val symbol = if (index != tags.size - 1) {
                            " -"
                        } else {
                            ""
                        }
                        Text(value = "$tag$symbol")
                    }
                }
            }

            Row(
                modifier = SocialMediaStyle
                    .toModifier()
                    .cursor(Cursor.Pointer)
                    .onClick {
                        document.open(url = url, name = "", features = "")
                    }
                    .margin(top = 20.px)
                    .fillMaxWidth()
                    .styleModifier {
                        property("border", "1px solid #833ab4")
                        property("border-radius", "6px")
                        property("border", "double 1px transparent")
                        property(
                            "background-image",
                            "linear-gradient(black, black), linear-gradient(90deg, #833ab4, #DD5789, #fcb045)"
                        )
                        property("background-origin", "border-box")
                        property("background-clip", "content-box, border-box")
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (isBuy) {
                    FaCartShopping(
                        modifier = Modifier.color(color = Color.white).margin(top = 8.px, bottom = 8.px)
                    )

                    P(
                        attrs = TextProjectContentApp
                            .toModifier()
                            .margin(left = 5.px)
                            .fontFamily("Inter")
                            .toAttrs()
                    ) {
                        Text(
                            value = "Disponível para compra"
                        )
                    }
                } else {
                    FaGithub(
                        modifier = Modifier.color(color = Color.white).margin(top = 8.px, bottom = 8.px)
                    )

                    P(
                        attrs = TextProjectContentApp
                            .toModifier()
                            .margin(left = 5.px)
                            .fontFamily("Inter")
                            .toAttrs()
                    ) {
                        Text(
                            value = "Ir para o projeto"
                        )
                    }
                }
            }
        }
    }
}