package kukking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class KukkingDisplay extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame window = this;
	HomePage homePage;
	SearchPage searchPage;
	ConnectionPage connectionPage;
	
	public KukkingDisplay() {
		
		homePage = new HomePage(this);
		searchPage = new SearchPage(this);
		connectionPage = new ConnectionPage(this);
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
	 	

	public void ChangePanel(JPanel panel){
		this.setContentPane(panel);
		this.revalidate();
	}
	
	public void actionPerformed(ActionEvent clic){
		JButton source = (JButton)clic.getSource();
		if (source.getText().equals("Connexion")){
			ChangePanel(connectionPage);
		}
		else if (source.getText().equals("Lancer une recherche")){
			ChangePanel(searchPage);
		}
		else if (source.getText().equals("Se connecter")){
			ChangePanel(homePage);
		}
		else if (source.getText().equals("Retour à la page d'accueil")){
			ChangePanel(homePage);
		}
		else if (source.getText().equals("Rechercher")){
			ChangePanel(homePage);
		}
			
	}
}
