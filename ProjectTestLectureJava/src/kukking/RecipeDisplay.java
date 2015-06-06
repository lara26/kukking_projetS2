package kukking;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RecipeDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	public final static String sourcePath = "./receipts.xls";
	
	public RecipeDisplay(Recipe recipeToDisplay){

		JPanel recipe = this;
		recipe.setLayout(new GridBagLayout());
		
		JLabel title = new JLabel(recipeToDisplay.getNameRecipe());


		title.setFont(new Font("Courier New", Font.BOLD, 30));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
	/* titre */
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		recipe.add(title, gbc);
	
	/* personnes */
		
		gbc.gridx=
				5;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getNbPers())),gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx=6;
		gbc.gridy=1;
		recipe.add(new JLabel(" personnes"),gbc);
		
	/* ingredients */
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=4;
		recipe.add(new JLabel("Ingredients"),gbc);
		
		ArrayList<String> ingre = recipeToDisplay.getIngredients();
		ArrayList<String> qte = recipeToDisplay.getQuantities();
		ArrayList<String> unit = recipeToDisplay.getUnits();
		
		int i;
		for (i=0; i<ingre.size();i++){
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx=0;
			gbc.gridy=5+i;
			recipe.add(new JLabel(ingre.get(i)),gbc);
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx=1;
			gbc.gridy=5+i;
			recipe.add(new JLabel(qte.get(i)),gbc);
			gbc.gridx=2;
			gbc.gridy=5+i;
			gbc.ipadx=5;
			recipe.add(new JLabel(unit.get(i)),gbc);
		}
		
	/* categories */
		gbc.gridx=4;
		gbc.gridy=4;
		recipe.add(new JLabel("Catégories"),gbc);
		
		ArrayList<String> categ = recipeToDisplay.getCategories();
		
		for(int j=0; j<categ.size(); j++){
			gbc.gridx=4;
			gbc.gridy=5+j;
			recipe.add(new JLabel(categ.get(j)), gbc);
		}
		
	/* info complementaire (tps prépa ...) */
		/* tps prepa */
		gbc.gridx=5;
		gbc.gridy=4;
		recipe.add(new JLabel("Temps de préparation"),gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=6;
		gbc.gridy=4;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getPreparationTime())), gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx=7;
		gbc.gridy=4;
		recipe.add(new JLabel(" min"),gbc);
		
		/* tps cuisson */
		gbc.gridx=5;
		gbc.gridy=5;
		recipe.add(new JLabel("Temps de cuisson"), gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=6;
		gbc.gridy=5;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getCookingTime())), gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx=7;
		gbc.gridy=5;
		recipe.add(new JLabel(" min"), gbc);
		
		/* cout */
		gbc.gridx=5;
		gbc.gridy=6;
		recipe.add(new JLabel("Cout"), gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=6;
		gbc.gridy=6;
		recipe.add(new JLabel(recipeToDisplay.getCost()), gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx=7;
		gbc.gridy=6;
		recipe.add(new JLabel(" €"), gbc);
		
	/* preparation */
		gbc.gridx=4;
		gbc.gridy=7+i;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel("Preparation"), gbc);
		ArrayList<String> prepa = recipeToDisplay.getPreparation();
		int k;
		for( k=0; k<prepa.size(); k++){
			gbc.gridx=4;
			gbc.gridy=(8+i)+k;
			gbc.gridwidth=5;
			recipe.add(new JLabel(prepa.get(k)), gbc);
		}
		gbc.gridx=0;
		gbc.gridy=(9+i)+k;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		recipe.add(new JLabel("Bon appetit !"), gbc);
	}	
}
