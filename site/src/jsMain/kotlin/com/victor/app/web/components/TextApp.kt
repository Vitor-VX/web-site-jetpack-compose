package com.victor.app.web.components

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

object TextApp {
    val TextHeaderName = CssStyle {
        base {
            Modifier
                .color(Color.white)
                .margin(5.px)
                .fontSize(8.0.cssRem)
                .fontFamily("DM Sans")
                .cursor(Cursor.Pointer)
        }

        // cell
        Breakpoint.ZERO {
            Modifier.fontSize(3.0.cssRem)
        }

        // tablet
        Breakpoint.MD {
            Modifier.fontSize(3.5.cssRem)
        }

        Breakpoint.SM {
            Modifier.fontSize(5.0.cssRem)
        }

        Breakpoint.LG {
            Modifier.fontSize(8.0.cssRem)
        }
    }

    val TextStyleHeaderApp = CssStyle {
        base {
            Modifier
                .color(Color.white)
                .margin(5.px)
                .fontSize(0.10.cssRem)
                .padding(left = 5.px, right = 5.px)
                .fontFamily("Inter")
                .cursor(Cursor.Pointer)
        }
        // cell
        Breakpoint.ZERO {
            Modifier.fontSize(0.6.cssRem)
        }

        // tablet
        Breakpoint.MD {
            Modifier.fontSize(0.7.cssRem)
        }
    }

    val TextStyleContentApp = CssStyle {
        base {
            Modifier
                .fontSize(0.8.cssRem)
                .color(Color.white)
                .margin(5.px)
                .padding(left = 5.px, right = 5.px)
                .fontFamily("Inter")
        }
        Breakpoint.SM {
            Modifier.fontSize(0.75.cssRem)
        }
        Breakpoint.MD {
            Modifier.fontSize(0.85.cssRem)
        }
        Breakpoint.LG {
            Modifier.fontSize(0.9.cssRem)
        }
    }

    val TextProjectContentApp = CssStyle {
        base {
            Modifier
                .fontSize(0.8.cssRem)
                .color(Color.white)
                .fontFamily("Roboto")
        }
        Breakpoint.ZERO {
            Modifier.fontSize(0.4.cssRem)
        }
        Breakpoint.SM {
            Modifier.fontSize(0.6.cssRem)
        }
        Breakpoint.MD {
            Modifier.fontSize(0.7.cssRem)
        }
        Breakpoint.LG {
            Modifier.fontSize(0.8.cssRem)
        }
    }

    val TextTitleProjectContentApp = CssStyle {
        base {
            Modifier
                .color(Color.white)
                .fontFamily("Poppins")
        }
        Breakpoint.ZERO {
            Modifier.fontSize(0.6.cssRem)
        }
        Breakpoint.SM {
            Modifier.fontSize(0.7.cssRem)
        }
        Breakpoint.MD {
            Modifier.fontSize(0.8.cssRem)
        }
        Breakpoint.LG {
            Modifier.fontSize(0.9.cssRem)
        }
    }

    val TextDescriptionProjectContentApp = CssStyle {
        base {
            Modifier
                .color(Color("#C4C4C4"))
                .fontFamily("Inter")
        }
        Breakpoint.ZERO {
            Modifier.fontSize(0.5.cssRem)
        }
        Breakpoint.SM {
            Modifier.fontSize(0.6.cssRem)
        }
        Breakpoint.MD {
            Modifier.fontSize(0.7.cssRem)
        }
        Breakpoint.LG {
            Modifier.fontSize(0.8.cssRem)
        }
    }

    val TextPresentationContentApp = CssStyle {
        base {
            Modifier
                .color(Color("white"))
                .fontFamily("Inter")
        }
        Breakpoint.ZERO {
            Modifier.fontSize(0.5.cssRem)
        }
        Breakpoint.SM {
            Modifier.fontSize(0.6.cssRem)
        }
        Breakpoint.MD {
            Modifier.fontSize(0.7.cssRem)
        }
        Breakpoint.LG {
            Modifier.fontSize(0.8.cssRem)
        }
    }
}