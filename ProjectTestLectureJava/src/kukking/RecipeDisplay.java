package kukking;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RecipeDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	public RecipeDisplay(Recipe recipeToDisplay){

		JPanel recipe = this;
		recipe.setLayout(new GridBagLayout());
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));

		JLabel title = new JLabel(recipeToDisplay.getNameRecipe());
		JLabel ingredient = new JLabel("Ingredients");
		//JLabel categorie = new JLabel("Catégories");
		JLabel tempsPrepa = new JLabel("Temps de préparation");
		JLabel tempsCuisson = new JLabel("Temps de cuisson");
		JLabel cout = new JLabel("Coût");
		JLabel preparation = new JLabel("Préparation");
		JLabel bonApp = new JLabel("Bon appétit !");
		
		

		GridBagConstraints gbc = new GridBagConstraints();
		
	/* logo */
		gbc.gridx=0;
		gbc.gridy=0;
		recipe.add(kukkingLogo,gbc);
		
		
	/* titre */
		title.setFont(new Font("Dom", Font.PLAIN, 50));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=8;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;
		recipe.add(title, gbc);
	
	/* personnes */
		gbc.gridx=7;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getNbPers())),gbc);
		gbc.gridx=8;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" personnes"),gbc);
		
	/* ingredients */
		ingredient.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=4;
		recipe.add(ingredient,gbc);
		
		ArrayList<String> ingre = recipeToDisplay.getIngredients();
		ArrayList<String> qte = recipeToDisplay.getQuantities();
		ArrayList<String> unit = recipeToDisplay.getUnits();
		
		int i;
		for (i=0; i<ingre.size();i++){
			gbc.gridx=0;
			gbc.gridy=5+i;
			gbc.anchor = GridBagConstraints.WEST;
			recipe.add(new JLabel(ingre.get(i)),gbc);
			gbc.gridx=1;
			gbc.gridy=5+i;
			gbc.anchor = GridBagConstraints.CENTER;
			recipe.add(new JLabel(qte.get(i)),gbc);
			gbc.gridx=2;
			gbc.gridy=5+i;
			gbc.ipadx=5;
			recipe.add(new JLabel(unit.get(i)),gbc);
		}
		
	/* categories */
		/*categorie.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=4;
		gbc.gridy=4;
		recipe.add(categorie,gbc);
		
		ArrayList<String> categ = recipeToDisplay.getCategories();
		
		for(int j=0; j<categ.size(); j++){
			gbc.gridx=4;
			gbc.gridy=5+j;
			recipe.add(new JLabel(categ.get(j)), gbc);
		}*/
		
	/* info complementaire (tps prépa ...) */
		/* tps prepa */
		tempsPrepa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(tempsPrepa,gbc);
		gbc.gridx=7;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getPreparationTime())), gbc);
		gbc.gridx=8;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" min"),gbc);
		
		/* tps cuisson */
		tempsCuisson.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(tempsCuisson, gbc);
		gbc.gridx=7;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getCookingTime())), gbc);
		gbc.gridx=8;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" min"), gbc);
		
		/* cout */
		cout.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=8;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(cout, gbc);
		gbc.gridx=7;
		gbc.gridy=8;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(recipeToDisplay.getCost()), gbc);
		gbc.gridx=8;
		gbc.gridy=8;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" €"), gbc);
		
	/* preparation */
		preparation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=0;
		gbc.gridy=9+i;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(50, 0, 0, 0);
		recipe.add(preparation, gbc);
		ArrayList<String> prepa = recipeToDisplay.getPreparation();
		int k;
		for( k=0; k<prepa.size(); k++){
			gbc.gridx=0;
			gbc.gridy=(10+i)+k;
			gbc.gridwidth=GridBagConstraints.REMAINDER;
			gbc.insets = new Insets(5, 0, 0, 0);
			recipe.add(new JLabel(prepa.get(k)), gbc);
		}
		bonApp.setFont(new Font("Curlz MT", Font.PLAIN, 30));
		gbc.gridx=0;
		gbc.gridy=(12+i)+k;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		recipe.add(bonApp, gbc);
	}	
}
