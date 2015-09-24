import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainWindow extends JFrame implements Constantes{
	private JPanel mainPanel = null;
	private Jeu jeu = null;
	public MainWindow(){
		System.out.println("Create window");
		this.setVisible(true);
		this.setSize(20 + nbCasesLigne * wCase, 40 + nbCasesColonne * hCase);
		this.setTitle("Morpion");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jeu = new Jeu();
		mainPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				MainWindow.this.jeu.affichage(g);
			}
		};
		mainPanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jeu.click(arg0.getX(), arg0.getY());
				MainWindow.this.mainPanel.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setContentPane(mainPanel);
	}
}
