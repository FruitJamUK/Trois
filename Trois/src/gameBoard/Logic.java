package gameBoard;

import gameBoard.C.Direction;;

public class Logic {
	Deck deck = new Deck();
	Board board = new Board(deck);
			
			public void input(){board.commitMove(Direction.UP);}
			public String[] displayBoard(){
				String[] cards =  new String[16];
					for(int i=0;i<16;i++)cards[i]=(board.readBoard()[i]!=null)?"| "+board.readBoard()[i].getFaceValue()+" |":"|   |";
					return cards;}
			int finalScore(){//could also be used for current score
				int score=0;
				for(int i=0;i<16;i++)score+=board.readBoard()[i].getScore();
				return score;}
		}

