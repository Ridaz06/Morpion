import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Jeu implements Constantes{
	private Case[][] tabJeu = new Case [nbCasesLigne][nbCasesColonne];
	private Image img = null;
	private Toolkit toolkit = null;
	public Jeu(){
		toolkit = Toolkit.getDefaultToolkit();
		img = new ImageIcon("img/case.png").getImage();
		for (int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++){
				tabJeu[i][j] = new Case(5 + i*100, 5 + j*100); 
				tabJeu[i][j].init();
			}
	}
	
	public void click(int x, int y){
		System.out.println("Click at x: " + x +" y: " + y );
		calculJoueur(x, y);
					
	}
	private void calculJoueur(int x, int y){
		for (int i = 0; i < nbCasesLigne; i++)
			for (int j = 0; j < nbCasesColonne; j++)
				if (tabJeu[i][j].isClickIn(x, y)){
					System.out.println("Click dans la case " + i + " | " + j);
					if (!tabJeu[i][j].isChecked())
						tabJeu[i][j].setChecked(1);
				}
	}
	
	private void iaCalcul(){
		
	}
	public void affichage(Graphics g) {
		for(int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++){
				g.drawImage(img, 5 + i*100,5 + j*100, null);
				if (tabJeu[i][j].isChecked())
					g.drawImage(tabJeu[i][j].getImage(), 5 + i*100, 5 + j*100, null);
			}
	}
}
