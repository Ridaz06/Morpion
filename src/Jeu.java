import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jeu implements Constantes{
	private Case[][] tabJeu = new Case [nbCasesLigne][nbCasesColonne];
	public Jeu(){
		for (int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++)
				tabJeu[i][j] = new Case(10 + i*100, 10 + j*100); 
	}
	
	public void click(int x, int y){
		System.out.println("Click at x: " + x +" y: " + y );
	}
	private void calculJoueur(){
		
	}
	
	private void iaCalcul(){
		
	}
	public void affichage(Graphics g) {
		Image img = null;
		try {
			img = ImageIO.read(new File("img/case.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++){
				g.drawImage(img, 10 + i*100, 10 + j*100, null);
			//	if (tabJeu[i][j].isChecked())
				//	g.drawImage(tabJeu[i][j].getImage(), 10 + i*100, 10 + j*100, null);
			}
	}
}
