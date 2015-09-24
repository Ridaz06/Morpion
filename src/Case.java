import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Case implements Constantes{
	
	private int x, y; //Position de la case
	private boolean statut; //Vrai si la case est coché
	private int playerChecked; //Joueur qui a coché la case
	private Image img = null;
	private Image imgPlayer1 = null;
	private Image imgPlayer2 = null;
	
	public Case(int x, int y){
		this.x = x;
		this.y = y;
		this.statut = unChecked;
		try {
			imgPlayer1 = ImageIO.read(new File("img/player1.png"));
			imgPlayer2 = ImageIO.read(new File("img/player2.png"));
			img = imgPlayer1;
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
	
	//Retoune si la case est coché ou non
	public boolean isChecked(){
		return this.statut;
	}
	
	//Coche la case et donne le joueur qui la coché
	public void setChecked(boolean c, int player){
		this.statut = c;
		this.playerChecked = player;
		
		if (player == playerOne)
			this.img = this.imgPlayer1;
		else 
			this.img = this.imgPlayer2;
	}
	
	//Retourne l'image Croix ou rond en fonction du joueur
	public Image getImage(){
		return this.img;
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
