import java.util.Random;

public class IaHard extends Ia{
	private boolean firstPlayer;
	private int nextX;
	private int nextY;
	public IaHard(){
		super();
	}
	
	public void play(int round, Case[][] c){
		
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
					nextY = 0;
					nextX = (i == 0) ? 2: 0;
				}
				return;
			}
			
			if (!c[nextX][nextY].isChecked())
				c[nextX][nextY].setChecked(1);
				
		}
	}
	
	
}
