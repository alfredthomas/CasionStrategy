package com.alfredthomas.casinostrategy.data

data class Deck(val cards: MutableList<Card>) {
    private var currentIndex = 0

    fun dealCard(): Card? = cards.getOrNull(currentIndex)?.also { currentIndex++ }

    fun reset() {
        currentIndex = 0
    }
    companion object {
        private val jokerSuits = setOf<Suit>(Suit.SPADE, Suit.HEART)

        fun newCardList(addJokers: Boolean): MutableList<Card> {
            val deck = mutableListOf<Card>()
                for (suit in Suit.entries) {
                    for (rank in Rank.entries) {
                        if (canAddCard(suit, rank, addJokers)) {
                            deck.add(Card(rank, suit))
                        }
                    }
                }
            return deck
            }



        fun new(addJokers: Boolean = false): Deck = Deck(newCardList(addJokers))

        private fun canAddCard(suit: Suit, rank: Rank, addJokers: Boolean): Boolean =
            (addJokers && rank == Rank.JOKER && suit in jokerSuits) || rank != Rank.JOKER
    }
}