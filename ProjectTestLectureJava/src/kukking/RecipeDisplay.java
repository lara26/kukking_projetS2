package kukking;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;




public class RecipeDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	public final static String sourcePath = "./receipts.xls";
	
	public RecipeDisplay(Recipe recipeToDisplay){

		JPanel recipe = this;
		recipe.setLayout(new GridBagLayout());
		
		JLabel title = new JLabel(recipeToDisplay.getNameRecipe());

		int nbbpers = recipeToDisplay.getNbPers();
		JLabel nbpers = new JLabel(Integer.toString(nbbpers));
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
	/* titre */
		gbc.gridx=3;
		gbc.gridy=0;
		recipe.add(title, gbc);
	
	/* personnes */
		gbc.gridx=4;
		gbc.gridy=1;
		recipe.add(nbpers,gbc);
		gbc.gridx=5;
		gbc.gridy=1;
		recipe.add(new JLabel(" personnes"),gbc);
		
	/* ingredients */
		gbc.gridx=0;
		gbc.gridy=4;
		recipe.add(new JLabel("Ingredients"),gbc);
		
		ArrayList<String> ingre = recipeToDisplay.getIngredients();
		ArrayList<String> qte = recipeToDisplay.getQuantities();
		ArrayList<String> unit = recipeToDisplay.getUnits();
		int i;
		for (i=0; i<ingre.size();i++){
			gbc.gridx=0;
			gbc.gridy=5+i;
			recipe.add(new JLabel(ingre.get(i)),gbc);
			gbc.gridx=1;
			gbc.gridy=5+i;
			recipe.add(new JLabel(qte.get(i)),gbc);
			gbc.gridx=2;
			gbc.gridy=5+i;
			recipe.add(new JLabel(unit.get(i)),gbc);
		}
		
	/* categories */
		gbc.gridx=3;
		gbc.gridy=4;
		recipe.add(new JLabel("Catégories"),gbc);
		
		ArrayList<String> categ = recipeToDisplay.getCategories();
		
		for(int j=0; j<categ.size(); j++){
			gbc.gridx=3;
			gbc.gridy=5+j;
			recipe.add(new JLabel(categ.get(j)), gbc);
		}
		
	/* info complementaire (tps prépa ...) */
		/* tps prepa */
		gbc.gridx=4;
		gbc.gridy=4;
		recipe.add(new JLabel("Temps de préparation"),gbc);
		gbc.gridx=5;
		gbc.gridy=4;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getPreparationTime())), gbc);
		gbc.gridx=6;
		gbc.gridy=4;
		recipe.add(new JLabel(" min"),gbc);
		
		/* tps cuisson */
		gbc.gridx=4;
		gbc.gridy=5;
		recipe.add(new JLabel("Temps de cuisson"), gbc);
		gbc.gridx=5;
		gbc.gridy=5;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getCookingTime())), gbc);
		gbc.gridx=6;
		gbc.gridy=5;
		recipe.add(new JLabel(" min"), gbc);
		
		/* cout */
		gbc.gridx=4;
		gbc.gridy=6;
		recipe.add(new JLabel("Cout"), gbc);
		gbc.gridx=5;
		gbc.gridy=6;
		recipe.add(new JLabel(recipeToDisplay.getCost()), gbc);
		gbc.gridx=6;
		gbc.gridy=6;
		recipe.add(new JLabel(" €"), gbc);
		
	/* preparation */
		gbc.gridx=3;
		gbc.gridy=7+i;
		recipe.add(new JLabel("Preparation"), gbc);
		ArrayList<String> prepa = recipeToDisplay.getPreparation();
		int k;
		for( k=0; k<prepa.size(); k++){
			gbc.gridx=3;
			gbc.gridy=(8+i)+k;
			recipe.add(new JLabel(prepa.get(k)), gbc);
		}
		gbc.gridx=3;
		gbc.gridy=(9+i)+k;
		recipe.add(new JLabel("Bon appetit !"), gbc);
	}	
}
