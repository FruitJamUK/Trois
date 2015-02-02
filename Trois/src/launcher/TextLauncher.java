package launcher;

import gameBoard.Logic;

public class TextLauncher {
	static Logic logic = new Logic();
	public static void main(String[] args){
		printBoard();
		for(int i=0;i<3;i++){
			logic.input();
			printBoard();
		}
	}
	
	static void printBoard(){
		for(int i=1;i<=16;i++){
			if(i%4==0)System.out.println(logic.displayBoard()[i-1]);
			else System.out.print(logic.displayBoard()[i-1]);
			}
		System.out.println("");
		}
}
