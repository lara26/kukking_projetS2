package kukking;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class KukkingDisplay extends JFrame {

	private static final long serialVersionUID = 1L;

	public KukkingDisplay() {
		JFrame fenetre = this;
		fenetre.setTitle("Kukking");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 600);
		
	/* creation Menu */ 
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Editier");
		JMenu menu3 = new JMenu("Aide");
		JMenuItem menuConnexion = new JMenuItem("Se connecter en tant que administrateur");
		JMenuItem menuQuitter = new JMenuItem("Quitter");

		menu1.add(menuConnexion);
		menu1.addSeparator();
		menu1.add(menuQuitter);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		fenetre.setJMenuBar(menuBar);
		
	/* affichage page accueil */
		HomePage accueil = new HomePage();
		fenetre.getContentPane().add(accueil);
		
		fenetre.setVisible(true);
		
	}

}
