// This program implements the connect4 game
//
//
package score4;

import java.util.Random;
import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		int column, row;
		Scanner in = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		
		//select names
		Player player1 = new Player();
		System.out.println("Please enter the name of the 1st player: ");
		String name = in.nextLine();
		player1.setPlayersName(name);
		
		Player player2 = new Player();
		System.out.println("Please enter the name of the 2ond player: ");
		name = in.nextLine();
		player2.setPlayersName(name);
		
		//chip select
		player1.selectChip(player1.getPlayersName());
		
		if(player1.getPlayersChip().equals("o")) 
			player2.setPlayersChip("x");
		else 
			player2.setPlayersChip("o");
		
		System.out.println(player2.getPlayersName()+", your chip is: " + player2.getPlayersChip());
		
		
		
		//Create game board
		
		Scanner input = new Scanner(System.in);
		Board boardGame = new Board();
		while(true) {
			System.out.println("Please enter the number of rows: ");
		     row = input.nextInt();
			if(row >= 4 & row <= 15) {
				boardGame.setBoardRow(row);
				break;
			}else 
				System.out.println("Ops! Not valid number. Enter a number between 4 and 15 ");
		}
		
		while(true) {
			System.out.println("Please enter the number of collums: ");
			 column = input.nextInt();
			if(column >= 4 & column <= 15) {
				boardGame.setBoardColumn(column);
				break;
			}else 
				System.out.println("Ops! Not valid number. Enter a number between 4 and 15 ");
		}

		
		String[][] newBoard = new String[row+2][column+2];
		
		boardGame.createBoard(newBoard);
	
		
		//Chooses who will be the first player
		Random rand = new Random();
		int rand1 = rand.nextInt();
		int rand2 = rand.nextInt();
		player1.setPlayersNum(rand1);
		player2.setPlayersNum(rand2);
		int round ;
		if(player1.getPlayersNum() > player2.getPlayersNum()) {
			System.out.println(player1.getPlayersName()+" plays first");
			round = 2;
		}
		else {
			System.out.println(player2.getPlayersName()+" plays first");
			round = 3;
		}
		//Game
		int win = 0;
		int choise;
		boardGame.printBoard( newBoard, row, column);
		System.out.println("Ok! Let's play!");
		
		while(true){
			//for 1st player
			if(round==2) {
				choise = player1.selectCollum(row, column);
				int index = 2;
				while(true) {
					if(newBoard[index][choise].equals(" -")) {
						newBoard[index][choise] = " "+player1.getPlayersChip();
						round=3;
						boardGame.printBoard( newBoard, row, column);
						if((" "+player1.getPlayersChip()).equals(boardGame.horizontalWin(newBoard, row, column))){
								System.out.println(player1.getPlayersName()+" is a winner");
								win = 1;
						}
						if((" "+player1.getPlayersChip()).equals(boardGame.verticalWin(newBoard, row, column))) {
								System.out.println(player1.getPlayersName()+" is a winner");
								win = 1;
						}	
						if((" "+player1.getPlayersChip()).equals(boardGame.diagonalWin(newBoard, row, column))) {
							System.out.println(player1.getPlayersName()+" is a winner");
							win = 1;
						}	
						if((" "+player1.getPlayersChip()).equals(boardGame.diagonalWin2(newBoard, row, column))) {
							System.out.println(player1.getPlayersName()+" is a winner");
							win = 1;
						}	
						break;
					}
					else if (index==(row+1)) {
						System.out.println("The collum "+choise+" is full. Select new collum");
						choise = input.nextInt();
						index = 2;
					}else 
						++index;
				}
				
			}
			if(win==1)
				break;
			//for 2ond player
			if(round==3){	
				choise = player2.selectCollum(row, column);
				int index = 2;
				while(true) {
					if(newBoard[index][choise].equals(" -")) {
						newBoard[index][choise] = " "+player2.getPlayersChip();
						round=2;
						boardGame.printBoard( newBoard, row, column);
						if((" "+player2.getPlayersChip()).equals(boardGame.horizontalWin(newBoard, row, column))){
								System.out.println(player2.getPlayersName()+" is a winner");
								win = 1;
						}
						if((" "+player2.getPlayersChip()).equals(boardGame.verticalWin(newBoard, row, column))) {
								System.out.println(player2.getPlayersName()+" is a winner");
								win = 1;
						}
						if((" "+player2.getPlayersChip()).equals(boardGame.diagonalWin(newBoard, row, column))) {
							System.out.println(player2.getPlayersName()+" is a winner");
							win = 1;
						}
						if((" "+player2.getPlayersChip()).equals(boardGame.diagonalWin2(newBoard, row, column))) {
							System.out.println(player2.getPlayersName()+" is a winner");
							win = 1;
						}	
						
						break;
					}
					else if (index==(row+1)) {
						System.out.println("The collum "+choise+" is full. Select new collum");
						choise = input.nextInt();
						index = 2;
						
					}else 
						++index;
				}
			}
			if(win==1)
				break;
			if(boardGame.checkFullBoard(newBoard, row, column)) {
				System.out.println("Draw! Good game, well played!");
				break;
			}
				
	}
		in.close();
		input.close();
		input2.close();
	}//close main
}//close

	
	
