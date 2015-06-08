package AffichageIHMDebut;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class FenetreDefaut extends JFrame{

/**
 * buttons for confirmation of close
 */
	private JButton bouton = new JButton("Go");
	private JButton bouton2 = new JButton("Stop");
	private boolean animated = true;

	/**
	 * Les JSlider
	 */
	private JSlider sliderPeople = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JSlider sliderTimeCook = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JSlider sliderTimePrepare = new JSlider(JSlider.HORIZONTAL,0,100,0);
	/**
	 * importants buttons for the class WindowsDefault
	 * 
	 */
	private JButton buttonSearch = new JButton("Rechercher");
	private JButton buttonConnection = new JButton("Connexion");
	private JButton buttonAdmin = new JButton("Se connecter");
	private JButton buttonRCH = new JButton("Faire une Recherche");
	private JButton backToHomePageConnection = new JButton("Retour � la page d'accueil");
	private JButton backToHomePageRCH = new JButton("Retour � la page d'accueil");
	private JButton backToHomePageHelp = new JButton("Retour � la page d'accueil");
	private JButton buttonAddRecette = new JButton("Ajouter une recette");
	private JButton buttonValidate = new JButton("Valider");
	private JButton buttonGetHeure = new JButton("Obtenir les valeurs choisies");
	/**
	 * Text area for panel of search, and for panel of connection
	 */
	private Font fontForChamps = new Font("Calibri",Font.ITALIC,16);
	private JTextField textArea = new JTextField("?!?!");
	private JTextField textArea2 = new JTextField("??");
	private JTextField textAreaPeople = new JTextField("nb Personne");
	private JTextField textAreaNameRecipe = new JTextField("Titre de la recette");
	private JTextArea textAreaRecipeOfPrepare = new JTextArea("Saisissez la pr�paration");
	
	/**
	 * The drop down list for the panel of search
	 */
	private JComboBox<String> DropDownListTypeKitchen = new JComboBox<String>();
	private JComboBox<String> DropDownListTypeMeal = new JComboBox<String>();
	private JComboBox<String> DropDownListTypeMealAdd = new JComboBox<String>();
	private JComboBox<String> DropDownListTypeKitchenAdd = new JComboBox<String>();
	
	/**
	 * The radio button for panel of search
	 */
	private JRadioButton radioEasy = new JRadioButton("Facile");
	private JRadioButton radioAverage = new JRadioButton("Moyen");
	private JRadioButton radioHard = new JRadioButton("Difficile");
	
	/**
	 * All Label that we need in all panel
	 */
	private JLabel labelRendom = new JLabel("Effectuer la recherche...");
	private JLabel labelKitchen = new JLabel("Veuillez choisir un type de cuisine");
	private JLabel labelMeal = new JLabel("Veuillez choisir un type de plat");
	private JLabel labelPeople = new JLabel("Entrer le nombre de personne");
	private JLabel labelHomePageConnection = new JLabel("Page de connexion en tant qu'administrateur");
	private JLabel labelLogin = new JLabel("Entrez votre login");
	private JLabel labelPassWord = new JLabel("Entrez votre mot de passe");
	private JLabel labelKukking = new JLabel("Kukking");
	private JLabel labelFavorite = new JLabel("Coucou les favoris");
	private JLabel labelRecipeRendom = new JLabel("Coucou les recettes al�atoires");
	private JLabel labelHomePageHelp = new JLabel("Bienvenue sur la page d'aide");
	private JLabel labelAddRecipe = new JLabel("Ajouter une recette");
	private JLabel labelNewType = new JLabel("Choississez un type de cuisine");
	private JLabel labelNewTypeMeal = new JLabel("Choississez un type de plat");
	private JLabel labelNbPeople = new JLabel("Nombre de personne par d�faut");
	private JLabel labelTimeCook = new JLabel("Temps de cuisson (en minutes)");
	private JLabel labelTimeOfPrepare = new JLabel("Temps de pr�paration (en minutes)");

	/**
	 * The menu (JMenu) and the submenu(JMenuItem)
	 */
	private JMenuBar barMenu = new JMenuBar();
	private JMenu FileMenu = new JMenu("Fichier");
	private JMenu EditMenu = new JMenu("Editer");
	private JMenu HelpMenu = new JMenu("Aide");
	private JMenuItem menuConnectedForFileMenu =new JMenuItem("Se connecter en tant que administrateur");
	private JMenuItem menuCloseForFileMenu =new JMenuItem("Quitter");
	private JMenuItem submenuHelpForHelpMenu =new JMenuItem("Obtenir de l'aide");
	
	
	/**
	 * All panels
	 */
	JPanel ConnectionPage= new JPanel();
	JPanel HomePage = new JPanel();
	JPanel SearchPage = new JPanel();
	JPanel HelpPage = new JPanel();
	JPanel AddRecipe = new JPanel();
	
	/**
	 * The constructor
	 */
	public FenetreDefaut()
	{
		super();
		CardLayout cardL = new CardLayout();
		JPanel content = new JPanel();
		//content.getGraphicsConfiguration();
		setSize(1200, 700);
		setTitle("Kukking");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		/**
		 * Les JTextFields
		 */
		
		this.textArea.setFont(fontForChamps);
		this.textArea2.setFont(fontForChamps);
		this.textAreaPeople.setFont(fontForChamps);
		this.textAreaNameRecipe.setFont(fontForChamps);
		this.textAreaRecipeOfPrepare.setFont(fontForChamps);
/**
 * Le menu
 */
		barMenu.add(FileMenu);
		barMenu.add(EditMenu);
		barMenu.add(HelpMenu);
		//le sous-menu//
		FileMenu.add(menuConnectedForFileMenu);
		FileMenu.add(menuCloseForFileMenu);
		HelpMenu.add(submenuHelpForHelpMenu);
		//menu1.add(menuRetour);
		//this.menuConnecter.addActionListener(new EcouteurBoutonChanger());
		
/**
 * La page g�n�rale
 */
		JLabel icon = new JLabel(new ImageIcon("kukkinglogo.png"));
		icon.setBorder(BorderFactory.createLineBorder(Color.black));
	    JPanel panFavoris = new JPanel();
	    panFavoris.setBackground(Color.CYAN);
	    panFavoris.setPreferredSize(new Dimension(100,100));
	    panFavoris.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    //panel a la con pour s�parer les favoris et les recettes al�atoires! pas trouver mieux comme facon de faire
	    JPanel panALaCon =new JPanel();
	    panALaCon.setBackground(Color.LIGHT_GRAY); 
	    panALaCon.setPreferredSize(new Dimension(100,200));
	    //----------------------------------------------------------------
	    JPanel panRecette = new JPanel();
	    panRecette.setBackground(Color.BLUE);
	    panRecette.setPreferredSize(new Dimension(100,200));
	    panRecette.setBorder(BorderFactory.createLineBorder(Color.black));
		this.HomePage.setLayout(new BorderLayout());
		this.HomePage.add(icon);
		this.HomePage.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("Calibri",Font.BOLD,20);
		this.HomePage.add(labelKukking);
		labelKukking.setFont(font);
	    this.HomePage.add(buttonAdmin);
	    this.HomePage.add(buttonRCH);
	    this.HomePage.add(labelFavorite);
	    this.HomePage.add(panFavoris);
	    this.HomePage.add(labelRecipeRendom);
	    this.HomePage.add(panRecette);

	    Box AlignhoriPageLabelFavorisRecette = Box.createHorizontalBox();
	    AlignhoriPageLabelFavorisRecette.add(labelFavorite);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalStrut(20));
	    AlignhoriPageLabelFavorisRecette.add(panALaCon);
	    AlignhoriPageLabelFavorisRecette.add(labelRecipeRendom);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalGlue());
	    AlignhoriPageLabelFavorisRecette.add(Box.createHorizontalStrut(1));
        HomePage.add(AlignhoriPageLabelFavorisRecette);
        //setLocationRelativeTo(this.getParent());
        
        Box AlignhoriPageFavorisRecette = Box.createHorizontalBox();
	    AlignhoriPageFavorisRecette.add(panFavoris);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalStrut(2));
	    AlignhoriPageFavorisRecette.add(panALaCon);
	    AlignhoriPageFavorisRecette.add(panRecette);
	    AlignhoriPageFavorisRecette.add(Box.createHorizontalStrut(1));
        HomePage.add(AlignhoriPageFavorisRecette);
        //setLocationRelativeTo(this.getParent());
        
	    Box AlignhoriPageIconTitre = Box.createHorizontalBox();
	    AlignhoriPageIconTitre.add(icon);
	    AlignhoriPageIconTitre.add(labelKukking);
	    AlignhoriPageIconTitre.add(Box.createHorizontalGlue());
        HomePage.add(AlignhoriPageIconTitre);
        //setLocationRelativeTo(this.getParent());
	    
	    Box AlignhoriPageGenerale = Box.createHorizontalBox();
	    AlignhoriPageGenerale.add(buttonAdmin);
	    AlignhoriPageGenerale.add(buttonRCH);
	    //AlignhoriPageGenerale.add(Box.createHorizontalGlue());
        HomePage.add(AlignhoriPageGenerale);
        //setLocationRelativeTo(this.getParent());
	    
        Box AlignementPageGenerale = Box.createVerticalBox();
        AlignementPageGenerale.add(AlignhoriPageIconTitre);
        AlignementPageGenerale.add(AlignhoriPageGenerale);
		AlignementPageGenerale.add(AlignhoriPageLabelFavorisRecette);
		AlignementPageGenerale.add(AlignhoriPageFavorisRecette);
		AlignementPageGenerale.add(Box.createVerticalGlue());
        HomePage.add(AlignementPageGenerale);
        //setLocationRelativeTo(this.getParent());
/**
 * La page g�n�rale de recherche
 */
		//JPanel pageRecherche = new JPanel();
		//pageGenerale.setLayout(new BorderLayout());
        JLabel iconSearch = new JLabel(new ImageIcon("kukkinglogo.png"));
        SearchPage.add(iconSearch);
		SearchPage.setBackground(Color.LIGHT_GRAY);
		SearchPage.add(new JLabel("Veuillez choisir un niveau de cuisine"));
		SearchPage.add(radioEasy);
		SearchPage.add(radioAverage);
		SearchPage.add(radioHard);
		SearchPage.add(labelKitchen);
		SearchPage.add(DropDownListTypeKitchen);
		//liste d�roulante cuisine//
				DropDownListTypeKitchen.addItem("recettes v�g�tariennes");
				DropDownListTypeKitchen.addItem("recettes sans gluten");
				DropDownListTypeKitchen.addItem("recettes asiatiques");
				DropDownListTypeKitchen.addItem("recettes classiques");
				DropDownListTypeKitchen.addItem("recettes �tudiante");
		SearchPage.add(labelMeal);
		SearchPage.add(DropDownListTypeMeal);
		//liste d�roulante plats//
				DropDownListTypeMeal.addItem("Entr�e");
				DropDownListTypeMeal.addItem("Plat chaud");
				DropDownListTypeMeal.addItem("Dessert");
				DropDownListTypeMeal.addItem("Cocktails");
		SearchPage.add(labelPeople);
		SearchPage.add(textAreaPeople);
		SearchPage.add(labelRendom);
		SearchPage.add(buttonSearch);
		SearchPage.add(backToHomePageRCH);
		SearchPage.add(buttonAddRecette);
		//pour les aligner/organiser correctement la page de recherche
				Box AlignementPageRecherche = Box.createVerticalBox();
				AlignementPageRecherche.add(iconSearch);
				AlignementPageRecherche.add(labelKitchen);
		        AlignementPageRecherche.add(DropDownListTypeKitchen);
		        AlignementPageRecherche.add(labelMeal);
		        AlignementPageRecherche.add(DropDownListTypeMeal);
		        AlignementPageRecherche.add(labelPeople);
		        AlignementPageRecherche.add(textAreaPeople);
		        AlignementPageRecherche.add(labelRendom);
		        AlignementPageRecherche.add(buttonSearch);
		        AlignementPageRecherche.add(backToHomePageRCH);
		        AlignementPageRecherche.add(buttonAddRecette);
		        AlignementPageRecherche.add(Box.createVerticalGlue());
		        SearchPage.add(AlignementPageRecherche);
		        //setLocationRelativeTo(this.getParent());
		        
		
/**
 * La page de connexion
 */
		//JPanel pageDeConnexion= new JPanel();
		JLabel iconConnection = new JLabel(new ImageIcon("kukkinglogo.png"));
		Font fontConnexion = new Font("Calibri",Font.BOLD,20);
		labelHomePageConnection.setFont(fontConnexion);
		this.ConnectionPage.add(iconConnection);
		this.ConnectionPage.add(labelHomePageConnection);
		this.ConnectionPage.add(labelLogin);
		this.ConnectionPage.add(textArea2);
		this.ConnectionPage.add(labelPassWord);
		this.ConnectionPage.add(textArea);
		this.ConnectionPage.add(buttonConnection);
		this.ConnectionPage.add(backToHomePageConnection);
		this.ConnectionPage.setBackground(Color.CYAN);
		
		
      //pour les aligner/organiser correctement la page de connexion
        Box AlignementPageConnexion = Box.createVerticalBox();
        AlignementPageConnexion.add(iconConnection);
		AlignementPageConnexion.add(labelHomePageConnection);
		AlignementPageConnexion.add(labelLogin);
		AlignementPageConnexion.add(textArea2);
		AlignementPageConnexion.add(labelPassWord);
		AlignementPageConnexion.add(textArea);
		AlignementPageConnexion.add(buttonConnection);
		AlignementPageConnexion.add(backToHomePageConnection);
		AlignementPageConnexion.add(Box.createVerticalGlue());
        this.ConnectionPage.add(AlignementPageConnexion);
       // setLocationRelativeTo(this.getParent());
    
/**
 * La page d'aide (accessible par le menu)
 */
		Font fontAide = new Font("Calibri", Font.BOLD, 25);
		JLabel iconHelp = new JLabel(new ImageIcon("kukkinglogo.png"));
		labelHomePageHelp.setFont(fontAide);
		this.HelpPage.add(labelHomePageHelp);
		this.HelpPage.add(iconHelp);
		this.HelpPage.setBackground(Color.green);
		this.HelpPage.add(backToHomePageHelp);
		
		Box AlignementPageAide = Box.createVerticalBox();
		AlignementPageAide.add(iconHelp);
		AlignementPageAide.add(labelHomePageHelp);
		AlignementPageAide.add(backToHomePageHelp);
		AlignementPageAide.add(Box.createVerticalGlue());
		this.HelpPage.add(AlignementPageAide);
		
/**
 * La page d'ajout de recette
 */
		JLabel iconAdd = new JLabel(new ImageIcon("kukkinglogo.png"));
		Font fontLabelRecetteAdd = new Font("Calibri", Font.BOLD,20);
		labelAddRecipe.setFont(fontLabelRecetteAdd);
		this.AddRecipe.add(labelAddRecipe);
		this.AddRecipe.add(iconAdd);
		this.AddRecipe.add(buttonValidate);
		this.AddRecipe.add(textAreaNameRecipe);
		this.AddRecipe.add(textAreaRecipeOfPrepare);
		textAreaRecipeOfPrepare.setPreferredSize(new Dimension(400,100));
		//textAreaRecipeOfPrepare.setEditable(false);
		textAreaRecipeOfPrepare.setLineWrap(true);
		textAreaRecipeOfPrepare.setWrapStyleWord(true);
		this.AddRecipe.add(labelNewType);
		this.AddRecipe.add(labelNewTypeMeal);
		//new drop-down list for new type of meal
		this.AddRecipe.add(DropDownListTypeMealAdd);
				DropDownListTypeMealAdd.addItem("Une nouvelle Entr�e");
				DropDownListTypeMealAdd.addItem("Un nouveau Plat chaud");
				DropDownListTypeMealAdd.addItem("Un nouveau Dessert");
				DropDownListTypeMealAdd.addItem("Un nouveau Cocktail");
		//new drop-down list for new type of kitchen
		this.AddRecipe.add(DropDownListTypeKitchenAdd);
				DropDownListTypeKitchenAdd.addItem("Un repas v�g�tarien");
				DropDownListTypeKitchenAdd.addItem("Un repas sans gluten");
				DropDownListTypeKitchenAdd.addItem("Un repas classique");
				DropDownListTypeKitchenAdd.addItem("Un repas asiatique");
		//new JSlider for nb personnes
		this.AddRecipe.add(sliderPeople);
		sliderPeople.setPaintLabels(true);
		sliderPeople.setMajorTickSpacing(10);
		sliderPeople.setMinorTickSpacing(5);
		sliderPeople.setPaintTicks(true);
		this.AddRecipe.add(buttonGetHeure);
		//new JSlider for time of cook
		this.AddRecipe.add(sliderTimeCook);
		sliderTimeCook.setPaintLabels(true);
		sliderTimeCook.setMajorTickSpacing(10);
		sliderTimeCook.setMinorTickSpacing(5);
		sliderTimeCook.setPaintTicks(true);
		//new JSlider for time of preparation
		this.AddRecipe.add(sliderTimePrepare);
		sliderTimePrepare.setPaintLabels(true);
		sliderTimePrepare.setMajorTickSpacing(10);
		sliderTimePrepare.setMinorTickSpacing(5);
		sliderTimePrepare.setPaintTicks(true);
		this.AddRecipe.add(labelNbPeople);
		this.AddRecipe.add(labelTimeCook);
		this.AddRecipe.add(labelTimeOfPrepare);
		JLabel Heure = new JLabel("Aucune heure choisi");
		AddRecipe.add(Heure);
		
		Box AlignhoriPageAddRecipe = Box.createHorizontalBox();
	    AlignhoriPageAddRecipe.add(iconAdd);
	    AlignhoriPageAddRecipe.add(labelAddRecipe);
        AddRecipe.add(AlignhoriPageAddRecipe);
        
        /*Box AlignhoriPageAddRecipeDrop = Box.createHorizontalBox();
	    AlignhoriPageAddRecipeDrop.add(labelNewType);
	    AlignhoriPageAddRecipeDrop.add(Drop);
        AddRecipe.add(AlignhoriPageAddRecipeDrop);*/
        
        Box AlignementPageAddRecipe = Box.createVerticalBox();
        AlignementPageAddRecipe.add(AlignhoriPageAddRecipe);
        AlignementPageAddRecipe.add(textAreaNameRecipe);
        AlignementPageAddRecipe.add(labelNewType);
        AlignementPageAddRecipe.add(DropDownListTypeKitchenAdd);
        AlignementPageAddRecipe.add(labelNewTypeMeal);
        AlignementPageAddRecipe.add(DropDownListTypeMealAdd);
        AlignementPageAddRecipe.add(labelNbPeople);
        AlignementPageAddRecipe.add(sliderPeople);
        AlignementPageAddRecipe.add(labelTimeCook);
        AlignementPageAddRecipe.add(sliderTimeCook);
        AlignementPageAddRecipe.add(labelTimeOfPrepare);
        AlignementPageAddRecipe.add(sliderTimePrepare);
        AlignementPageAddRecipe.add(buttonGetHeure);
        AlignementPageAddRecipe.add(Heure);
        AlignementPageAddRecipe.add(textAreaRecipeOfPrepare);
        AlignementPageAddRecipe.add(buttonValidate);
        AddRecipe.add(AlignementPageAddRecipe);
		
/**
 * Les listeners
 */
        buttonGetHeure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempsCuisson, tempsPrepare;
				int valeurOfSliderPeople = sliderPeople.getValue();
				int valeurOfSliderTimePrepare = sliderTimePrepare.getValue();
				int valeurOfSliderTime = sliderTimeCook.getValue();
				tempsPrepare = changeHeure(valeurOfSliderTimePrepare);
				tempsCuisson = changeHeure(valeurOfSliderTime);
				Heure.setText("Nombre de personne ="+valeurOfSliderPeople+" et un temps de pr�paration = "+tempsPrepare+" et un temps de cuisson =" +tempsCuisson);
				Heure.setVisible(true);
			}
		});
		/**
		 * Pour les text area pour que leur texte s'efface quand on clique dans le champs
		 */
        
        textAreaRecipeOfPrepare.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaRecipeOfPrepare.setText("");
			}
		});
        
        textAreaNameRecipe.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaNameRecipe.setText("");
			}
		});
        
		textAreaPeople.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaPeople.setText("");
			}
		});
		
		textArea2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textArea2.setText("");
			}
		});
		textArea.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textArea.setText("");
			}
		});
		
		radioHard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectHard();
			}
		});
		
		radioAverage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectAverage();
			}
		});
		
		radioEasy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectEasy();
			}
		});
		
		buttonAddRecette.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onclic){
				GoToAddPanel();
			}
		});
		 
		
		// aller au panel d'aide quand clic sur le menu aide
		submenuHelpForHelpMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onclic){
				GoToHelpPanel();
			}
		});
		 
		//bouton retour page accueil pour le bouton de la page recherche pour acc�der au panel d'accueil
        backToHomePageHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic) {
				dispose();
				String[] args= null;
				AfficherIHM.main(args);
			}
		});
		
      //bouton retour page accueil pour le bouton de la page recherche pour acc�der au panel d'accueil
        backToHomePageRCH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic) {
				dispose();
				String[] args= null;
				AfficherIHM.main(args);
			}
		});
      //bouton retour page accueil pour acc�der au panel d'accueil
        backToHomePageConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic) {
				dispose();
				String[] args= null;
				AfficherIHM.main(args);				
			}
		});
        
      //bouton RCH (recherche) pour acc�der au panel de recherche
        buttonRCH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToSearchPanel();
			}
		});
      //bouton admin pour acc�der au panel de connection
        buttonAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToConnectionPanel();
			}
		});
        //menu connecter pour acc�der au panel de connection
		menuConnectedForFileMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToConnectionPanel();
			}
		});
		
		// le listener sur le sous-menu quitter//
				menuCloseForFileMenu.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e){
						CloseWindow();
					}
				});
		
		
	    content.setBackground(Color.white);
		content.setLayout(cardL);
		content.add(HomePage);
		content.add(SearchPage);
		content.add(ConnectionPage);
		content.add(HelpPage);
		content.add(AddRecipe);
		getContentPane().add(content, BorderLayout.CENTER);
		
		setJMenuBar(barMenu);
		
	}
	
	public void CloseWindow()
		{
		JOptionPane jop = new JOptionPane();            
		int option = jop.showConfirmDialog(null, "Etes-vous sur de vouloir quitter Kukking ?", "Quitter Kukking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.NO_OPTION)
			{
				 animated = false;  
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


/**
 * Methode pour changer le panel de la fenetre
 * Passer de la page g�n�rale � la page de connexion
 */

	  //M�thode qui change le panel de ta fen�tre
    public void GoToConnectionPanel(){
    	repaint();
    	this.setContentPane(this.ConnectionPage);
    	this.ConnectionPage.setVisible(true);
    }
    
    public void GoToSearchPanel(){
    	repaint();
    	this.setContentPane(this.SearchPage);
    	SearchPage.setVisible(true);
    }
    
    public void GoToHelpPanel(){
    	repaint();
    	this.setContentPane(this.HelpPage);
    	HelpPage.setVisible(true);
    }
    
    public void GoToAddPanel(){
    	repaint();
    	this.setContentPane(this.AddRecipe);
    	AddRecipe.setVisible(true);
    }
    
    public void RadioSelectEasy(){
    	if(radioAverage.isSelected())
    	{
    		radioAverage.setSelected(false);
    	}
    	if (radioHard.isSelected())
    	{
    		radioHard.setSelected(false);
    	}
    }
    
    public void RadioSelectAverage(){
    	if(radioEasy.isSelected())
    	{
    		radioEasy.setSelected(false);
    	}
    	if (radioHard.isSelected())
    	{
    		radioHard.setSelected(false);
    	}
    }
    public void RadioSelectHard(){
    	if(radioEasy.isSelected())
    	{
    		radioEasy.setSelected(false);
    	}
    	if (radioAverage.isSelected())
    	{
    		radioAverage.setSelected(false);
    	}
    }
    
    public String changeHeure(int entier){
    	if(entier!=0){
    	  int heure   = entier / 60 ;
    	  int minute  = entier % 60;
    	  String temps = ""+heure+"H"+""+minute+"min";
    	  return temps;
    	}
    	else 
    		return "noooon";
    }
    /*	if(radioEasy.isSelected())
    	{
    		if ((radioAverage.isSelected()) || (radioHard.isSelected())){
    		radioEasy.setSelected(false);
    		radioHard.setSelected(false);
    		}
    	}
    	if(radioHard.isSelected())
    	{
    		if ((radioEasy.isSelected()) || (radioAverage.isSelected())){
    		radioEasy.setSelected(false);
    		radioHard.setSelected(false);
    		}
    	}*/
}
 
