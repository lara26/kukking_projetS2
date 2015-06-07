package kukking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class KukkingDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	JFrame window = this;
	HomePage homePage = new HomePage(window);
	
	public KukkingDisplay() {
		
		SearchPage searchPage = new SearchPage(window);
		ConnectionPage connectionPage = new ConnectionPage(window);
		window.setTitle("Kukking");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 700);
		window.setResizable(false);
		
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
	/* fin menu */
		window.getContentPane().add(homePage);
		
		window.setVisible(true);
		
	}
	 	

}
