package kukking;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchPage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public SearchPage(){
		JPanel searchPage = this;
		
		JLabel search = new JLabel("Recherche");
		search.setFont(new Font("Dom", Font.PLAIN, 20));
		
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
		
		Box verticale = Box.createVerticalBox();
		verticale.add(search);
		verticale.add(new JLabel("Veuillez choisir un niveau de cuisine :"));
		verticale.add(nvcuissine);
		//verticale.add(new JLabel("Effectuer la recherche..."));
		verticale.add(new JLabel("Veuillez choisir un type de cuisine :"));
		verticale.add(typeCuisine);
		verticale.add(new JLabel("Veuillez choisir un type de plat :"));
		verticale.add(typePlat);
		verticale.add(new JLabel("Entrer le nombre de personne :"));
		verticale.add(nbPers);

		
		
	
	/*
		searchPage.add(labelPersonne);
		searchPage.add(zoneTexteP);
		searchPage.add(labelRendom);
		searchPage.add(boutonRecherche);
		searchPage.add(retourPageAccueilRCH);
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
		        searchPage.add(AlignementPageRecherche);*/
		
		searchPage.add(verticale);
		
	}

}
