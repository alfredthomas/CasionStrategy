package com.alfredthomas.casinostrategy

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alfredthomas.casinostrategy.action.shuffle
import com.alfredthomas.casinostrategy.data.Deck
import com.alfredthomas.casinostrategy.ui.poker.CardAction
import com.alfredthomas.casinostrategy.ui.poker.CardActionView

/**
 * A simple [Fragment] subclass.
 * Use the [VideoPokerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoPokerFragment : Fragment() {

    val deck: Deck = Deck.new()
    val hand: MutableList<CardActionView> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }
    override fun onDestroy() {
        super.onDestroy()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_poker, container, false).apply {
            hand.add(findViewById(R.id.card1))
            hand.add(findViewById(R.id.card2))
            hand.add(findViewById(R.id.card3))
            hand.add(findViewById(R.id.card4))
            hand.add(findViewById(R.id.card5))
            setupNewHand()
        }
    }

    private fun setupNewHand() {
        deck.shuffle()
        for (card in hand) {
            deck.dealCard()?.let {
                card.bind(CardAction(it))
            }
        }

    }
}