package score4;

import java.util.Scanner;

public class Player {
	
	private String playersName;
	private String playersChip;
	private int playersNum;
	private int playersScore;
	
	public Player() {
		playersName = "No name";
		playersChip = "No chip selected";
		playersScore = 0;
	}

	public Player(String name, String chip, int score) {
		playersName = name;
		playersScore = score;
		playersChip = chip;
	}
	
	public void setPlayersName(String playersName) {
		this.playersName = playersName;
	}
	
	public String getPlayersName() {
		return playersName;
	}

	public String getPlayersChip() {
		return playersChip;
	}

	public void setPlayersChip(String playersChip) {
		this.playersChip = playersChip;
	}
	
	public int getPlayersNum() {
		return playersNum;
	}

	public void setPlayersNum(int playersNum) {
		this.playersNum = playersNum;
	}

	public int getPlayersScore() {
		return playersScore;
	}

	public void setPlayersScore(int playersScore) {
		this.playersScore = playersScore;
	}
	
	public void selectChip(String name) {
		Scanner in = new Scanner(System.in); 
		while(true) {
		System.out.println(name + ", choose your chip: ");
		String chip = in.nextLine();
		if(chip.equals("x") || chip.equals("o")) {
			setPlayersChip(chip);
			break;
		}
		else
			System.out.println("Sorry! Enter a valid chip 'x' or 'o' ");
		}
	}

	public int selectCollum(int row, int column) {
		int choise;
		Scanner input2 = new Scanner(System.in);
		while(true) {
			System.out.println(getPlayersName()+", your turn. Select collum");
			choise = input2.nextInt();
			if(choise > column)
				System.out.println("Whoa! There's no column whith that number");
			else 
				return choise;
		}
	}
}
