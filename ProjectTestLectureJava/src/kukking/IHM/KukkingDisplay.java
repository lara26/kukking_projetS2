package kukking.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	HelpPage helpPage;
	
	private JMenuBar menuBar;
	private JLabel messageAdmin;
	private boolean requestDelete;
	
	public KukkingDisplay(Application application) {
		this.application=application;
		this.requestDelete=false;
		homePage = new HomePage(this);
		searchPage = new SearchPage(this);
		connectionPage = new ConnectionPage(this);
		recipeListPage = new RecipeListPage(this);
		helpPage = new HelpPage(this);
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
		menuConnexion.addActionListener(this);
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		menuQuitter.addActionListener(this);

		menuFile.add(menuConnexion);
		menuFile.addSeparator();
		menuFile.add(menuQuitter);
		
		JMenuItem needHelp = new JMenuItem("Obtenir de l'aide");
		needHelp.addActionListener(this);
		
		menuHelp.add(needHelp);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		menuBar.add(messageAdmin);
		
		window.setJMenuBar(menuBar);
	/* fin menu */
		window.getContentPane().add(homePage);
		
		window.setVisible(true);
		
	}
	 	

	public void ChangePanel(JPanel panel){
		this.setContentPane(panel);
		this.revalidate();
	}
	
	
	public void actionPerformed(ActionEvent clic)
	{
		if (clic.getSource() instanceof JMenuItem)
		{
			JMenuItem source = (JMenuItem)clic.getSource();
			if (source.getText().equals("Se connecter en tant que administrateur"))
			{
				ChangePanel(connectionPage);
			}
			else if (source.getText().equals("Quitter"))
			{
				CloseWindow();
			}
			else if (source.getText().equals("Obtenir de l'aide"))
			{
				ChangePanel(helpPage);
			}
		}
		if (clic.getSource() instanceof JButton)
		{
			JButton source = (JButton)clic.getSource();
			if (source.getText().equals("Connexion en tant qu'administrateur"))
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
				{
					messageAdmin.setBorder(BorderFactory.createEmptyBorder(0, 850, 0, 0));
					messageAdmin.setText("Connecté en tant qu'administrateur");
				}
				ChangePanel(homePage);
			}
			else if (source.getText().equals("Retour à la page d'accueil"))
			{
				this.displayListReceipts(homePage.recettes, homePage.newListRandom(this), new Font("Century Gothic", Font.PLAIN, 18), false);
				ChangePanel(homePage);
			}
			else if (source.getText().equals("Rechercher"))
			{
				int tempsPrepaMax = searchPage.getTempsPrepaMax();
				String typeCuisine = searchPage.getTypeCuisine();
				String typePlat = searchPage.getTypePlat();
				String cout = searchPage.getCost();
				displayListReceipts(recipeListPage.listReceipts, application.rechercheRecettes(tempsPrepaMax, typeCuisine, typePlat, cout), new Font("Century Gothic", Font.PLAIN, 18),requestDelete);
				requestDelete = false;
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
			if (source.getText().substring(source.getText().length()-10, source.getText().length()-1).equals(" (delete)"))
			{
				String nameRecipe = source.getText().substring(source.getText().length()-10);
				int option = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimer la recette :\n"+nameRecipe, "Supprimer recette", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.YES_OPTION)
					this.application.getReceiptsList().permanentlyDeleteRecipe(this.application.getReceiptsList().getRecipeWithName(nameRecipe));
			}
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
		int option = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir quitter Kukking ?", "Quitter Kukking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public void displayListReceipts(JPanel jpanel, ArrayList<Recipe> listToDisplay, Font font, boolean administrator)
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		int numRow = 0;
		jpanel.removeAll();
		/*JPanel listReceiptsToReplace = new JPanel();
		listReceiptsToReplace.setLayout(new GridBagLayout());*/
		if (listToDisplay.size()==0)
		{
			JLabel recipe = new JLabel("Aucune recette");
			recipe.addMouseListener(this);
			recipe.setFont(font);
			jpanel.add(recipe,constraints);
		}
		for (Recipe currentRecipe: listToDisplay)
		{
			constraints.gridx = 0;
			constraints.gridy = numRow;
			JLabel recipe = new JLabel(""+currentRecipe.getNameRecipe());
			if (administrator) recipe.setText(recipe.getText()+" (delete)");
			recipe.addMouseListener(this);
			recipe.setFont(font);
			jpanel.add(recipe,constraints);
			numRow++;
		}
	}
}
