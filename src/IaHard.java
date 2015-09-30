import java.util.Random;

public class IaHard extends Ia{
	private boolean firstPlayer;
	private int nextX;
	private int nextY;
	private int lastX;
	private int secondNextX;
	private int lastY;
	private int secondNextY;
	private boolean playInCross;
	public IaHard(){
		super();
	}
	
	public void play(int round, Case[][] c){
		System.out.println("Tour : " + round);
		//Si on joue en premier
		if (round == 0)
			firstRound(c);
		else if (firstPlayer && round == 1)
			firstPlayerRoundOne(c);
		else if (firstPlayer && round == 2)
			firstPlayerRoundTwo(c);
		else if (firstPlayer && round == 3)
			firstPlayerRoundThree(c);
		else if (firstPlayer && round == 4)
			firstPlayerRoundFour(c);
		
		//Si on joue pas en premier
		
	}
	private void firstRound(Case[][] c){
		//Si c'est le premier tour on joue au milieu
			boolean b = true;
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					if (c[i][j].isChecked()){
						b = false;
						break;
					}
			if (b){
				c[1][1].setChecked(1);
				firstPlayer = true;
				return;
			} else {
				firstPlayer = false;
				return;	
			}
	}
	
	private void firstPlayerRoundOne(Case[][] c){
				if (c[1][0].isChecked()){
					Random r = new Random();
					int i= 0 + r.nextInt(3);
					System.out.println("i = " + i);
					if ( i == 1)
						i = 0;
					c[i][0].setChecked(1);
					
					lastX = i;
					lastY = 0;
					
					secondNextY = 1;
					secondNextX = i;
					
					nextY = 2;
					nextX = (i == 0) ? 2: 0;
					
					playInCross = true;
				}
				
				else if (c[0][1].isChecked()){
					Random r = new Random();
					int i= 0 + r.nextInt(3);
					System.out.println("i = " + i);
					if ( i == 1)
						i = 0;
					c[0][i].setChecked(1);
					
					lastX = 0;
					lastY = i;
					
					secondNextX = 1;
					secondNextY = i;
					
					nextY = (i == 0) ? 2: 0;
					nextX = 2;
					
					playInCross = true;
				}
				
				else if (c[2][1].isChecked()){
					Random r = new Random();
					int i= 0 + r.nextInt(3);
					System.out.println("i = " + i);
					if ( i == 1)
						i = 0;
					c[2][i].setChecked(1);
					
					lastX = 2;
					lastY = i;
					
					secondNextX = 1;
					secondNextY = i;
					
					nextX = 0;
					nextY = (i == 0) ? 2: 0;
				
					playInCross = true;

				}
				
				else if (c[1][2].isChecked()){
					Random r = new Random();
					int i= 0 + r.nextInt(3);
					System.out.println("i = " + i);
					if ( i == 1)
						i = 0;
					c[i][2].setChecked(1);
					lastX = i;
					lastY = 2;
					
					secondNextX = i;
					secondNextY = 1;
					
					nextY = 0;
					nextX = (i == 0) ? 2: 0;
					playInCross = true;

				} else {
					playInCross = false;
					//Si le joueur 2 joue pas dans la croix on joue dans la diagonale oposé
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++)
							if (c[i][j].isChecked() && c[i][j].getPlayers() == 0){
								nextY = (j == 0) ? 2: 0;
								nextX = i;
								
								secondNextX = ( i == 0) ? 2: 0;;
								secondNextY = j;
								
								lastX = ( i == 0) ? 2: 0;
								lastY = (j == 0) ? 2: 0;
								c[lastX][lastY].setChecked(1);
								
								lastX = i;
								lastY = j;
							}
				}
	}
	
	private void firstPlayerRoundTwo(Case[][] c){
		if (playInCross){
			if (!c[nextX][nextY].isChecked())
				c[nextX][nextY].setChecked(1);
			else {
				c[secondNextX][secondNextY].setChecked(1);
				lastX = secondNextX;
				lastY = secondNextY;
			}
		} else {
			if (c[nextX][nextY].isChecked()){
					nextY = (lastX == nextX) ? 1: nextY;
					nextX = (lastY == nextY) ? 1:nextX;	
				}
			else if (c[secondNextX][secondNextY].isChecked()){
				nextY = (lastX == secondNextX) ? 1: secondNextY;
				nextX = (lastY == secondNextY) ? 1:secondNextX;	
			}
			c[nextX][nextY].setChecked(1);
			if (nextX == 0 || nextX == 2){
				nextX = (nextX == 0)? 2: 0;
			} else if (nextY == 0 || nextY == 2){
				nextY = (nextY == 0)? 2: 0;
			}
		}
	}
	
	private void firstPlayerRoundThree(Case[][] c){
		if (playInCross){
			if (lastY == 0){
				if (!c[1][2].isChecked())
					c[1][2].setChecked(1);
				else if (!c[0][0].isChecked())
					c[0][0].setChecked(1);
				else 
					c[2][0].setChecked(1);
			} else if (lastY == 2){
				if (!c[1][0].isChecked())
					c[1][0].setChecked(1);
				else if (!c[0][2].isChecked())
					c[0][2].setChecked(1);
				else
					c[2][2].setChecked(1);
			} else if (lastX == 0){
				if (!c[0][1].isChecked())
					c[0][1].setChecked(1);
				else if (!c[0][0].isChecked())
					c[0][2].setChecked(1);
				else 
					c[2][0].isChecked();
			}else if (lastX == 2){
				if (!c[2][1].isChecked())
					c[2][1].setChecked(1);
				else if (!c[2][0].isChecked())
					c[2][0].setChecked(1);
				else 
					c[2][2].isChecked();
			}
		} else {
			if (!c[nextX][nextY].isChecked()){
				c[nextX][nextY].setChecked(1);
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						if (!c[i][j].isChecked()){
							nextX = i;
							nextY = j;
						}
			} else {
				if (!c[1][0].isChecked())
					c[1][0].setChecked(1);
				else if (!c[0][1].isChecked())
					c[0][1].setChecked(1);
				else if (!c[2][1].isChecked())
					c[2][1].setChecked(1);
				else if (!c[1][2].isChecked())
					c[1][2].setChecked(1);
				
				if (!c[1][0].isChecked()){
					nextX = 1;
					nextY = 0;
				}else if (!c[0][1].isChecked()){
					nextX = 0;
					nextY = 1;
				}else if (!c[2][1].isChecked()){
					nextX = 2;
					nextY = 1;
				}if (!c[1][2].isChecked()){
					nextX = 1;
					nextY = 2;
				}
			}
		}
	}
	
	private void firstPlayerRoundFour(Case[][] c){
		if (!c[nextX][nextY].isChecked())
			c[nextX][nextY].setChecked(1);
	}
	
}
