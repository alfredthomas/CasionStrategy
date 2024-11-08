package com.alfredthomas.casinostrategy.action

import com.alfredthomas.casinostrategy.data.Card
import com.alfredthomas.casinostrategy.data.Deck
import kotlin.random.Random

fun MutableList<Card>.shuffle() {
    this.shuffle(Random)
}

fun Deck.shuffle() {
    cards.shuffle()
    reset()
}