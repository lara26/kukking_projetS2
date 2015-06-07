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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class FenetreDefaut extends JFrame{

	private JButton bouton = new JButton("Go");
	  private JButton bouton2 = new JButton("Stop");
	  private boolean animated = true;
	//les boutons//
	private JButton boutonRecherche = new JButton("Rechercher");
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonAdmin = new JButton("Se connecter");
	private JButton boutonRCH = new JButton("Faire une Recherche");
	private JButton retourPageAccueil = new JButton("Retour � la page d'accueil");
	private JButton retourPageAccueilRCH = new JButton("Retour � la page d'accueil");
	//private JPanel clicable = new JPanel();
	//une zone de texte//
	private JTextField zoneTexte = new JTextField("?!?!");
	private JTextField zoneTexte2 = new JTextField("??");
	private JTextField zoneTexteP = new JTextField("nb Personne");
	//les liste d�roulantes
	private JComboBox<String> menuDeroulantCuisineType = new JComboBox<String>();
	private JComboBox<String> menuDeroulantPlatType = new JComboBox<String>();
	/* les boutons radio*/
	private JRadioButton radio1 = new JRadioButton("Facile");
	private JRadioButton radio2 = new JRadioButton("Moyen");
	private JRadioButton radio3 = new JRadioButton("Difficile");
	//les labels//
	private JLabel labelRendom = new JLabel("Effectuer la recherche...");
	private JLabel labelCuisine = new JLabel("Veuillez choisir un type de cuisine");
	private JLabel labelPlat = new JLabel("Veuillez choisir un type de plat");
	private JLabel labelPersonne = new JLabel("Entrer le nombre de personne");
	private JLabel labelAccueilConnexion = new JLabel("Page de connexion en tant qu'administrateur");
	private JLabel labelLogin = new JLabel("Entrez votre login");
	private JLabel labelPassWord = new JLabel("Entrez votre mot de passe");
	private JLabel labelKukking = new JLabel("Kukking");
	private JLabel labelFavoris = new JLabel("Coucou les favoris");
	private JLabel labelRecetteRendom = new JLabel("Coucou les recettes al�atoires");
	// le menu et sous menu
	private JMenuBar barMenu = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Editier");
	private JMenu menu3 = new JMenu("Aide");
	private JMenuItem menuConnecter =new JMenuItem("Se connecter en tant que administrateur");
	private JMenuItem menuQuitter =new JMenuItem("Quitter");
	//private JMenuItem menuRetour = new JMenuItem("Retour � la page pr�c�dente");
	
	
	JPanel pageDeConnexion= new JPanel();
	JPanel pageGenerale = new JPanel();
	JPanel pageRecherche = new JPanel();
	//le constructeur
	public FenetreDefaut()
	{
		super();
		CardLayout cardL = new CardLayout();
		JPanel content = new JPanel();
		//CardLayout cardLCo = new CardLayout();
		//JPanel contentConnexion = new JPanel();
		setSize(500, 500);
		setTitle("Kukking");
		setResizable(false);
		setDefaultCloseOperation(/*JFrame.addActionListener (new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent clic)
			{
				CloseWindow();
			}
		}));*/JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
/**
 * Le menu
 */
		barMenu.add(menu1);
		barMenu.add(menu2);
		barMenu.add(menu3);
		//le sous-menu//
		menu1.add(menuConnecter);
		menu1.add(menuQuitter);
		//menu1.add(menuRetour);
		//this.menuConnecter.addActionListener(new EcouteurBoutonChanger());
		
/**
 * La page g�n�rale
 */
		JLabel icon = new JLabel(new ImageIcon("images.gif"));
		icon.setBorder(BorderFactory.createLineBorder(Color.black));
	    JPanel panFavoris = new JPanel();
	    panFavoris.setBackground(Color.CYAN);
	    panFavoris.setPreferredSize(new Dimension(100,100));
	    panFavoris.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    //panel a la con pour s�parer les favoris et les recettes al�atoires! pas trouver mieux comme faocn de faire
	    JPanel panALaCon =new JPanel();
	    panALaCon.setBackground(Color.LIGHT_GRAY); 
	    panALaCon.setPreferredSize(new Dimension(100,200));
	    //----------------------------------------------------------------
	    //BorderLayout bord = new BorderLayout(100,100);
	    //panFavoris.setLayout(bord);
	    JPanel panRecette = new JPanel();
	    panRecette.setBackground(Color.BLUE);
	    panRecette.setPreferredSize(new Dimension(100,200));
	    panRecette.setBorder(BorderFactory.createLineBorder(Color.black));
	    //BorderLayout bordRecette = new BorderLayout(0,0);
	    //panRecette.setLayout(bordRecette);
//		JPanel pageGenerale = new JPanel();
		this.pageGenerale.setLayout(new BorderLayout());
		this.pageGenerale.add(icon);
		this.pageGenerale.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("Calibri",Font.BOLD,20);
		this.pageGenerale.add(labelKukking);
		labelKukking.setFont(font);
	    this.pageGenerale.add(boutonAdmin);
	    this.pageGenerale.add(boutonRCH);
	    this.pageGenerale.add(labelFavoris);
	    this.pageGenerale.add(panFavoris);
	    this.pageGenerale.add(labelRecetteRendom);
	    this.pageGenerale.add(panRecette);

	    Box AlignhoriPageLabelFavorisRecette = Box.createHorizontalBox();
	    AlignhoriPageLabelFavorisRecette.add(labelFavoris);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalStrut(20));
	    AlignhoriPageLabelFavorisRecette.add(panALaCon);
	    AlignhoriPageLabelFavorisRecette.add(labelRecetteRendom);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalGlue());
	    AlignhoriPageLabelFavorisRecette.add(Box.createHorizontalStrut(1));
        pageGenerale.add(AlignhoriPageLabelFavorisRecette);
        //setLocationRelativeTo(this.getParent());
        
        Box AlignhoriPageFavorisRecette = Box.createHorizontalBox();
	    AlignhoriPageFavorisRecette.add(panFavoris);
	    AlignhoriPageLabelFavorisRecette.add(Box.createVerticalStrut(2));
	    AlignhoriPageFavorisRecette.add(panALaCon);
	    AlignhoriPageFavorisRecette.add(panRecette);
	    AlignhoriPageFavorisRecette.add(Box.createHorizontalStrut(1));
        pageGenerale.add(AlignhoriPageFavorisRecette);
        //setLocationRelativeTo(this.getParent());
        
	    Box AlignhoriPageIconTitre = Box.createHorizontalBox();
	    AlignhoriPageIconTitre.add(icon);
	    AlignhoriPageIconTitre.add(labelKukking);
	    AlignhoriPageIconTitre.add(Box.createHorizontalGlue());
        pageGenerale.add(AlignhoriPageIconTitre);
        //setLocationRelativeTo(this.getParent());
	    
	    Box AlignhoriPageGenerale = Box.createHorizontalBox();
	    AlignhoriPageGenerale.add(boutonAdmin);
	    AlignhoriPageGenerale.add(boutonRCH);
	    //AlignhoriPageGenerale.add(Box.createHorizontalGlue());
        pageGenerale.add(AlignhoriPageGenerale);
        //setLocationRelativeTo(this.getParent());
	    
        Box AlignementPageGenerale = Box.createVerticalBox();
        AlignementPageGenerale.add(AlignhoriPageIconTitre);
        AlignementPageGenerale.add(AlignhoriPageGenerale);
		AlignementPageGenerale.add(AlignhoriPageLabelFavorisRecette);
		AlignementPageGenerale.add(AlignhoriPageFavorisRecette);
		AlignementPageGenerale.add(Box.createVerticalGlue());
        pageGenerale.add(AlignementPageGenerale);
        //setLocationRelativeTo(this.getParent());
/**
 * La page g�n�rale de recherche
 */
		//JPanel pageRecherche = new JPanel();
		//pageGenerale.setLayout(new BorderLayout());
		pageRecherche.setBackground(Color.LIGHT_GRAY);
		pageRecherche.add(new JLabel("Veuillez ch"
				+ "oisir un niveau de cuisine"));
		pageRecherche.add(radio1);
		pageRecherche.add(radio2);
		pageRecherche.add(radio3);
		pageRecherche.add(labelCuisine);
		pageRecherche.add(menuDeroulantCuisineType);
		//liste d�roulante cuisine//
				menuDeroulantCuisineType.addItem("recettes v�g�tariennes");
				menuDeroulantCuisineType.addItem("recettes sans gluten");
				menuDeroulantCuisineType.addItem("recettes asiatiques");
				menuDeroulantCuisineType.addItem("recettes classiques");
				menuDeroulantCuisineType.addItem("recettes �tudiante");
		pageRecherche.add(labelPlat);
		pageRecherche.add(menuDeroulantPlatType);
		//liste d�roulante plats//
				menuDeroulantPlatType.addItem("Entr�e");
				menuDeroulantPlatType.addItem("Plat chaud");
				menuDeroulantPlatType.addItem("Dessert");
				menuDeroulantPlatType.addItem("Cocktails");
		pageRecherche.add(labelPersonne);
		pageRecherche.add(zoneTexteP);
		pageRecherche.add(labelRendom);
		pageRecherche.add(boutonRecherche);
		pageRecherche.add(retourPageAccueilRCH);
		//pour les aligner/organiser correctement la page de recherche
				Box AlignementPageRecherche = Box.createVerticalBox();
				AlignementPageRecherche.add(labelCuisine);
		        AlignementPageRecherche.add(menuDeroulantCuisineType);
		        AlignementPageRecherche.add(labelPlat);
		        AlignementPageRecherche.add(menuDeroulantPlatType);
		        AlignementPageRecherche.add(labelPersonne);
		        AlignementPageRecherche.add(zoneTexteP);
		        AlignementPageRecherche.add(labelRendom);
		        AlignementPageRecherche.add(boutonRecherche);
		        AlignementPageRecherche.add(retourPageAccueilRCH);
		        AlignementPageRecherche.add(Box.createVerticalGlue());
		        pageRecherche.add(AlignementPageRecherche);
		        //setLocationRelativeTo(this.getParent());
		        
		
/**
 * La page de connexion
 */
		//JPanel pageDeConnexion= new JPanel();
		Font fontConnexion = new Font("Calibri",Font.BOLD,20);
		labelAccueilConnexion.setFont(fontConnexion);
		this.pageDeConnexion.add(labelAccueilConnexion);
		this.pageDeConnexion.add(labelLogin);
		this.pageDeConnexion.add(zoneTexte2);
		this.pageDeConnexion.add(labelPassWord);
		this.pageDeConnexion.add(zoneTexte);
		this.pageDeConnexion.add(boutonConnexion);
		this.pageDeConnexion.add(retourPageAccueil);
		this.pageDeConnexion.setBackground(Color.CYAN);
		
		
      //pour les aligner/organiser correctement la page de connexion
        Box AlignementPageConnexion = Box.createVerticalBox();
		AlignementPageConnexion.add(labelAccueilConnexion);
		AlignementPageConnexion.add(labelLogin);
		AlignementPageConnexion.add(zoneTexte2);
		AlignementPageConnexion.add(labelPassWord);
		AlignementPageConnexion.add(zoneTexte);
		AlignementPageConnexion.add(boutonConnexion);
		AlignementPageConnexion.add(retourPageAccueil);
		AlignementPageConnexion.add(Box.createVerticalGlue());
        this.pageDeConnexion.add(AlignementPageConnexion);
       // setLocationRelativeTo(this.getParent());
		
/**
 * Les listeners
 */
      //bouton retour page accueil pour le bouton de la page recherche pour acc�der au panel d'accueil
        retourPageAccueilRCH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic) {
				dispose();
				String[] args= null;
				AfficherIHM.main(args);
			}
		});
      //bouton retour page accueil pour acc�der au panel d'accueil
        retourPageAccueil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic) {
				dispose();
				String[] args= null;
				AfficherIHM.main(args);				
			}
		});
      //bouton RCH (recherche) pour acc�der au panel de recherche
        boutonRCH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToSearchPanel();
			}
		});
      //bouton admin pour acc�der au panel de connection
        boutonAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToConnectionPanel();
			}
		});
        //menu connecter pour acc�der au panel de connection
		menuConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clic){
				GoToConnectionPanel();
			}
		});
		
		// le listener sur le sous-menu quitter//
				menuQuitter.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e){
						CloseWindow();
					}
				});
		
		
	    content.setBackground(Color.white);
		content.setLayout(cardL);
		content.add(pageGenerale);
		content.add(pageRecherche);
		content.add(pageDeConnexion);
		
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
    	this.setContentPane(this.pageDeConnexion);
    	pageDeConnexion.setVisible(true);
    }
    
    public void GoToSearchPanel(){
    	repaint();
    	this.setContentPane(this.pageRecherche);
    	pageRecherche.setVisible(true);
    }
}
 



