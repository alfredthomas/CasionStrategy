package com.alfredthomas.casinostrategy.ui.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.alfredthomas.casinostrategy.R
import com.alfredthomas.casinostrategy.data.Card

class PlayingCardView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    val rankViews = mutableListOf<TextView>()
    val suitViews = mutableListOf<TextView>()

    init {
        LayoutInflater.from(context).inflate(R.layout.card, this, true)?.also {
            rankViews.add(findViewById<TextView>(R.id.rank_top))
            rankViews.add(findViewById<TextView>(R.id.rank_bottom))
            suitViews.add(findViewById<TextView>(R.id.suit_middle))
        }
        setBackgroundResource(R.drawable.rounded_corners_border)
    }

    fun bindCard(card: Card) {
        // Loop through each type in case we add more later
        rankViews.forEach { textView ->
            textView.apply {
                setText(card.rank.stringRes)
                setTextColor(card.suit.color)
            }
        }
        suitViews.forEach { textView ->
            textView.setText(card.suit.stringRes)
            textView.setTextColor(card.suit.color)
        }
    }
}