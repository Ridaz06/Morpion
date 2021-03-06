import java.awt.Dimension;
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
		this.setPreferredSize(new Dimension(315,337));
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
				//Si la partie n'est pas termin�
				if (jeu.isWon() == -1)
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
		
		Thread t = new Thread(new Runnable(){
			//Verifie si la partie est termin� et quitte si c'est le cas
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true){
					if (MainWindow.this.jeu.isWon() != -1){
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.exit(0);
					}
				}
			}
			
		});
		t.start();
		this.setContentPane(mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
