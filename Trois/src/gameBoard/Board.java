package gameBoard;

import gameBoard.C.Direction;

public class Board {  //change to singleton?
	Card[] boardArray = {null,new Card(1),null,new Card(0),
						null,new Card(0),new Card(0),null,
						new Card(1),new Card(1),new Card(2),null,
						new Card(0),null,new Card(1),null};//new Card[16]; //should go in init
	Deck deck;
	
	public Board(Deck d){deck=d;}

	void init(){boardArray= new Card[16];}
	Card[] moveUp(){
		Boolean changed=false;
		Card[] newArray = new Card[16];// = boardArray;
		for(int i=0;i<4;i++){newArray[i]=boardArray[i];}
		for(int i=4;i<16;i++){
		if(boardArray[i]!=null){
			if(newArray[i-4]==null)
									{newArray[i-4]=boardArray[i]; //if space above is empty, move card up
									newArray[i]=null;
									changed=true;}
			else if(newArray[i-4]==boardArray[i]){newArray[i-4].increment(); //if space above is same, combine cards
									newArray[i]=null;
									changed=true;}
			else if((newArray[i-4].getValue()==0 && boardArray[i].getValue()==1) ||
					(newArray[i-4].getValue()==1 && boardArray[i].getValue()==0))
									{newArray[i-4].setValue(2); //if card is 1/2 space above is 2/1, combine cards
									newArray[i]=null;
									changed=true;}
			else newArray[i]=boardArray[i];
			}
		}
		//if(changed)addCard();
		return changed?newArray:null;} //returns array to be shown
	
	Card[] checkMove(Direction d){
		switch(d){
			case UP: return moveUp();
			case DOWN:
			case LEFT:
			case RIGHT:
			default: return null;}
		}//if null, don't offer commit
	void commitMove(Direction d){
		Card[] temp=checkMove(d);
		if(temp!=null)boardArray=temp;}
	
	public Card[] readBoard(){return boardArray;}
}

/* Board is 4x4
 * Up moves check space at -4 (if index above 3) from top down
 * Down moves check space at +4 (if index below 12) from bottom up
 * Left moves check space at -1 (if index is not 0,4,8,12) from left to right
 * Right moves check space at +1 (if index is not 3,5,7,11) from right to left */

/*test board
 *  2 1
 * 11 
 *223 
 *1 2 */
