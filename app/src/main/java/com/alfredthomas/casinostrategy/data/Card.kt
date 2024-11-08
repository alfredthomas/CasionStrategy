package com.alfredthomas.casinostrategy.data

import android.graphics.Color.BLACK
import android.graphics.Color.RED
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import com.alfredthomas.casinostrategy.R

const val SUIT = "suit"
const val RANK = "rank"

data class Card(val rank: Rank, val suit: Suit)

enum class Rank(@StringRes val stringRes: Int) {
    ACE(R.string.ace),
    TWO(R.string.two),
    THREE(R.string.three),
    FOUR(R.string.four),
    FIVE(R.string.five),
    SIX(R.string.six),
    SEVEN(R.string.seven),
    EIGHT(R.string.eight),
    NINE(R.string.nine),
    TEN(R.string.ten),
    JACK(R.string.jack),
    QUEEN(R.string.queen),
    KING(R.string.king),
    JOKER(R.string.joker),
}

enum class Suit(@StringRes val stringRes: Int, @ColorInt val color: Int) {
    CLUB(R.string.club, BLACK),
    DIAMOND(R.string.diamond, RED),
    HEART(R.string.heart, RED),
    SPADE(R.string.spade, BLACK),
}
