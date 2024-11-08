package com.alfredthomas.casinostrategy.ui.poker

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.alfredthomas.casinostrategy.R
import com.alfredthomas.casinostrategy.data.Card
import com.alfredthomas.casinostrategy.ui.base.PlayingCardView

class CardActionView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    val cardView: PlayingCardView
    val holdText: TextView
    val holdButton: Button

    var cardAction: CardAction? = null

    init {
        inflate(context, R.layout.card_action_view, this).apply {
            cardView = findViewById<PlayingCardView>(R.id.card).apply {
                setOnClickListener {
                    toggleHold()
                }
            }
            holdText = findViewById(R.id.hold_text)
            holdButton = findViewById<Button>(R.id.hold_button).apply {
                setOnClickListener {
                    toggleHold()
                }
            }
        }
    }

    fun bind(cardAction: CardAction?) {
        this.cardAction = cardAction?.also { action ->
            cardView.bindCard(action.card)
            holdText.visibility = if (action.isHeld) VISIBLE else INVISIBLE
        }
    }

    private fun toggleHold() {
        cardAction?.toggleHeld()
        bind(cardAction)
    }

}

data class CardAction(val card: Card, var isHeld: Boolean = false) {
    fun toggleHeld() {
        isHeld = !isHeld
    }

}