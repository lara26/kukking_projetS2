package kukking.IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import kukking.*;


public class KukkingDisplay extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public Application application;
	JFrame window = this;
	HomePage homePage;
	SearchPage searchPage;
	ConnectionPage connectionPage;
	
	private JButton bouton = new JButton()/*("Go")*/;
	private JButton bouton2 = new JButton()/*("Stop")*/;
	private boolean animated = true;
	private JOptionPane jop;
	
	public KukkingDisplay(Application application) {
		this.application=application;
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
		
		
		
		
		// le listener sur le sous-menu quitter//
		menuQuitter.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CloseWindow();
			}
			
		});
		
	}
	 	

	public void ChangePanel(JPanel panel){
		this.setContentPane(panel);
		this.revalidate();
	}
	
	
	public void actionPerformed(ActionEvent clic)
	{
		JButton source = (JButton)clic.getSource();
		if (source.getText().equals("Connexion"))
		{
			ChangePanel(connectionPage);
		}
		else if (source.getText().equals("Lancer une recherche"))
		{
			ChangePanel(searchPage);
		}
		else if (source.getText().equals("Se connecter"))
		{
			ChangePanel(homePage);
		}
		else if (source.getText().equals("Retour à la page d'accueil"))
		{
			ChangePanel(homePage);
		}
		else if (source.getText().equals("Rechercher"))
		{
			RecipeDisplay recipe;
			recipe = new RecipeDisplay(new Recipe("Galette des rois"), this);
			recipe.setPreferredSize(new Dimension(600,600));
			ChangePanel(recipe);
			//SwingUtilities.invokeLater(new displayfenetretest());
		}
			
	}
	
	
	
	
	public void CloseWindow()
	{
	jop = new JOptionPane();            
	int option = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir quitter Kukking ?", "Quitter Kukking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.NO_OPTION)
		{
			 animated  = false;  
		     bouton.setEnabled(true);
		     bouton2.setEnabled(false);
		}
		if (option == JOptionPane.YES_OPTION)
		{
			bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			});
			System.exit(0);
		}

}


	public void updateFavoris() {
		for (Recipe currentRecipe: this.application.getListe_Favoris().list)
		{
			JLabel recipe = new JLabel(currentRecipe.getNameRecipe());
			homePage.favoris.add(recipe);
		}
		
	}
}
