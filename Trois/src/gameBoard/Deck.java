package gameBoard;

import java.util.ArrayList;
import java.util.Random;

public class Deck { //4 1s, 4 2s, 4 3s and random 6s and 12s
	//final int[] standardDeck = {0,0,0,0,1,1,1,1,2,2,2,2};
	ArrayList<Integer> deck = new ArrayList<Integer>();
	
	void shuffleDeck(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Random r = new Random();
		for(int i=0;i<C.standardDeck.length;i++){temp.add(C.standardDeck[i]);}
		while(!temp.isEmpty())deck.add(temp.remove(r.nextInt(temp.size())));
	}
	
	Card getNextCard(){
		if(deck.isEmpty()) shuffleDeck();
		Card c = new Card(deck.remove(0));
		return c;}
}
