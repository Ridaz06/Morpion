import java.util.Random;

public class IaHard extends Ia{
	private boolean firstPlayer;
	private int nextX;
	private int nextY;
	private int lastX;
	private int secondNextX;
	private int lastY;
	private int secondNextY;
	public IaHard(){
		super();
	}
	
	public void play(int round, Case[][] c){
		
		//Si c'est le premier tour on joue au milieu
		if (round == 0){
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
		
		if (firstPlayer){
			
			if (round == 1){
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
				}
				
				if (c[0][1].isChecked()){
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
				}
				
				if (c[2][1].isChecked()){
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
				}
				
				if (c[1][2].isChecked()){
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
				}
				return;
			}
			
			if (round == 2){
				if (!c[nextX][nextY].isChecked())
					c[nextX][nextY].setChecked(1);
				else {
					c[secondNextX][secondNextY].setChecked(1);
					lastX = secondNextX;
					lastY = secondNextY;
				}
				return;
			}
			if (round == 3){
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
			}
				
		}
	}
	
	
}
