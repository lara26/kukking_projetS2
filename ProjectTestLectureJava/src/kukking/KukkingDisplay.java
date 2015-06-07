package kukking;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class KukkingDisplay extends JFrame {

	private static final long serialVersionUID = 1L;

	public KukkingDisplay() {
		JFrame window = this;
		window.setTitle("Kukking");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 700);
		
	/* creation Menu */ 
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("Fichier");
		JMenu menuEdit = new JMenu("Editier");
		JMenu menuHelp = new JMenu("Aide");
		JMenuItem menuConnexion = new JMenuItem("Se connecter en tant que administrateur");
		JMenuItem menuQuitter = new JMenuItem("Quitter");

		menuFile.add(menuConnexion);
		menuFile.addSeparator();
		menuFile.add(menuQuitter);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		
		window.setJMenuBar(menuBar);
		
	/* affichage page accueil */
		HomePage homePage = new HomePage();
		window.getContentPane().add(homePage);
		
	/* affichage page recherche */
// ATTENTION ceci est en commentaire mais ca marche 
// c'est juste que la reste de la division n'est pas fini, il faut donc choisir la page a afficher manuellement !!!!!
		//SearchPage searchPage = new SearchPage();
		//window.getContentPane().add(searchPage);
		
		
		
		
		window.setVisible(true);
		
	}

}
