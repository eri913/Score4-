package score4;

import java.util.Arrays;

public class Board {

	private int boardColumn, boardRow;

	public Board() {
		boardColumn = 4;
		boardRow = 4;
	}
	
	public Board(int row, int column){
		boardColumn = column;
		boardRow = row;
	}
	
	public int getBoardColumn() {
		return boardColumn;
	}

	public void setBoardColumn(int boardColumn) {
		this.boardColumn = boardColumn;
	}

	public int getBoardRow() {
		return boardRow;
	}

	public void setBoardRow(int boardRow) {
		this.boardRow = boardRow;
	}
	
	
	//This method create the board
	public  String[][] createBoard(String[][] board) {
		board[0][0] = " ";
		board[0][boardColumn+1] =" ";
		board[1][0] = "--";
		board[1][boardColumn+1] = "-";
		for(int k=1; k<(boardColumn+1); ++k) {
			board[0][k] =(" "+Integer.toString(k));
			board[1][k] = "--";
		}
		
		for(int i=2; i<=(boardRow+1); ++i) {
					board[i][0] = "|";
					board[i][boardColumn+1] = " |";
		}
		
		for(int i=2; i<=(boardRow+1); ++i) {
			for(int j=1; j<=(boardColumn); ++j)
				board[i][j] = " -";	
		}	
		return board;
	}

	//This method prints the board	
	public void printBoard(String[][] board, int row, int column) {
			for(int i=(row+1); i>=0; --i) {
				for(int j=0; j<=(column+1); ++j) 
					System.out.print(board[i][j]);
				System.out.println();
			}
	}
			
	// Horizontal spans
	public String horizontalWin(String[][] board, int row, int column) {
		String symbolsInRow;
		String winningSymbol = " ";
		int counter = 0;
		for(int i=2; i<=(row+1); ++i) {
			counter = 0;
			symbolsInRow = board[i][1];
			for(int j=1; j<=column; ++j) {
				if(board[i][j].equals(symbolsInRow) & !" -".equals(board[i][j])) {
					winningSymbol = symbolsInRow;
					counter++;
					if(counter==4)
						return winningSymbol;
				}
				else {
					symbolsInRow = board[i][j];
					counter = 1;
				}
			}	
		}
		
			return ("p");
	}	
	// Vertical spans
	public String verticalWin(String[][] board, int row, int column) {
		String symbolsInColumn;
		String winningSymbol = " ";
		int counter = 0;
		for(int j=1; j<=(column+1); ++j) {
			counter = 0;
			symbolsInColumn = board[2][j];
			for(int i=2; i<=row+1; ++i) {
				if(board[i][j].equals(symbolsInColumn) & !" -".equals(board[i][j])) {
					winningSymbol = symbolsInColumn;
					counter++;
					if(counter==4)
						return winningSymbol;
				}
				else {
					symbolsInColumn = board[i][j];
					counter = 1;
				}
			}	
		}
		return ("p");
	}	
	
	//Down-left diagonals
	public String diagonalWin(String[][] board, int row, int column) {
		int index;
		int counter = 0;
		String symbolsInDiagonal;
		String winningSymbol = " -";
        for (int j=1; j<=column-3; ++j) {
        	index=4;
            for (int i=2; i<=row-3; ++i) {
                counter = 0;
                symbolsInDiagonal = board[i][j];
                for (int x=0; x<=index; x++) {
                    if(board[i+x][j+x].equals(symbolsInDiagonal) & !" -".equals(board[i+x][j+x])){
                    	winningSymbol = symbolsInDiagonal;
                    	counter++;
                    	if(counter==4)
                			return winningSymbol;
                    }else {
                    	symbolsInDiagonal = board[i+x][j+x];
                    	counter = 1;
                    }
                }
                --index;
            }
        }
        return ("p");
		
	}
	//Down-Right diagonals
	public String diagonalWin2(String[][] board, int row, int column) {
		int index;
		int counter = 0;
		String symbolsInDiagonal;
		String winningSymbol = " -";
		for (int j=1; j<=column-3; ++j) {
			index = 4;
			for (int i=row; i>row-3; --i) {
		         counter = 0;
	             symbolsInDiagonal = board[i][j];
	             for (int x=0; x<=index; x++) {
	            	 if(board[i-x][j+x].equals(symbolsInDiagonal)){
	                    winningSymbol = symbolsInDiagonal;
	                    counter++;
	                	if(counter==4)
	        				return winningSymbol;
	                 }else {
	                    symbolsInDiagonal = board[i-x][j+x];
	                    counter = 0;
	                 }
	            }
	             --index;
	       }
		} 
		return ("p");
	 }
	
	//full board
	public boolean checkFullBoard (String[][] board, int row, int column) {
		int counter=0;
			for(int j=1; j<=column; ++j) {
				if(!(" -").equals(board[row+1][j]))
					counter++;
			}
			if(counter == column)
				return true;
			else 
				return false;
		}
	}
			


