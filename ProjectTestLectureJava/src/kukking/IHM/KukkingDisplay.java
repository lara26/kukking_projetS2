package kukking.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
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


public class KukkingDisplay extends JFrame implements ActionListener,
		MouseListener
{
	private static final long serialVersionUID = 1L;

	public Application application;

	JFrame window = this;
	HomePage homePage;
	SearchPage searchPage;
	ConnectionPage connectionPage;
	RecipeListPage recipeListPage;
	HelpPage helpPage;
	AddDeleteRecipePage addDeleteRecipePage;
	FormAddRecipePage formAddRecipePage;
	
	private JMenuBar menuBar;
	private JLabel messageAdmin;
	private boolean requestDelete;
	public final static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private JMenu menuEdit;

	public KukkingDisplay(Application application)
	{
		this.application = application;
		this.requestDelete = false;
		homePage = new HomePage(this);
		searchPage = new SearchPage(this);
		connectionPage = new ConnectionPage(this);
		recipeListPage = new RecipeListPage(this);
		helpPage = new HelpPage(this);
		addDeleteRecipePage = new AddDeleteRecipePage(this);
		formAddRecipePage = new FormAddRecipePage(this);
		
		window.setTitle("Kukking");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize((int)dimension.getWidth(), (int)dimension.getHeight());
		window.setResizable(false);
		
		/* creation Menu */
		menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("Fichier");
		JMenu menuAccueil = new JMenu("Accueil");
		JMenu menuHelp = new JMenu("Aide");
		menuEdit = new JMenu("Editer");
		messageAdmin = new JLabel("");
		
		JMenuItem menuConnexion = new JMenuItem("Se connecter en tant que administrateur");
		menuConnexion.addActionListener(this);
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		menuQuitter.addActionListener(this);
		menuFile.add(menuConnexion);
		menuFile.addSeparator();
		menuFile.add(menuQuitter);
		
		JMenuItem backToHome = new JMenuItem("Retourner � l'accueil");
		backToHome.addActionListener(this);
		menuAccueil.add(backToHome);
		
		JMenuItem needHelp = new JMenuItem("Obtenir de l'aide");
		needHelp.addActionListener(this);
		menuHelp.add(needHelp);
		
		JMenuItem addDeleteRecipe = new JMenuItem("Saisie et suppression recette");
		addDeleteRecipe.addActionListener(this);
		menuEdit.add(addDeleteRecipe);
		
		
		
		
		menuBar.add(menuFile);
		menuBar.add(menuAccueil);
		menuBar.add(menuHelp);
		menuBar.add(menuEdit);
		menuBar.add(messageAdmin);
		window.setJMenuBar(menuBar);
		
		/* fin menu */
		window.getContentPane().add(homePage);
		window.setVisible(true);
		menuEdit.setVisible(false);
	}

	public void ChangePanel(JPanel panel)
	{
		this.setContentPane(panel);
		this.revalidate();
	}

	public void actionPerformed(ActionEvent clic)
	{
		if (clic.getSource() instanceof JMenuItem)
		{
			JMenuItem source = (JMenuItem) clic.getSource();
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
			else if(source.getText().equals("Saisie et suppression recette"))
			{
				ChangePanel(addDeleteRecipePage);
			}
			else if(source.getText().equals("Retourner � l'accueil"))
			{
				ChangePanel(homePage);
			}
		}
		
		
		
		
		if (clic.getSource() instanceof JButton)
		{
			JButton source = (JButton) clic.getSource();
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
				application.valider(connectionPage.getLogin(),
						connectionPage.getPassword());
				if (application.isAccesAdmin())
				{
					messageAdmin.setBorder(BorderFactory.createEmptyBorder(0,(int)dimension.getWidth()-350, 0, 0));
					messageAdmin.setText("Connect� en tant qu'administrateur");
					menuEdit.setVisible(true);
				}
				ChangePanel(homePage);
			}
			
			else if (source.getText().equals("Retour � la page d'accueil"))
			{
				this.displayListReceipts(homePage.recettes, homePage
						.newListRandom(this), new Font("Century Gothic",
						Font.PLAIN, 18), false);
				ChangePanel(homePage);
			}
			
			else if (source.getText().equals("Rechercher"))
			{
				int tempsPrepaMax = searchPage.getTempsPrepaMax();
				String typeCuisine = searchPage.getTypeCuisine();
				String typePlat = searchPage.getTypePlat();
				String cout = searchPage.getCost();
				displayListReceipts(recipeListPage.listReceipts,application.rechercheRecettes(tempsPrepaMax,typeCuisine, typePlat, cout), new Font("Century Gothic", Font.PLAIN, 18),requestDelete);
				requestDelete = false;
				ChangePanel(recipeListPage);
			}
			
			else if (source.getText().equals("Ajouter une recette"))
			{
				ChangePanel(formAddRecipePage);
			}
			else if (source.getText().equals("Supprimer une recette"))
			{
				requestDelete = true;
				ChangePanel(searchPage);
			}
			else if (source.getText().equals("Valider"))
			{
				ArrayList<String> categories = new ArrayList<String>();
				ArrayList<String> ingredients = new ArrayList<String>();
				ArrayList<String> quantities = new ArrayList<String>();
				ArrayList<String> units = new ArrayList<String>();
				ArrayList<String> preparation = new ArrayList<String>();
				categories.add(this.formAddRecipePage.getDropDownListTypeKitchenAdd());
				categories.add(this.formAddRecipePage.getDropDownListTypeMealAdd());
				preparation.add(this.formAddRecipePage.getTextAreaRecipeOfPrepare());
				int numChar  = 0;
				while (numChar<this.formAddRecipePage.getTextAreaIngredients().length())
				{
					String currentString = extractStringWithSeparatorFromList(numChar,this.formAddRecipePage.getTextAreaIngredients(), ';');
					numChar+=currentString.length()+1;
					ingredients.add(currentString);
				}
				numChar  = 0;
				while (numChar<this.formAddRecipePage.getTextAreaQuantities().length())
				{
					String currentString = extractStringWithSeparatorFromList(numChar,this.formAddRecipePage.getTextAreaQuantities(), ';');
					numChar+=currentString.length()+1;
					ingredients.add(currentString);
				}
				numChar  = 0;
				while (numChar<this.formAddRecipePage.getTextAreaUnits().length())
				{
					String currentString = extractStringWithSeparatorFromList(numChar,this.formAddRecipePage.getTextAreaUnits(), ';');
					numChar+=currentString.length()+1;
					ingredients.add(currentString);
				}
				try {
					application.getReceiptsList().addRecipe(new Recipe(this.formAddRecipePage.getTextAreaNameRecipe(), this.formAddRecipePage.getSliderPeople(), this.formAddRecipePage.getSliderTimePrepare(), this.formAddRecipePage.getSliderTimeCook(), this.formAddRecipePage.getCost(), categories, ingredients, quantities, units, preparation));
				} catch (IOException e) {
					e.printStackTrace();
				}
				ChangePanel(homePage);
			}
		}
	}

	private String extractStringWithSeparatorFromList(int numChar,String whereExtract, char separator) {
		String currentIngredient = "";
		while (numChar<whereExtract.length() && whereExtract.charAt(numChar)!=separator)
		{
			currentIngredient+=whereExtract.charAt(numChar);
			numChar++;
		}
		return currentIngredient;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel) clic.getSource();
			source.setForeground(Color.BLACK);
			if (source.getText().substring(source.getText().length() - 9,source.getText().length()).equals(" (delete)"))
			{
				String nameRecipe = source.getText().substring(0,source.getText().length() - 9);
				int option = JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir supprimer la recette :\n"+ nameRecipe, "Supprimer recette",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.YES_OPTION)
					this.application.getReceiptsList().permanentlyDeleteRecipe(this.application.getReceiptsList().getRecipeWithName(nameRecipe));
			}
			else
			{
				RecipeDisplay recipe;
				recipe = new RecipeDisplay(this.application.getReceiptsList().getRecipeWithName(source.getText()), this);
				recipe.setPreferredSize(new Dimension(900, 700));
				ChangePanel(recipe);
			}
		}
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel) clic.getSource();
			source.setForeground(Color.BLUE);
		}
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent clic)
	{
		if (clic.getSource() instanceof JLabel)
		{
			JLabel source = (JLabel) clic.getSource();
			source.setForeground(Color.BLACK);
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0)
	{
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0)
	{
	}

	public void CloseWindow()
	{
		int option = JOptionPane.showConfirmDialog(null,
				"Etes-vous sur de vouloir quitter Kukking ?",
				"Quitter Kukking", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public void displayListReceipts(JPanel jpanel,
			ArrayList<Recipe> listToDisplay, Font font, boolean administrator)
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		int numRow = 0;
		jpanel.removeAll();
		/*
		 * JPanel listReceiptsToReplace = new JPanel();
		 * listReceiptsToReplace.setLayout(new GridBagLayout());
		 */
		if (listToDisplay.size() == 0)
		{
			JLabel recipe = new JLabel("Aucune recette");
			recipe.addMouseListener(this);
			recipe.setFont(font);
			jpanel.add(recipe, constraints);
		}
		for (Recipe currentRecipe : listToDisplay)
		{
			constraints.gridx = 0;
			constraints.gridy = numRow;
			JLabel recipe = new JLabel("" + currentRecipe.getNameRecipe());
			if (administrator)
				recipe.setText(recipe.getText() + " (delete)");
			recipe.addMouseListener(this);
			recipe.setFont(font);
			jpanel.add(recipe, constraints);
			numRow++;
		}
	}
}
