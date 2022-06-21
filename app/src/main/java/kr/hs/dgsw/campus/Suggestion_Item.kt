package kr.hs.dgsw.campus

import java.io.Serializable

data class Suggestion_Item(
    val Img: String,
    val Name: String,
    val Price: String,
    val Rate: String
): Serializable
