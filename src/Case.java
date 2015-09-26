import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Case implements Constantes{
	
	private int minX,maxX,minY,maxY; //Position de la case
	private boolean statut; //Vrai si la case est coché
	private int playerChecked; //Joueur qui a coché la case
	private Image imageJoueur = null;
	
	public Case(int minX, int minY){
		this.minX = minX;
		this.minY = minY;
		this.maxX = minX + 100;
		this.maxY = minY + 100;
		this.statut = unChecked;
	}
	
	//Retoune si la case est coché ou non
	public void init(){
		imageJoueur = new ImageIcon("img/player1.png").getImage(); 
	}
	
	public Image getImage(){
		System.out.println("Retourne image");
		return this.imageJoueur;
	}
	
	//Retourne si la case est coché
	public boolean isChecked(){
		return this.statut;
	}
	
	//Retourne si le click est dans la case
	public boolean isClickIn(int x, int y){
		return ((x >= minX) && (x <= maxX)) && ((y >= minY) && (y <= maxY));
	}
	//Coche la case et donne le joueur qui la coché
	public void setChecked(int player){
		this.statut = true;
		this.playerChecked = player;
		
		if (player == playerOne)
			this.imageJoueur = new ImageIcon("img/player1.png").getImage();
		else 
			this.imageJoueur = new ImageIcon("img/player2.png").getImage();
	}
	
	//Liste de fonctions qui donnent et affectent les positons
	public int getX(){
		return this.minX;
	}
	
	public int getY(){
		return this.minY;
	}
	
	public void setX(int x){
		this.minX = x;
		this.maxX = x +100;
	}
	
	public void setY(int y){
		this.minY = y;
		this.maxY = y + 100;
	}
}
