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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;


public class RecipeDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	public final static String sourcePath = "./receipts.xls";
	
	public RecipeDisplay(Recipe recipeToDisplay){

		JPanel recipeD = this;
		JLabel title = new JLabel(recipeToDisplay.getNameRecipe());
		JLabel ingredient = new JLabel("Ingrédients");
		JLabel preparation = new JLabel("Préparation");
		JLabel preparationTime = new JLabel("Temps de préparation");
		int nbbpers = recipeToDisplay.getNbPers();
		JLabel nbpers = new JLabel(Integer.toString(nbbpers));
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		
		Box title2 = Box.createHorizontalBox();
		title2.add(title);
		
		
		Box pers = Box.createHorizontalBox();
		pers.add(nbpers);
		pers.add(new JLabel(" personnes"));
		
	/* ingredients */
		JPanel yahou = new JPanel();
			
		ArrayList<String> ingre = recipeToDisplay.getIngredients();
		ArrayList<String> qte = recipeToDisplay.getQuantities();
		
		for (int i=0; i<ingre.size();i++){
			yahou.add(new JLabel(ingre.get(i)));
			yahou.add(new JLabel(qte.get(i)));
		}
		
		Box ingredients = Box.createVerticalBox();
		ingredients.add(ingredient);
		ingredients.add(yahou);
	/* info complementaire (tps prépa ...) */
		JPanel yahou2 = new JPanel();
		yahou2.add(preparationTime);
		
		/*JLabel cout = new JLabel(recipeToDisplay.getCost());
		yahou2.add(cout);*/
		
		Box infoComplementaire = Box.createVerticalBox();
		infoComplementaire.add(yahou2);
	/* preparation */
		JPanel yahou3 = new JPanel();
		yahou3.add(preparation);
		
		Box preparations = Box.createHorizontalBox();
		preparations.add(yahou3);
		
		
		
		
		
		
		
		
		
		
		Box recipeTot = Box.createVerticalBox();
		recipeTot.add(title2);
		recipeTot.add(pers);
		recipeTot.add(ingredients);
		recipeTot.add(infoComplementaire);
		recipeTot.add(preparations);
		
		recipeD.add(recipeTot);
		
		
		
		
		
	}
	
	
	
	
	

}
