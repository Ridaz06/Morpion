import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

public class Jeu implements Constantes{
	private Case[][] tabJeu = new Case [nbCasesLigne][nbCasesColonne];
	private Image img = null;
	private Toolkit toolkit = null;
	private int round;
	private int counterRound = 0;
	private Ia ia = new IaHard();
	public Jeu(){
		round = playerOne;
		toolkit = Toolkit.getDefaultToolkit();
		img = new ImageIcon("img/case.png").getImage();
		for (int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++)
				tabJeu[i][j] = new Case(5 + i*100, 5 + j*100); 
		iaCalcul();
	}
	
	//Se déclanche lors d'un clique de souri
	public void click(int x, int y){
		System.out.println("Click at x: " + x +" y: " + y );
		calculJoueur(x, y);
					
	}
	
	//Tour de l'ia
	private void iaCalcul(){
		ia.play(counterRound, tabJeu);
	}
	
	//Coche une case si c'est possible
	private void calculJoueur(int x, int y){
		for (int i = 0; i < nbCasesLigne; i++)
			for (int j = 0; j < nbCasesColonne; j++)
				if (tabJeu[i][j].isClickIn(x, y)){
					System.out.println("Click in the case " + i + " | " + j);
					if (!tabJeu[i][j].isChecked()){
						System.out.println("Case " + i + " | " + j + " checked by player " + (round+1));
						tabJeu[i][j].setChecked(0);
						/*Si round vaut 0 alors il prend la valeur 1
						 * sinon il prend la valeur 0
						 */
						counterRound++;
						round = (round == playerOne) ? playerTwo : playerOne; 
						ia.play(counterRound, tabJeu);
					}
				}		
	}
	
	//Verifie si la partie est terminé
	public int isWon(){
		//Retourne 0 ou 1 si la partie est gagné par le joueur 1 ou 2
		//Ligne 1
		if (tabJeu[0][0].egals(tabJeu[1][0]) && tabJeu[0][0].egals(tabJeu[2][0]))
			return tabJeu[0][0].getPlayers();
		//Ligne 2
		if (tabJeu[0][1].egals(tabJeu[1][1]) && tabJeu[0][1].egals(tabJeu[2][1]))
			return tabJeu[0][1].getPlayers();
		//Ligne 3
		if (tabJeu[0][2].egals(tabJeu[1][2]) && tabJeu[0][2].egals(tabJeu[2][2]))
			return tabJeu[0][2].getPlayers();
		//Colonne 1
		if (tabJeu[0][0].egals(tabJeu[0][1]) && tabJeu[0][0].egals(tabJeu[0][2]))
			return tabJeu[0][0].getPlayers();
		//Colonne 2
		if (tabJeu[1][0].egals(tabJeu[1][1]) && tabJeu[1][0].egals(tabJeu[1][2]))
			return tabJeu[1][0].getPlayers();
		//Colonne 3
		if (tabJeu[2][0].egals(tabJeu[2][1]) && tabJeu[2][0].egals(tabJeu[2][2]))
			return tabJeu[2][0].getPlayers();
		//Diagonale 1
		if (tabJeu[0][0].egals(tabJeu[1][1]) && tabJeu[0][0].egals(tabJeu[2][2]))
			return tabJeu[0][0].getPlayers();
		//Diagonale 2
		if (tabJeu[0][2].egals(tabJeu[1][1]) && tabJeu[0][2].egals(tabJeu[2][0]))
			return tabJeu[0][2].getPlayers();
	return -1; //Retourne -1 si la partie continue
	}

	public void affichage(Graphics g) {
		for(int i = 0; i < nbCasesLigne; i++)
			for(int j = 0; j < nbCasesColonne; j++){
				g.drawImage(img, 5 + i*100,5 + j*100, null);
				if (tabJeu[i][j].isChecked())
					g.drawImage(tabJeu[i][j].getImage(), 5 + i*100, 5 + j*100, null);
			}
		if (this.isWon() != -1){
			String text = "Joueur " + (this.isWon() + 1) + " gagne ";
			
			AffineTransform affinetransform = new AffineTransform(); 
			//Calcul de la longueur et de la hauteur du string
			FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
			Font font = new Font("Tahoma", Font.PLAIN, 30);
			int textwidth = (int)(font.getStringBounds(text, frc).getWidth());
			int textheight = (int)(font.getStringBounds(text, frc).getHeight());
			g.setColor(Color.red);
			g.setFont(font);
			
			g.drawString(text, 315 / 2 - textwidth / 2, 337 / 2 - textheight / 2);
		}
	}
}
