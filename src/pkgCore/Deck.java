package pkgCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}
	
	public int getRemaining(Object eNum) {
		int j = 0;
			for (int i = 0; i<cardsInDeck.size()-1; i++)
				if (eNum instanceof eSuit) {
					if (cardsInDeck.get(i).geteSuit()==eNum)
						j++;
				} else { 
					if (cardsInDeck.get(i).geteRank()==eNum)
						j++;
				} return j; 
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
}