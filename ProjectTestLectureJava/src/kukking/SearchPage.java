package kukking;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import AffichageIHMDebut.AfficherIHM;


public class SearchPage extends JPanel {

	private static final long serialVersionUID = 1L;
	JRadioButton easy = new JRadioButton("Facile");
	JRadioButton medium = new JRadioButton("Moyen");
	JRadioButton hard = new JRadioButton("Difficile");
	JButton returnHomePage = new JButton("Retour à la page d'accueil");
	JButton buttonSearch = new JButton("Rechercher");
	KukkingDisplay kukkingFrame;
	
	public SearchPage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JPanel searchPage = this;
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel search = new JLabel("Recherche");
		search.setFont(new Font("Dom", Font.PLAIN, 50));
		
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectHard();
			}
		});
		
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectMeduim();
			}
		});
		
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				RadioSelectEasy();
			}
		});
		
		
		
		
		JTextField nbPers = new JTextField("");
		
		JComboBox<String> typeCuisine = new JComboBox<String>();
		
		typeCuisine.addItem("Recettes végétariennes");
		typeCuisine.addItem("Recettes sans gluten");
		typeCuisine.addItem("Recettes asiatiques");
		typeCuisine.addItem("Recettes classiques");
		typeCuisine.addItem("Recettes étudiante");
		
		typeCuisine.addItem("Recettes fête");
		
		typeCuisine.addItem("Tous type de recettes");
		
		JComboBox<String> typePlat = new JComboBox<String>();
		
		typePlat.addItem("Entrée");
		typePlat.addItem("Plat chaud");
		typePlat.addItem("Dessert");
		typePlat.addItem("Cocktails");
		typePlat.addItem("Tous les plats");
		
		Box nvcuissine = Box.createHorizontalBox();
		nvcuissine.add(easy);
		nvcuissine.add(medium);
		nvcuissine.add(hard);
		
		Box nbPersonne = Box.createHorizontalBox();
		nbPersonne.add(new JLabel("Entrer le nombre de personne :"));
		nbPersonne.add(nbPers);
		
		Box title = Box.createHorizontalBox();
		title.add(kukkingLogo);
		title.add(Box.createHorizontalStrut(50));
		title.add(search);
		
		Box searchPageBox = Box.createVerticalBox();
		searchPageBox.add(title);
		searchPageBox.add(new JLabel("Veuillez choisir un niveau de cuisine :"));
		searchPageBox.add(nvcuissine);
		searchPageBox.add(new JLabel("Veuillez choisir un type de cuisine :"));
		searchPageBox.add(typeCuisine);
		searchPageBox.add(new JLabel("Veuillez choisir un type de plat :"));
		searchPageBox.add(typePlat);
		searchPageBox.add(nbPersonne);
		searchPageBox.add(buttonSearch);
		searchPageBox.add(returnHomePage);
		
		searchPage.add(searchPageBox);
		
		returnHomePage.addActionListener(kukkingFrame);
		
		
		
		
		

	    //bouton RCH (recherche) pour accéder au panel de recherche
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent onselect){
				
				SwingUtilities.invokeLater(new displayfenetretest());
				
				
			}
		});
		
	}
	
	
	/* Les méthodes */
	public void RadioSelectEasy(){
    	if(medium.isSelected())
    	{
    		medium.setSelected(false);
    	}
    	if (hard.isSelected())
    	{
    		hard.setSelected(false);
    	}
    }
    
    public void RadioSelectMeduim(){
    	if(easy.isSelected())
    	{
    		easy.setSelected(false);
    	}
    	if (hard.isSelected())
    	{
    		hard.setSelected(false);
    	}
    }
    public void RadioSelectHard()
    {
    	if(easy.isSelected())
    	{
    		easy.setSelected(false);
    	}
    	if (medium.isSelected())
    	{
    		medium.setSelected(false);
    	}
    } 
    
    

}
