package kukking;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchPage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public SearchPage(){
		JPanel searchPage = this;
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel search = new JLabel("Recherche");
		search.setFont(new Font("Dom", Font.PLAIN, 50));
		
		JRadioButton easy = new JRadioButton("Facile");
		JRadioButton medium = new JRadioButton("Moyen");
		JRadioButton hard = new JRadioButton("Difficile");
		JTextField nbPers = new JTextField("");
		
		JComboBox<String> typeCuisine = new JComboBox<String>();
		
		typeCuisine.addItem("Recettes végétariennes");
		typeCuisine.addItem("Recettes sans gluten");
		typeCuisine.addItem("Recettes asiatiques");
		typeCuisine.addItem("Recettes classiques");
		typeCuisine.addItem("Recettes étudiante");
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
		
		Box verticale = Box.createVerticalBox();
		verticale.add(title);
		verticale.add(new JLabel("Veuillez choisir un niveau de cuisine :"));
		verticale.add(nvcuissine);
		verticale.add(new JLabel("Veuillez choisir un type de cuisine :"));
		verticale.add(typeCuisine);
		verticale.add(new JLabel("Veuillez choisir un type de plat :"));
		verticale.add(typePlat);
		verticale.add(nbPersonne);
		verticale.add(new JButton("Rechercher"));
		
		searchPage.add(verticale);
		
	}

}
