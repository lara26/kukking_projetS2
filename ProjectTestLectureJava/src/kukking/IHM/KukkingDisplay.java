package kukking.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kukking.*;


public class KukkingDisplay extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	public Application application;
	JFrame window = this;
	HomePage homePage;
	SearchPage searchPage;
	ConnectionPage connectionPage;
	RecipeListPage recipeListPage;
	
	
	private JButton bouton = new JButton()/*("Go")*/;
	private JButton bouton2 = new JButton()/*("Stop")*/;
	private boolean animated = true;
	private JOptionPane jop;
	private JMenuBar menuBar;
	private JLabel messageAdmin;
	
	public KukkingDisplay(Application application) {
		this.application=application;
		homePage = new HomePage(this);
		searchPage = new SearchPage(this);
		connectionPage = new ConnectionPage(this);
		recipeListPage = new RecipeListPage(this);
		window.setTitle("Kukking");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 700);
		window.setResizable(false);
		
	/* creation Menu */ 
		menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("Fichier");
		JMenu menuEdit = new JMenu("Editier");
		JMenu menuHelp = new JMenu("Aide");
		messageAdmin = new JLabel("");
		JMenuItem menuConnexion = new JMenuItem("Se connecter en tant que administrateur");
		JMenuItem menuQuitter = new JMenuItem("Quitter");

		menuFile.add(menuConnexion);
		menuFile.addSeparator();
		menuFile.add(menuQuitter);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		menuBar.add(messageAdmin);
		
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
		if (clic.getSource() instanceof JButton)
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
				application.valider(connectionPage.getLogin(), connectionPage.getPassword());
				if (application.isAccesAdmin())
					messageAdmin.setBorder(BorderFactory.createEmptyBorder(0, 850, 0, 0));
					messageAdmin.setText("Connecté en tant qu'administrateur");
				ChangePanel(homePage);
			}
			else if (source.getText().equals("Retour à la page d'accueil"))
			{
				ChangePanel(homePage);
			}
			else if (source.getText().equals("Rechercher"))
			{
				int tempsPrepaMax = searchPage.getTempsPrepaMax();
				String typeCuisine = searchPage.getTypeCuisine();
				String typePlat = searchPage.getTypePlat();
				String cout = searchPage.getCost();
				displayListReceipts(recipeListPage.listReceipts, application.rechercheRecettes(tempsPrepaMax, typeCuisine, typePlat, cout), new Font("Century Gothic", Font.PLAIN, 18));
				ChangePanel(recipeListPage);
			}
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel)clic.getSource();
			source.setForeground(Color.BLACK);
			RecipeDisplay recipe;
			recipe = new RecipeDisplay(this.application.getReceiptsList().getRecipeWithName(source.getText()), this);
			recipe.setPreferredSize(new Dimension(600,600));
			ChangePanel(recipe);
		}
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel)clic.getSource();
			source.setForeground(Color.BLUE);
		}
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel)clic.getSource();
			source.setForeground(Color.BLACK);
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
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

	public void displayListReceipts(JPanel jpanel, ArrayList<Recipe> listToDisplay, Font font)
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		int numRow = 0;
		for (Recipe currentRecipe: listToDisplay)
		{
			constraints.gridy = numRow;
			JLabel recipe = new JLabel(""+currentRecipe.getNameRecipe());
			recipe.addMouseListener(this);
			recipe.setFont(font);
			jpanel.add(recipe,constraints);
			numRow++;
		}
	}
}
