package gameBoard;

public class Card {
	int value;

	public Card(int v){setValue(v);}
	
	void setValue(int v){value=v;}
	int getValue(){return value;}
	void increment(){value++;}
	
	int getFaceValue(){return(value<3)?(value+1):(6*(value-2));} //cards 1st, 2nd and 3rd give 1, 2 and 3. 4th = 6, 5th = 12, etc
	int getScore(){
		if(value<2)return 0; //1 and 2 are worth 0 points
		int score=1;
		for(int i=0;i<value-1;i++){score*=3;}
		return score;}

}
