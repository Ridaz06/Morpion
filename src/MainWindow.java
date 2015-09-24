import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainWindow extends JFrame implements Constantes{
	private JPanel mainPanel = null;
	
	public MainWindow(){
		System.out.println("Create window");
		this.setVisible(true);
		this.setSize(20 + nbCasesLigne * wCase, 20 + nbCasesColonne * hCase);
		this.setTitle("Morpion");
		this.setResizable(false);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLUE);
		this.setContentPane(mainPanel);
	}
}
