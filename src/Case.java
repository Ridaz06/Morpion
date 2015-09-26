import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Case implements Constantes{
	
	private int x, y; //Position de la case
	private boolean statut; //Vrai si la case est coché
	private int playerChecked; //Joueur qui a coché la case
	private Image imageJoueur = null;
	
	public Case(int x, int y){
		this.x = x;
		this.y = y;
		this.statut = unChecked;
	}
	
	//Retoune si la case est coché ou non
	public void init(){
		imageJoueur = Toolkit.getDefaultToolkit().getImage("img/player1.png"); 
	}
	
	public Image getImage(){
		return this.imageJoueur;
	}
	
	public boolean isChecked(){
		return this.statut;
	}
	
	//Coche la case et donne le joueur qui la coché
	public void setChecked(boolean c, int player){
		this.statut = c;
		this.playerChecked = player;
		
		if (player == playerOne)
			this.imageJoueur = Toolkit.getDefaultToolkit().getImage("img/player1");
		else 
			this.imageJoueur = Toolkit.getDefaultToolkit().getImage("img/player2");
	}
	
	//Liste de fonctions qui donnent et affectent les positons
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
