import java.util.Random;

public class IaEasy extends Ia{
	public IaEasy(){
		super();
	}
	
	public void play(int round, Case[][] c){
		int i,j;
		Random r = new Random();
		do {
			
			i= 0 + r.nextInt(3);
			j = 0 + r.nextInt(3);
			
		}while(c[i][j].isChecked());
		c[i][j].setChecked(1);
	}
}
